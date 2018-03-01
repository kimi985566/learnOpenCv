package com.ycy.learnopencv.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi9 on 2018/2/21.
 */

public class OpenCVInfo implements OpenCVConstants {

    private long id;
    private String name;
    private String commend;

    public OpenCVInfo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public OpenCVInfo(long id, String name, String commend) {
        this.id = id;
        this.name = name;
        this.commend = commend;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommend() {
        return commend;
    }

    public void setCommend(String commend) {
        this.commend = commend;
    }

    public static List<OpenCVInfo> getAllList() {

        List<OpenCVInfo> list = new ArrayList<>();

        list.add(new OpenCVInfo(1, GRAY_TEST_NAME, GREY_TEST_COM));
        list.add(new OpenCVInfo(2, MAT_PIXEL_INVERT_NAME, MAT_PIXEL_INVERT_COM));
        list.add(new OpenCVInfo(3, BITMAP_PIXEL_INVERT_NAME, BITMAP_PIXEL_INVERT_COM));
        list.add(new OpenCVInfo(4, CONTRAST_RATIO_BRIGHTNESS_NAME, CONTRAST_RATIO_BRIGHTNESS_COM));
        list.add(new OpenCVInfo(5, IMAGE_CONTAINER_MAT_NAME, IMAGE_CONTAINER_MAT_COM));
        list.add(new OpenCVInfo(6, GET_ROI_NAME, GET_ROI_COM));
        list.add(new OpenCVInfo(7, BOX_BLUR_IMAGE_NAME, BOX_BLUR_IMAGE_COM));
        list.add(new OpenCVInfo(7, GAUSSIAN_BLUR_IMAGE_NAME, GAUSSIAN_BLUR_IMAGE_COM));
        list.add(new OpenCVInfo(7, BILATERAL_BLUR_IMAGE_NAME, BILATERAL_BLUR_IMAGE_COM));
        list.add(new OpenCVInfo(8, CUSTOM_BLUR_NAME, CUSTOM_BLUR_COM));
        list.add(new OpenCVInfo(9, CUSTOM_EDGE_NAME, CUSTOM_EDGE_COM));
        list.add(new OpenCVInfo(10, CUSTOM_SHARPEN_NAME, CUSTOM_SHARPEN_COM));
        list.add(new OpenCVInfo(11, ERODE_NAME, ERODE_COM));
        list.add(new OpenCVInfo(12, DILATE_NAME, DILATE_COM));
        list.add(new OpenCVInfo(13, OPEN_OPERATION_NAME, OPEN_OPERATION_COM));
        list.add(new OpenCVInfo(14, CLOSE_OPERATION_NAME, CLOSE_OPERATION_COM));
        list.add(new OpenCVInfo(15, MORPH_LINE_OPERATION_NAME, MORPH_LINE_OPERATION_COM));
        list.add(new OpenCVInfo(16, THRESH_BINARY_NAME, THRESH_BINARY_COM));
        list.add(new OpenCVInfo(16, THRESH_BINARY_INV_NAME, THRESH_BINARY_INV_COM));
        list.add(new OpenCVInfo(17, THRESH_TRUNCAT_NAME, THRESH_TRUNCAT_COM));
        list.add(new OpenCVInfo(18, THRESH_ZERO_NAME, THRESH_ZERO_COM));
        list.add(new OpenCVInfo(19, MANUAL_THRESH_NAME, MANUAL_THRESH_COM));
        list.add(new OpenCVInfo(20, ADAPTIVE_THRESH_MEAN_NAME, ADAPTIVE_THRESH_MEAN_COM));
        list.add(new OpenCVInfo(20, ADAPTIVE_THRESH_GAUSSIAN_NAME, ADAPTIVE_THRESH_GAUSSIAN_COM));

        return list;
    }
}
