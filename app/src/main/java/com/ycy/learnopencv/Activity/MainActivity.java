package com.ycy.learnopencv.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.ycy.learnopencv.Adapter.OpenCVListViewAdapter;
import com.ycy.learnopencv.Bean.OpenCVConstants;
import com.ycy.learnopencv.Bean.OpenCVInfo;
import com.ycy.learnopencv.R;

import org.opencv.android.OpenCVLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kimi9 on 2018/2/21.
 */

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private List<OpenCVInfo> mOpenCVInfos = new ArrayList<>();
    private OpenCVListViewAdapter mOpenCVListViewAdapter;
    private String mItem_cmd;
    private String mItem_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Utils.init(this);
        initOpenCVLibs();
        initUI();
    }

    private void initUI() {
        setSupportActionBar(mToolbar);
        mOpenCVListViewAdapter = new OpenCVListViewAdapter(this, mOpenCVInfos);
        mListView.setAdapter(mOpenCVListViewAdapter);
        mListView.setOnItemClickListener(this);
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(1,
                OpenCVConstants.GRAY_TEST_NAME, OpenCVConstants.GREY_TEST_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(2,
                OpenCVConstants.MAT_PIXEL_INVERT_NAME, OpenCVConstants.MAT_PIXEL_INVERT_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(3,
                OpenCVConstants.BITMAP_PIXEL_INVERT_NAME, OpenCVConstants.BITMAP_PIXEL_INVERT_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(4,
                OpenCVConstants.CONTRAST_RATIO_BRIGHTNESS_NAME, OpenCVConstants.CONTRAST_RATIO_BRIGHTNESS_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(5,
                OpenCVConstants.IMAGE_CONTAINER_MAT_NAME, OpenCVConstants.IMAGE_CONTAINER_MAT_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(6,
                OpenCVConstants.GET_ROI_NAME, OpenCVConstants.GET_ROI_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(7,
                OpenCVConstants.BOX_BLUR_IMAGE_NAME, OpenCVConstants.BOX_BLUR_IMAGE_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(7,
                OpenCVConstants.GAUSSIAN_BLUR_IMAGE_NAME, OpenCVConstants.GAUSSIAN_BLUR_IMAGE_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(7,
                OpenCVConstants.BILATERAL_BLUR_IMAGE_NAME, OpenCVConstants.BILATERAL_BLUR_IMAGE_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(8,
                OpenCVConstants.CUSTOM_BLUR_NAME, OpenCVConstants.CUSTOM_BLUR_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(9,
                OpenCVConstants.CUSTOM_EDGE_NAME, OpenCVConstants.CUSTOM_EDGE_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(10,
                OpenCVConstants.CUSTOM_SHARPEN_NAME, OpenCVConstants.CUSTOM_SHARPEN_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(11,
                OpenCVConstants.ERODE_NAME, OpenCVConstants.ERODE_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(12,
                OpenCVConstants.DILATE_NAME, OpenCVConstants.DILATE_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(13,
                OpenCVConstants.OPEN_OPERATION_NAME, OpenCVConstants.OPEN_OPERATION_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(14,
                OpenCVConstants.CLOSE_OPERATION_NAME, OpenCVConstants.CLOSE_OPERATION_COM));
        mOpenCVListViewAdapter.getOpenCVInfos().add(new OpenCVInfo(15,
                OpenCVConstants.MORPH_LINE_OPERATION_NAME, OpenCVConstants.MORPH_LINE_OPERATION_COM));
        mOpenCVListViewAdapter.notifyDataSetChanged();
    }

    private void initOpenCVLibs() {
        boolean isSuccess = OpenCVLoader.initDebug();
        if (isSuccess) {
            LogUtils.i("OpenCV init success");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_aboutMe) {
            Intent intent = new Intent(this.getApplicationContext(), AboutMeActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object object = view.getTag();
        if (object instanceof OpenCVInfo) {
            OpenCVInfo openCVInfo = (OpenCVInfo) object;
            mItem_name = openCVInfo.getName();
            mItem_cmd = openCVInfo.getCommend();
        }
        processIntent();
    }

    private void processIntent() {
        if (OpenCVConstants.GRAY_TEST_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.MAT_PIXEL_INVERT_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.BITMAP_PIXEL_INVERT_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.CONTRAST_RATIO_BRIGHTNESS_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.IMAGE_CONTAINER_MAT_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.GET_ROI_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.BOX_BLUR_IMAGE_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.GAUSSIAN_BLUR_IMAGE_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.BILATERAL_BLUR_IMAGE_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.CUSTOM_BLUR_NAME.equals(mItem_name)
                || OpenCVConstants.CUSTOM_EDGE_NAME.equals(mItem_name)
                || OpenCVConstants.CUSTOM_SHARPEN_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.ERODE_NAME.equals(mItem_name)
                || OpenCVConstants.DILATE_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.OPEN_OPERATION_NAME.equals(mItem_name)
                || OpenCVConstants.CLOSE_OPERATION_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        } else if (OpenCVConstants.MORPH_LINE_OPERATION_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        }
    }
}
