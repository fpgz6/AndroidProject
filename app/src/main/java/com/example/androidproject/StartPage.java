package com.example.androidproject;
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.Window;
/**
 * Created by MECHREVO on 2018/4/28.
 */

public class  StartPage extends Activity{

    private static int SPLASH_DISPLAY_LENGHT= 2000;    //延迟3秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);//去掉标题
        setContentView(R.layout.start_page);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(StartPage.this, MainActivity.class);
                startActivity(intent);
                StartPage.this.finish();   //关闭StartPage，将其回收，否则按返回键会返回此界面
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

}