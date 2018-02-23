package com.ycy.learnopencv.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
                OpenCVConstants.PIXEL_INVERT_NAME, OpenCVConstants.PIXEL_INVERT_COM));
        mOpenCVListViewAdapter.notifyDataSetChanged();
    }

    private void initOpenCVLibs() {
        boolean isSuccess = OpenCVLoader.initDebug();
        if (isSuccess) {
            LogUtils.i("OpenCV init success");
        }
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
        } else if (OpenCVConstants.PIXEL_INVERT_NAME.equals(mItem_name)) {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mItem_cmd);
            intent.putExtra("name", mItem_name);
            startActivity(intent);
        }
    }
}
