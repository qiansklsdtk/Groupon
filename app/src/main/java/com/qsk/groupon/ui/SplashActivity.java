package com.qsk.groupon.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qsk.groupon.R;
import com.qsk.groupon.util.SPUtil;

public class SplashActivity extends AppCompatActivity {
    //1.
    SPUtil spUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spUtil=new SPUtil(this);
        //定时器使界面停留3000毫秒后再实现新手指导页和主界面的跳转
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if(spUtil.isFirst()){//第一次运行时,偏好文件找不到,里面的K-V键值对找不到,spUtil.isFirst()值为true
                    intent=new Intent(SplashActivity.this,GuideActivity.class);
                    spUtil.setFirst(false);//第二次运行时,偏好文件里的Constant.FIRST为false,会执行else子句
                }else {
                    intent=new Intent(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
