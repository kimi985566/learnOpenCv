package com.ycy.learnopencv.Bean;

/**
 * Created by kimi9 on 2018/2/22.
 */

public interface OpenCVConstants {

    //灰度图形
    String GRAY_TEST_NAME = "Image to gray";
    String GREY_TEST_COM = "Gray Level Image";

    //Mat图像反色
    String MAT_PIXEL_INVERT_NAME = "Convert:Mat";
    String MAT_PIXEL_INVERT_COM = "Convert image in Mat";

    //Bitmap图像反色
    String BITMAP_PIXEL_INVERT_NAME = "Convert:Bitmap";
    String BITMAP_PIXEL_INVERT_COM = "Convert image in Bitmap";

    //调整亮度、对比度
    String CONTRAST_RATIO_BRIGHTNESS_NAME = "Adjust CM&BR";
    String CONTRAST_RATIO_BRIGHTNESS_COM = "Adjust contrast ratio and brightness";

    //创建mat空白图像
    String IMAGE_CONTAINER_MAT_NAME = "Mat Operation";
    String IMAGE_CONTAINER_MAT_COM = "Image Container: Mat, create a new image of mat";

    //子图操作
    String GET_ROI_NAME = "ROI Operation";
    String GET_ROI_COM = "Get sub image";

    //均值滤波
    String BOX_BLUR_IMAGE_NAME = "Box Blur";
    String BOX_BLUR_IMAGE_COM = "Blur learning: Box Blur";

    //高斯滤波
    String GAUSSIAN_BLUR_IMAGE_NAME = "GAUSSIAN Blur";
    String GAUSSIAN_BLUR_IMAGE_COM = "Blur learning: GAUSSIAN Blur";

    //双边滤波
    String BILATERAL_BLUR_IMAGE_NAME = "Bilateral Blur";
    String BILATERAL_BLUR_IMAGE_COM = "Blur learning: Bilateral Blur";

    //自定义模糊
    String CUSTOM_BLUR_NAME = "Custom Blur";
    String CUSTOM_BLUR_COM = "Blur Operation";

    //自定义边缘提取
    String CUSTOM_EDGE_NAME = "Custom Edge";
    String CUSTOM_EDGE_COM = "Edge Operation";

    //自定义锐化处理
    String CUSTOM_SHARPEN_NAME = "Custom Sharpen";
    String CUSTOM_SHARPEN_COM = "Sharpen Operation";

    //腐蚀
    String ERODE_NAME = "Erode";
    String ERODE_COM = "Learning Erode";

    //膨胀
    String DILATE_NAME = "Dilate";
    String DILATE_COM = "Learning Dilate";

    //开操作
    String OPEN_OPERATION_NAME = "Open Operation";
    String OPEN_OPERATION_COM = "Learning Open Operation";

    //闭操作
    String CLOSE_OPERATION_NAME = "Close Operation";
    String CLOSE_OPERATION_COM = "Learning Close Operation";

    //形态学直线检测
    String MORPH_LINE_OPERATION_NAME = "Line Detection";
    String MORPH_LINE_OPERATION_COM = "形态学直线检测";

    //阈值二值化
    String THRESH_BINARY_NAME = "Thresh Binary";
    String THRESH_BINARY_COM = "Thresh Binary Operation";

    //阈值反二值化
    String THRESH_BINARY_INV_NAME = "Thresh Binary Inverse";
    String THRESH_BINARY_INV_COM = "Thresh Binary Inverse Operation";

    //阈值截断
    String THRESH_TRUNCAT_NAME = "Thresh Truncat";
    String THRESH_TRUNCAT_COM = "Thresh Truncat Operation";

    //阈值取零
    String THRESH_ZERO_NAME = "Thresh Zero";
    String THRESH_ZERO_COM = "Thresh Zero Operation";
}
