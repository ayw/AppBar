package com.jkt.appbar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jkt.appbar.R;
import com.jkt.appbar.base.AppBarActivity;

public class CommonStyle2Activity extends AppBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_style2);
        //一定要放在setContentView之后(里面空间获取需要先加载layout resource)
        initAppBar(true, false, R.color.green, R.color.black);

    }

    @Override
    protected String setAppBarTitle() {
        return "标准2";
    }

    @Override
    protected String setAppBarRightTitle() {
        return null;
    }

    @Override
    protected void onAppBarBackClick() {
        finish();
    }

    @Override
    protected void onAppBarRightClick() {

    }

    public void bnClick(View view) {
        startActivity(new Intent(this, CommonStyle3Activity.class));
    }
}
