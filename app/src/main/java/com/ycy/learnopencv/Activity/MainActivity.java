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
    private String mProcessName;
    private String mProcessCMD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Utils.init(this);
        initOpenCVLibs();
        initUI();
    }

    private void initOpenCVLibs() {
        boolean isSuccess = OpenCVLoader.initDebug();
        if (isSuccess) {
            LogUtils.i("OpenCV init success");
        }
    }

    private void initUI() {
        setSupportActionBar(mToolbar);
        mOpenCVListViewAdapter = new OpenCVListViewAdapter(this, mOpenCVInfos);
        mListView.setAdapter(mOpenCVListViewAdapter);
        mListView.setOnItemClickListener(this);
        mOpenCVListViewAdapter.getOpenCVInfos().addAll(OpenCVInfo.getAllList());
        mOpenCVListViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object object = view.getTag();
        if (object instanceof OpenCVInfo) {
            OpenCVInfo openCVInfo = (OpenCVInfo) object;
            mProcessName = openCVInfo.getName();
            mProcessCMD = openCVInfo.getCommend();
        }
        processIntent();
    }

    private void processIntent() {
        if (OpenCVConstants.MANUAL_THRESH_NAME.equals(mProcessName)
                || OpenCVConstants.CANNY_NAME.equals(mProcessName)
                || OpenCVConstants.FIND_CONTOURS_NAME.equals(mProcessName)
                || OpenCVConstants.FIND_OBJECTS_NAME.equals(mProcessName)
                || OpenCVConstants.SKELETON_PROCESS_NAME.equals(mProcessName)) {
            Intent intent = new Intent(MainActivity.this, SeekBarProcessActivity.class);
            intent.putExtra("commend", mProcessCMD);
            intent.putExtra("name", mProcessName);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, ProcessActivity.class);
            intent.putExtra("commend", mProcessCMD);
            intent.putExtra("name", mProcessName);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_aboutMe) {
            Intent intent = new Intent(this.getApplicationContext(), AboutMeActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}