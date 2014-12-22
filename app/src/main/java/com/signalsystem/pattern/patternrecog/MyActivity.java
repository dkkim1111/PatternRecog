package com.signalsystem.pattern.patternrecog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.signalsystem.pattern.patternrecog.pattern.Pattern1;
import com.signalsystem.pattern.patternrecog.pattern.Pattern10;
import com.signalsystem.pattern.patternrecog.pattern.Pattern2;
import com.signalsystem.pattern.patternrecog.pattern.Pattern3;
import com.signalsystem.pattern.patternrecog.pattern.Pattern4;
import com.signalsystem.pattern.patternrecog.pattern.Pattern5;
import com.signalsystem.pattern.patternrecog.pattern.Pattern6;
import com.signalsystem.pattern.patternrecog.pattern.Pattern7;
import com.signalsystem.pattern.patternrecog.pattern.Pattern8;
import com.signalsystem.pattern.patternrecog.pattern.Pattern9;
import com.signalsystem.pattern.patternrecog.pattern.PatternSampling;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class MyActivity extends Activity {
    ImageView iv, rank1_iv;

    TextView info, rank1_info;

    DTFS dtfs;

    PatternSampling pattern1, pattern2, pattern3, pattern4, pattern5, pattern6, pattern7, pattern8, pattern9, pattern10;

    ViewGroup ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        iv = (ImageView) findViewById(R.id.imageview);

        info = (TextView) findViewById(R.id.info);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForPhoto(200);
            }
        });

        ranking = (ViewGroup) findViewById(R.id.ranking);

        rank1_iv = (ImageView) findViewById(R.id.rank1_image);

        rank1_info = (TextView) findViewById(R.id.rank1_info);

        final ProgressDialog dialog = new ProgressDialog(MyActivity.this);
        dialog.setCancelable(false);
        dialog.setMessage("setting Pattern db..");

        dialog.show();
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                patternInit();
                dialog.dismiss();
            }
        }, 500);
        pattern1 = new Pattern1();
        pattern2 = new Pattern2();
        pattern3 = new Pattern3();
        pattern4 = new Pattern4();
        pattern5 = new Pattern5();
        pattern6 = new Pattern6();
        pattern7 = new Pattern7();
        pattern8 = new Pattern8();
        pattern9 = new Pattern9();
        pattern10 = new Pattern10();

        pattern1.init();
        pattern2.init();
        pattern3.init();
        pattern4.init();
        pattern5.init();
        pattern6.init();
        pattern7.init();
        pattern8.init();
        pattern9.init();
        pattern10.init();

    }


    // 패턴을 DB화 할 때 사용
    private void patternInit() {
//        ProgressDialog dialog = new ProgressDialog(MyActivity.this);
//        dialog.setCancelable(false);
//        dialog.setMessage("Pattern DB settings..");
//        dialog.show();
//        pattern10.sampling(getApplicationContext());
//
//        Double[] center = pattern10.getCenter();
//
//        String str = "";
//        for (int i = 0; i < center.length; i++) {
//            str = str + center[i] + ", ";
//        }
//        Intent it = new Intent(Intent.ACTION_SEND);
//        it.putExtra(Intent.EXTRA_EMAIL, "dkkim1111@naver.com");
//        it.putExtra(Intent.EXTRA_TEXT, "Pattern10" + "\n" + str);
//        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        it.setType("text/plain");
//        startActivity(Intent.createChooser(it, "Choose Email Client"));
//
//        dialog.dismiss();
    }

    private void update(String className, double radius) {
        info.setText("This Pattern is \"" + className + "\"");

        try {
            Class klass = Class.forName("com.signalsystem.pattern.patternrecog.pattern." + className);
            Object obj = klass.newInstance();
            ((PatternSampling) obj).init();

            int id = ((PatternSampling) obj).sample_images[0];

            rank1_iv.setImageResource(id);
            rank1_info.setText("radius from center : " + radius);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200) {
            handlePhotoFromPicker(resultCode, data);
        }
    }

    /**
     * @param resultCode
     * @param data
     */
    private void handlePhotoFromPicker(int resultCode, Intent data) {

        if (data == null || data.getData() == null) {
            // user did not choose any; simply return out
            return;
        }

        Uri uri = data.getData();

        final Cursor cursor = getContentResolver().query(
                uri,
                new String[]{MediaStore.Images.ImageColumns.DATA},
                null, null, null
        );

        if (cursor != null) {
            cursor.moveToFirst();
            final String path = cursor.getString(0);

            handleImagePath(path);
        }
    }

    private void handleImagePath(String path) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);

        iv.setImageURI(Uri.fromFile(new File(path)));

        int x_n[][] = getXnFromBitmap(bitmap);

        dtfs = new DTFS(x_n, bitmap.getWidth(), bitmap.getHeight());

        patternCheck();
    }

    private void patternCheck() {
        HashMap<String, Double> radiuses = new HashMap<String, Double>();
        double radius1 = pattern1.getGapRadius(dtfs.getX_k_coeff());

        if (pattern1.isBound(radius1)) {
            radiuses.put("Pattern1", radius1);
        }
        double radius2 = pattern2.getGapRadius(dtfs.getX_k_coeff());
        if (pattern2.isBound(radius2)) {
            radiuses.put("Pattern2", radius2);
        }
        double radius3 = pattern3.getGapRadius(dtfs.getX_k_coeff());
        if (pattern3.isBound(radius3)) {
            radiuses.put("Pattern3", radius3);
        }
        double radius4 = pattern4.getGapRadius(dtfs.getX_k_coeff());
        if (pattern4.isBound(radius4)) {
            radiuses.put("Pattern4", radius4);
        }
        double radius5 = pattern5.getGapRadius(dtfs.getX_k_coeff());
        if (pattern5.isBound(radius5)) {
            radiuses.put("Pattern5", radius5);
        }
        double radius6 = pattern6.getGapRadius(dtfs.getX_k_coeff());
        if (pattern6.isBound(radius6)) {
            radiuses.put("Pattern6", radius6);
        }
        double radius7 = pattern7.getGapRadius(dtfs.getX_k_coeff());
        if (pattern7.isBound(radius7)) {
            radiuses.put("Pattern7", radius7);
        }
        double radius8 = pattern8.getGapRadius(dtfs.getX_k_coeff());
        if (pattern8.isBound(radius8)) {
            radiuses.put("Pattern8", radius8);
        }
        double radius9 = pattern9.getGapRadius(dtfs.getX_k_coeff());
        if (pattern9.isBound(radius9)) {
            radiuses.put("Pattern9", radius9);
        }
        double radius10 = pattern10.getGapRadius(dtfs.getX_k_coeff());
        if (pattern10.isBound(radius10)) {
            radiuses.put("Pattern10", radius10);
        }

        if (radiuses.size() == 0) {
            info.setText("패턴을 찾지 못했습니다.");
            ranking.setVisibility(View.GONE);
        } else {
            ranking.setVisibility(View.VISIBLE);

            Map.Entry<String, Double> minEntry = null;
            for (Map.Entry<String, Double> entry : radiuses.entrySet()){
                if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0){
                    minEntry = entry;
                }
            }

            update(minEntry.getKey(), minEntry.getValue());
        }

    }

    private void startActivityForPhoto(int actionCode) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        } else {
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
        }

        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "Select Picture"), actionCode);
    }

    private int[][] getXnFromBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int x_n[][] = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                x_n[i][j] = bitmap.getPixel(i, j);
            }
        }

        return x_n;
    }
}
