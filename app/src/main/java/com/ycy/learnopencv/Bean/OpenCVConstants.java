package com.ycy.learnopencv.Bean;

/**
 * Created by kimi9 on 2018/2/22.
 */

public class OpenCVConstants {

    //灰度图形
    public static String GRAY_TEST_NAME = "Image to gray";
    public static String GREY_TEST_COM = "Gray Level Image";

    //Mat图像反色
    public static String MAT_PIXEL_INVERT_NAME = "Convert:Mat";
    public static String MAT_PIXEL_INVERT_COM = "Convert image in Mat";

    //Bitmap图像反色
    public static String BITMAP_PIXEL_INVERT_NAME = "Convert:Bitmap";
    public static String BITMAP_PIXEL_INVERT_COM = "Convert image in Bitmap";

    //调整亮度、对比度
    public static String CONTRAST_RATIO_BRIGHTNESS_NAME = "Adjust CM&BR";
    public static String CONTRAST_RATIO_BRIGHTNESS_COM = "Adjust contrast ratio and brightness";

    //创建mat空白图像
    public static String IMAGE_CONTAINER_MAT_NAME = "Mat Operation";
    public static String IMAGE_CONTAINER_MAT_COM = "Image Container: Mat, create a new image of mat";

    //子图操作
    public static String GET_ROI_NAME = "ROI Operation";
    public static String GET_ROI_COM = "Get sub image";

    //均值滤波
    public static String BOX_BLUR_IMAGE_NAME = "Box Blur";
    public static String BOX_BLUR_IMAGE_COM = "Blur learning: Box Blur";

    //高斯滤波
    public static String GAUSSIAN_BLUR_IMAGE_NAME = "GAUSSIAN Blur";
    public static String GAUSSIAN_BLUR_IMAGE_COM = "Blur learning: GAUSSIAN Blur";

    //双边滤波
    public static String BILATERAL_BLUR_IMAGE_NAME = "Bilateral Blur";
    public static String BILATERAL_BLUR_IMAGE_COM = "Blur learning: Bilateral Blur";

    //自定义模糊
    public static String CUSTOM_BLUR_NAME = "Custom Blur";
    public static String CUSTOM_BLUR_COM = "Blur Operation";

    //自定义边缘提取
    public static String CUSTOM_EDGE_NAME = "Custom Edge";
    public static String CUSTOM_EDGE_COM = "Edge Operation";

    //自定义锐化处理
    public static String CUSTOM_SHARPEN_NAME = "Custom Sharpen";
    public static String CUSTOM_SHARPEN_COM = "Sharpen Operation";

    //腐蚀
    public static String ERODE_NAME = "Erode";
    public static String ERODE_COM = "Learning Erode";

    //膨胀
    public static String DILATE_NAME = "Dilate";
    public static String DILATE_COM = "Learning Dilate";

    //开操作
    public static String OPEN_OPERATION_NAME = "Open Operation";
    public static String OPEN_OPERATION_COM = "Learning Open Operation";

    //闭操作
    public static String CLOSE_OPERATION_NAME = "Close Operation";
    public static String CLOSE_OPERATION_COM = "Learning Close Operation";

    //形态学直线检测
    public static String MORPH_LINE_OPERATION_NAME = "Line Detection";
    public static String MORPH_LINE_OPERATION_COM = "形态学直线检测";

    //阈值二值化
    public static String THRESH_BINARY_NAME = "Thresh Binary";
    public static String THRESH_BINARY_COM = "Thresh Binary Operation";

    //阈值反二值化
    public static String THRESH_BINARY_INV_NAME = "Thresh Binary Inverse";
    public static String THRESH_BINARY_INV_COM = "Thresh Binary Inverse Operation";

    //阈值截断
    public static String THRESH_TRUNCAT_NAME = "Thresh Truncat";
    public static String THRESH_TRUNCAT_COM = "Thresh Truncat Operation";

    //阈值取零
    public static String THRESH_ZERO_NAME = "Thresh Zero";
    public static String THRESH_ZERO_COM = "Thresh Zero Operation";
}
