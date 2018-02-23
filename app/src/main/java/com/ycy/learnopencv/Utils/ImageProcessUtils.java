package com.ycy.learnopencv.Utils;

import android.graphics.Bitmap;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 * Created by kimi9 on 2018/2/23.
 */

public class ImageProcessUtils {

    private static Mat sSrc = new Mat();
    private static Mat sDst = new Mat();

    public static Bitmap covert2Gray(Bitmap bitmap) {
        org.opencv.android.Utils.bitmapToMat(bitmap, sSrc);//转换图像为Mat
        Imgproc.cvtColor(sSrc, sDst, Imgproc.COLOR_BGRA2GRAY);
        org.opencv.android.Utils.matToBitmap(sDst, bitmap);
        sSrc.release();
        sDst.release();
        return bitmap;
    }

    public static Bitmap invertMat(Bitmap bitmap) {

        org.opencv.android.Utils.bitmapToMat(bitmap, sSrc);

        //pixel operation
        int width = sSrc.cols();//宽
        int hight = sSrc.rows();//高
        int cnum = sSrc.channels();//获取通道

        byte[] bgra = new byte[cnum];//ARGB(Bitmap)-->BGRA(mat)

        for (int row = 0; row < hight; row++) {
            for (int col = 0; col < width; col++) {
                sSrc.get(row, col, bgra);
                for (int i = 0; i < cnum; i++) {
                    bgra[i] = (byte) (255 - bgra[i] & 0xff);
                }
                sSrc.put(row, col, bgra);
            }
        }
        org.opencv.android.Utils.matToBitmap(sSrc, bitmap);
        sSrc.release();

        return bitmap;
    }
}
