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

import com.blankj.utilcode.util.Utils;
import com.ycy.learnopencv.R;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProcessActivity extends AppCompatActivity {

    @BindView(R.id.btn_process)
    Button mBtnProcess;
    @BindView(R.id.iv_process)
    ImageView mIvProcess;
    @BindView(R.id.btn_select)
    Button mBtnSelect;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private Bitmap mBitmap;
    public static final int SELECT_PIC_RESULT_CODE = 202;
    private int maxSize = 1024;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        ButterKnife.bind(this);
        Utils.init(this);
        String btn_name = this.getIntent().getStringExtra("name");
        mBtnProcess.setText(btn_name);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(btn_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @OnClick({R.id.btn_process, R.id.btn_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_process:
                RGB2Gray();
                break;
            case R.id.btn_select:
                Intent pickIntent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                pickIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(pickIntent, "Browser Image……"),
                        SELECT_PIC_RESULT_CODE);
                break;
        }
    }

    private void RGB2Gray() {
        Mat src = new Mat();
        Mat dst = new Mat();
        Bitmap temp = mBitmap.copy(mBitmap.getConfig(), true);
        org.opencv.android.Utils.bitmapToMat(temp, src);
        Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGRA2GRAY);
        org.opencv.android.Utils.matToBitmap(dst, temp);
        mIvProcess.setImageBitmap(temp);
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
                mBitmap = BitmapFactory.decodeStream(getContentResolver().
                        openInputStream(uri), null, options);
                mIvProcess.setImageBitmap(mBitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
