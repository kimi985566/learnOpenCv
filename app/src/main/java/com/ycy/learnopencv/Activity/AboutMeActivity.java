package com.ycy.learnopencv.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;

import com.ycy.learnopencv.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kimi9 on 2018/2/24.
 */

public class AboutMeActivity extends AppCompatActivity {


    @BindView(R.id.toolBar_aboutMe)
    Toolbar mToolBarAboutMe;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.detail_aboutMe)
    ImageView mIVDetailAboutMe;
    @BindView(R.id.webView)
    WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        translucentSetting();

        setContentView(R.layout.activity_aboutme);
        ButterKnife.bind(this);
        toolBarSetting();

        collapsingToolbarSetting();

        mWebView.loadUrl("https://github.com/kimi985566");

    }

    private void collapsingToolbarSetting() {
        mCollapsingToolbar.setTitle("Chengyu Yang");
        mCollapsingToolbar.setExpandedTitleColor(Color.BLACK);
        mCollapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void translucentSetting() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //此FLAG可使状态栏透明，且当前视图在绘制时，从屏幕顶端开始即top = 0开始绘制，这也是实现沉浸效果的基础
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//可不加
        }
    }


    private void toolBarSetting() {
        setSupportActionBar(mToolBarAboutMe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
