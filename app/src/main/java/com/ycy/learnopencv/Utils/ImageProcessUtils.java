package com.ycy.learnopencv.Utils;

import android.graphics.Bitmap;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 * Created by kimi9 on 2018/2/23.
 */

public class ImageProcessUtils {

    private static Mat sSrc = new Mat();
    private static Mat sDst = new Mat();
    private static int sWidth; //width
    private static int sHeight;  //height
    private static int sRow; //Row--height
    private static int sCol; //col--width
    private static int sIndex;

    //ARGB values
    private static int sA = 0;
    private static int sR = 0;
    private static int sG = 0;
    private static int sB = 0;
    private static int[] sPixels;
    private static int sPixel = 0;

    public static Bitmap covert2Gray(Bitmap bitmap) {
        org.opencv.android.Utils.bitmapToMat(bitmap, sSrc);//convert Bitmap to mat
        Imgproc.cvtColor(sSrc, sDst, Imgproc.COLOR_BGRA2GRAY);
        org.opencv.android.Utils.matToBitmap(sDst, bitmap);
        sSrc.release();
        sDst.release();
        return bitmap;
    }

    public static Bitmap invertMat(Bitmap bitmap) {

        org.opencv.android.Utils.bitmapToMat(bitmap, sSrc);

        //pixel operation
        //width of mat
        sWidth = sSrc.cols();
        //height of mat
        sHeight = sSrc.rows();
        int cnum = sSrc.channels();//Get channel

        byte[] bgra = new byte[cnum];//ARGB(Bitmap)-->BGRA(mat)

        for (sRow = 0; sRow < sHeight; sRow++) {
            for (sCol = 0; sCol < sWidth; sCol++) {
                sSrc.get(sRow, sCol, bgra);
                for (sIndex = 0; sIndex < cnum; sIndex++) {
                    bgra[sIndex] = (byte) (255 - bgra[sIndex] & 0xff);
                }
                sSrc.put(sRow, sCol, bgra);
            }
        }
        org.opencv.android.Utils.matToBitmap(sSrc, bitmap);
        sSrc.release();

        return bitmap;
    }

    public static Bitmap invertBitmap(Bitmap bitmap) {
        sWidth = bitmap.getWidth();
        sHeight = bitmap.getHeight();
        sPixels = new int[sWidth * sHeight];
        bitmap.getPixels(sPixels, 0, sWidth, 0, 0, sWidth, sHeight);

        sIndex = 0;
        for (sRow = 0; sRow < sHeight; sRow++) {
            sIndex = sRow * sWidth;
            for (sCol = 0; sCol < sWidth; sCol++) {
                sPixel = sPixels[sIndex];
                sA = (sPixel >> 24) & 0xff;
                sR = (sPixel >> 16) & 0xff;
                sG = (sPixel >> 8) & 0xff;
                sB = sPixel & 0xff;

                sR = 255 - sR;
                sG = 255 - sG;
                sB = 255 - sB;

                sPixel = ((sA & 0xff) << 24 | (sR & 0xff) << 16 | (sG & 0xff) << 8 | sB & 0xff);

                sPixels[sIndex] = sPixel;

                sIndex++;
            }
        }
        bitmap.setPixels(sPixels, 0, sWidth, 0, 0, sWidth, sHeight);
        return bitmap;
    }

    public static void contrast_ratio_adjust(Bitmap bitmap) {
        org.opencv.android.Utils.bitmapToMat(bitmap, sSrc);
        Mat whiteImage = new Mat(sSrc.size(), sSrc.type(), Scalar.all(2));//Contrast Ratio
        Mat bwImage = new Mat(sSrc.size(), sSrc.type(), Scalar.all(30));//Brightness+30
        Core.multiply(whiteImage, sSrc, sSrc);
        Core.add(bwImage, sSrc, sSrc);
        org.opencv.android.Utils.matToBitmap(sSrc, bitmap);
        sSrc.release();
    }
}
