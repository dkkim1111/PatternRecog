package com.signalsystem.pattern.patternrecog.pattern;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.signalsystem.pattern.patternrecog.Complex;
import com.signalsystem.pattern.patternrecog.DTFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kim-donggi on 14. 12. 23..
 */
public abstract class PatternSampling {
    public static String TAG = "PatternSampling";

    public int[] sample_images;

    public Double[][] sample_coeff;

    public Double[] center;

    public double radius;

    public void init() {
    }

    public void sampling(Context context) {

        // 처음 Pattern을 DB화 할때 필요
        for (int i = 0, len = sample_images.length; i < len; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), sample_images[i]);

            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            int x_n[][] = new int[width][height];
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    x_n[j][k] = bitmap.getPixel(j, k);
                }
            }

            DTFS dtfs = new DTFS(x_n, width, height);

            Complex[][] X_k = dtfs.getX_k();

            Double[] pre_sample = dtfs.getX_k_coeff();

            sample_coeff[i] = pre_sample;
        }

        setCenter();
        setRadius();
    }

    private void setCenter() {
        center = new Double[sample_coeff[0].length];

        //초기화
        for (int i = 0; i < center.length; i++) {
            center[i] = 0.0;
        }

        for (int i = 0; i < center.length; i++) {
            for (int j = 0; j < sample_images.length; j++) {
                Double[] sample_target;

                sample_target = sample_coeff[j];

                center[i] += sample_target[i];
            }
        }

        for (int i = 0; i < center.length; i++) {
            center[i] /= sample_images.length;
        }
    }

    /**
     * setCenter 함수가 실행된 후에 실행되어야 한다.
     */
    private void setRadius() {
        Log.e(TAG, "setRadius");
        Double[] candidateRadius = new Double[sample_images.length];

        for (int i = 0; i < sample_images.length; i++) {

            Double[] sample_target = sample_coeff[i];

            double sum = 0;
            for (int j = 0, len = sample_target.length; j < len; j++) {
                double gap = sample_target[j] - center[j];
                sum += Math.sqrt(Math.pow(gap, 2));
            }
            candidateRadius[i] = sum;
        }

        List<Double> d = Arrays.asList(candidateRadius);

        radius = Collections.max(d);

        Log.e("radius", radius + "");
        Log.e("radius min", Collections.min(d) + "");

    }

    /**
     * 바운더리에 들어오는지 확인
     * @param _radius
     * @return
     */
    public boolean isBound(double _radius) {
        return (_radius <= radius);
    }

    public boolean isBound(Double[] X_k_coeff) {
        double _radius = getGapRadius(X_k_coeff);
        return isBound(_radius);
    }

    public double getGapRadius(Double[] X_k_coeff) {
        double _radius = 0;
        for (int i = 0, len = X_k_coeff.length; i < len; i++) {
            double gap = center[i] - X_k_coeff[i];
            _radius += Math.pow(gap, 2);
        }

        return Math.sqrt(_radius);
    }

    public Double[] getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
}
