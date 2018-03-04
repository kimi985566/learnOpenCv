package com.ycy.learnopencv.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.blankj.utilcode.util.Utils;
import com.ycy.learnopencv.Bean.OpenCVConstants;
import com.ycy.learnopencv.R;
import com.ycy.learnopencv.Utils.ImageProcessUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeekBarProcessActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_thresh_select)
    Button mBtnSelect;
    @BindView(R.id.btn_thresh_process)
    Button mBtnProcess;
    @BindView(R.id.thresh_seek_bar)
    SeekBar mThreshSeekBar;
    @BindView(R.id.iv_thresh_process)
    ImageView mIvThreshProcess;
    @BindView(R.id.tv_thresh)
    TextView mTvThresh;

    private Bitmap mBitmap;
    public static final int SELECT_PIC_RESULT_CODE = 202;
    private int maxSize = 1024;
    private String processName;
    private int mValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_process);
        ButterKnife.bind(this);
        Utils.init(this);
        processName = this.getIntent().getStringExtra("name");
        actionBarSetting();
        mBtnProcess.setText(processName);
        mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_image_aboutme);
        mThreshSeekBar.setOnSeekBarChangeListener(this);
    }

    private void actionBarSetting() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(processName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @OnClick({R.id.btn_thresh_select, R.id.btn_thresh_process})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_thresh_select:
                Intent pickIntent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                pickIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(pickIntent, "Browser Image……"),
                        SELECT_PIC_RESULT_CODE);
                break;
            case R.id.btn_thresh_process:
                select2Process(mValue);
                break;
        }
    }


    private void select2Process(int value) {
        Bitmap temp = mBitmap.copy(mBitmap.getConfig(), true);
        if (OpenCVConstants.MANUAL_THRESH_NAME.equals(processName)) {
            ImageProcessUtils.manualThresholdImg(value, temp);
        } else if (OpenCVConstants.CANNY_NAME.equals(processName)) {
            ImageProcessUtils.cannyProcess(value, temp);
        } else if (OpenCVConstants.FIND_CONTOURS_NAME.equals(processName)) {
            ImageProcessUtils.findAndDrawContours(value, temp);
        }
        mIvThreshProcess.setImageBitmap(temp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PIC_RESULT_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                BitmapFactory.decodeStream(inputStream, null, options);

                int height = options.outHeight;
                int width = options.outWidth;
                int sampleSize = 1;
                int max = Math.max(height, width);

                if (max > maxSize) {
                    int nw = width / 2;
                    int nh = height / 2;
                    while ((nw / sampleSize) > maxSize || (nh / sampleSize) > maxSize) {
                        sampleSize *= 2;
                    }
                }

                options.inSampleSize = sampleSize;
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;

                mBitmap = BitmapFactory.decodeStream(getContentResolver().
                        openInputStream(uri), null, options);
                mIvThreshProcess.setImageBitmap(mBitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mValue = mThreshSeekBar.getProgress();
        mTvThresh.setText("当前阈值：" + mValue);
        select2Process(mValue);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
