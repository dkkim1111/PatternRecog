package com.signalsystem.pattern.patternrecog;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageIO {

    private static String getAlbumName() {
        return Constants.ALBUM_NAME;
    }

    private static File getAlbumDir() {
        File sdDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return new File(sdDir, getAlbumName());
    }

    public static File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = Constants.JPEG_FILE_PREFIX + timeStamp + "_";

        File dir = getAlbumDir();
        if (!dir.exists()) {
            dir.mkdir();
        }

        File image = File.createTempFile(imageFileName, Constants.JPEG_FILE_SUFFIX, dir);

        return image;
    }

    public static File saveBitmap(Bitmap bitmap) throws IOException {
        File imageFile = createImageFile();

        FileOutputStream out = new FileOutputStream(imageFile);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        out.close();


        return imageFile;
    }

    public static void makeMaskImage(ImageView imageView, Bitmap orig, Bitmap mask, int backgroundResource) {

        Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Bitmap.Config.ARGB_8888);

        int bound = mask.getWidth(); // assume we have a circle
        Bitmap scaled = Bitmap.createScaledBitmap(orig, bound, bound, false);

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(scaled, 0, 0, null);
        canvas.drawBitmap(mask, 0, 0, paint);
        paint.setXfermode(null);

        imageView.setImageBitmap(result);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setBackgroundResource(backgroundResource);
    }
}
