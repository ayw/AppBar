package com.jkt.appbar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jkt.appbar.R;
import com.jkt.appbar.base.AppBarActivity;

public class MainActivity extends AppBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //一定要放在setContentView之后(里面空间获取需要先加载layout resource)
        initAppBar(false);
    }

    public void bnClick(View view) {
        switch (view.getId()) {
            case R.id.bn_one:
                startActivity(new Intent(this, CommonStyle1Activity.class));
                break;
            case R.id.bn_two:
                startActivity(new Intent(this, CustomStyle1Activity.class));
                break;
        }
    }

    @Override
    protected String setAppBarTitle() {
        return "封装AppBar";
    }

    @Override
    protected String setAppBarRightTitle() {
        return null;
    }

    @Override
    protected void onAppBarBackClick() {
    }

    @Override
    protected void onAppBarRightClick() {

    }
}
