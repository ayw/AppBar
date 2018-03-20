package com.jkt.appbar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jkt.appbar.R;
import com.jkt.appbar.base.CustomAppBarActivity;

public class CustomStyle1Activity extends CustomAppBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_style1);
        //一定要放在setContentView之后(里面空间获取需要先加载layout resource)
        initAppBar(true, false, false, true);
    }

    @Override
    protected String setAppBarTitle() {
        return "自定义1";
    }

    @Override
    protected int[] setAppBarDrawableRes() {
        return new int[]{R.drawable.left_arrow, -1, -1, R.drawable.edit};
    }

    @Override
    protected void onAppBarClick(int position) {
        //下标起始为0 (0,1,2,3)
        switch (position) {
            case 0:
                finish();
                break;
            case 3:
                Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void bnClick(View view) {
        startActivity(new Intent(this, CustomStyle2Activity.class));
    }
}
