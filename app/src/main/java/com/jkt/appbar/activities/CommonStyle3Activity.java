package com.jkt.appbar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jkt.appbar.R;
import com.jkt.appbar.base.AppBarActivity;

public class CommonStyle3Activity extends AppBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_sytle3);
        //一定要放在setContentView之后(里面空间获取需要先加载layout resource)
        initAppBar(true, true);
    }

    @Override
    protected String setAppBarTitle() {
        return "标准3";
    }

    @Override
    protected String setAppBarRightTitle() {
        return "点我";
    }

    @Override
    protected void onAppBarBackClick() {
        finish();
    }

    @Override
    protected void onAppBarRightClick() {
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
    }

}
