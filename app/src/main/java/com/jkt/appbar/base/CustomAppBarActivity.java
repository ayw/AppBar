package com.jkt.appbar.base;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jkt.appbar.R;
import com.jkt.appbar.util.DensityUtil;


/**
 * Created by Allen at 2017/7/13 15:05
 */
//实际开发让该类继承自己写的BaseActivity,不推荐所有逻辑都放在BaseActivity，这样层次分明
public abstract class CustomAppBarActivity extends AppCompatActivity {
    private int[] mResArray;
    private ImageView mThreeIV;

    protected void initAppBar(boolean isOne, boolean isTwo, boolean isThree, boolean isFour) {
        initAppBar(isOne, isTwo, isThree, isFour, -1, -1);
    }

    protected void initAppBar(boolean isOne, boolean isTwo, boolean isThree, boolean isFour, @ColorRes int bgColor, @ColorRes int textColor) {
        //下面三行代码是动态加载布局文件，采用这种方式的话，不需要在xml布局include
        //采用该方式的小伙伴记得在 xml删除include代码 ,避免造成重复
        //该方法的唯一弊端,我们在写布局的时候design页面会出现导航栏空白,
        // 毕竟是代码动态加载布局的，自行选择自己喜欢的方式
//        ViewGroup outView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
//        View inflate = LayoutInflater.from(this).inflate(R.layout.custom_appbar, outView, false);
//        outView.addView(inflate, 0);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.custom_appbar_rl);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.custom_appbar_ll);
        if (layout == null) {
            return;
        }
        invadeStatusBar();
        if (bgColor != -1) {
            linearLayout.setBackgroundResource(bgColor);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            layoutParams.setMargins(0, getStatusBarHeight(), 0, 0);
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        layout.setLayoutParams(layoutParams);
        mResArray = setAppBarDrawableRes();
        TextView titleTV = (TextView) findViewById(R.id.custom_appbar_center_tv);
        if (textColor != -1) {
            titleTV.setTextColor(getResources().getColor(textColor));
        }
        titleTV.setText(setAppBarTitle() == null ? "默认标题" : setAppBarTitle());
        ImageView oneIV = (ImageView) findViewById(R.id.custom_appbar_one_iv);
        ImageView twoIV = (ImageView) findViewById(R.id.custom_appbar_two_iv);
        mThreeIV = (ImageView) findViewById(R.id.custom_appbar_three_iv);
        ImageView fourIV = (ImageView) findViewById(R.id.custom_appbar_four_iv);
        if (!isOne || mResArray.length < 1) {
            oneIV.setVisibility(View.GONE);
        } else {
            oneIV.setImageDrawable(getResources().getDrawable(mResArray[0]));
            oneIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAppBarClick(0);

                }
            });
        }
        if (!isTwo || mResArray.length < 2) {
            twoIV.setVisibility(View.GONE);
        } else {
            twoIV.setImageDrawable(getResources().getDrawable(mResArray[1]));
            twoIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAppBarClick(1);
                }
            });
        }
        if (!isThree || mResArray.length < 3) {
            mThreeIV.setVisibility(View.GONE);
        } else {
            mThreeIV.setImageDrawable(getResources().getDrawable(mResArray[2]));
            mThreeIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAppBarClick(2);
                }
            });
        }
        if (!isFour || mResArray.length < 4) {
            fourIV.setVisibility(View.GONE);
        } else {
            fourIV.setImageDrawable(getResources().getDrawable(mResArray[3]));
            fourIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAppBarClick(3);
                }
            });
        }
    }

    protected abstract String setAppBarTitle();

    protected abstract int[] setAppBarDrawableRes();

    protected abstract void onAppBarClick(int position);


    protected void setThreeIVDrawable(@DrawableRes int drawable) {
        if (mThreeIV == null) {
            return;
        }
        mThreeIV.setImageDrawable(getResources().getDrawable(drawable));
    }

    protected void invadeStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private int getStatusBarHeight() {
        Resources resources = getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        Log.i("theHeight", height + "");
        if (height <= 10) {
            height = DensityUtil.dp2px(this, 16);
        }
        return height;
    }
}

