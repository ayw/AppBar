package com.jkt.appbar.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.jkt.appbar.R;
import com.jkt.appbar.base.CustomAppBarActivity;

public class CustomStyle2Activity extends CustomAppBarActivity {

    private boolean mIsStared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_style2);
        //一定要放在setContentView之后(里面空间获取需要先加载layout resource)
        initAppBar(true, true, true, true);
        mIsStared = false;
    }

    @Override
    protected String setAppBarTitle() {
        return "自定义2";
    }

    @Override
    protected int[] setAppBarDrawableRes() {
        return new int[]{R.drawable.left_arrow, R.drawable.edit, R.drawable.no_star, R.drawable.share};
    }

    @Override
    protected void onAppBarClick(int position) {
        switch (position) {
            case 0:
                finish();
                break;
            case 1:
                Toast.makeText(this, "编辑", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                if (mIsStared) {
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                    setThreeIVDrawable(R.drawable.no_star);
                } else {
                    Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
                    setThreeIVDrawable(R.drawable.star);
                }
                mIsStared = !mIsStared;
                break;
            case 3:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
