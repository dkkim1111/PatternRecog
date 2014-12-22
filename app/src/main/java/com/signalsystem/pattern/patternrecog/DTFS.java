package com.signalsystem.pattern.patternrecog;

import java.util.ArrayList;

/**
 * Created by kim-donggi on 14. 12. 19..
 */
public class DTFS {

    public static final String TAG = "DTFS";

    private int x_n[][];
    private Complex X_k[][];
    private Double X_k_coeff[];
    private double radius;
    private double periodic;
    private double omega;
    private int width;
    private int height;

    public DTFS() {

    }

    public DTFS(int[][] x_n, int width, int height) {
        this.x_n = x_n;
        this.width = width;
        this.height = height;
        init();
    }

    public void init() {
        periodic = x_n.length;

        omega = 2 * Math.PI / periodic;

        setX_k();
        setRadius();
        setX_k_coeff();
    }

    public void setX_n(int[][] x_n) {
        this.x_n = x_n;
    }

    public void setX_k() {

        X_k = new Complex[width][height];

        // 초기화
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                X_k[i][j] = new Complex(0.0, 0.0);
            }
        }

        // X_K를 구하는 부분
        // 자바특성상 복소수를 사용할 수 없어서 삼각함수 및 복소수 클래스로 대체
        for (int m = 0; m < width; m++) {
            for (int n = 0; n < height; n++) {
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        Complex complex = new Complex();
                        double re = 1 / periodic * x_n[x][y] *
                                            (
                                            Math.cos(m * omega * x) * Math.cos(m * omega * y)
                                                -
                                            Math.sin(m * omega * x) * Math.sin(m * omega * y)
                                            );
                        double im = -1 / periodic * x_n[x][y] *
                                        (
                                        Math.cos(m * omega * x) * Math.sin(m * omega * y)
                                                +
                                        Math.sin(m * omega * x) * Math.cos(m * omega * y)
                                        );

                        complex.setRe(re);
                        complex.setIm(im);
                        X_k[m][n] = Complex.add(X_k[m][n], complex);
                    }
                }
            }
        }
    }

    public Complex[][] getX_k() {
        return X_k;
    }

    public int[][] getX_n() {
        return x_n;
    }

    public void setRadius() {
        double sum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sum += Math.pow(X_k[i][j].getAbsol(), 2);
            }
        }

        radius = Math.sqrt(sum);
    }

    public double getRadius() {
        return radius;
    }

    public Double[] getX_k_coeff() {
        return X_k_coeff;
    }

    public void setX_k_coeff() {
        X_k_coeff = new Double[width * height];

        // 2차원 X_K를 coefficients만 추출하여 샘플 배열에 1차원으로 담는다.
        ArrayList<Double> list = new ArrayList<Double>();
        for (int j = 0, x_k_len = X_k.length; j < x_k_len; j++) {
            for(int k = 0, sub_x_k_len = X_k[j].length; k < sub_x_k_len; k++){
                list.add(X_k[j][k].getAbsol());
            }
        }

        X_k_coeff = list.toArray(new Double[0]);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
