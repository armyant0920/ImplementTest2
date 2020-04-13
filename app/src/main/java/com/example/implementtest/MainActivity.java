package com.example.implementtest;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.implementtest.UI.GenericToast;
import com.example.implementtest.UI.ToastPopWindow;

import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private static int S;

    private Toast mToastToShow;
    String s = "Remain:";
    int count = 0;
    CountDownTimer toastCountDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);


        init();


    }

    private void init() {
        LinearLayout layout = findViewById(R.id.layout);
        Button toast_btn = findViewById(R.id.toast_btn);
        toast_btn.setOnClickListener(clickListener);
        final TextView msg_txt = findViewById(R.id.msg_txt);
        ImageView img = findViewById(R.id.imageView);
        ImageView img2 = findViewById(R.id.imageView2);
        ImageView img3 = findViewById(R.id.imageView3);
        ImageView img4=findViewById(R.id.imageView4);
        img3.setImageResource(R.drawable.progress);
        img3.animate();
        //String url="https://data.boch.gov.tw/upload/representImageFile/2019-07-30/921764e2-0b31-480e-84ed-21b1ab759840/DSC_2514.jpg";
        URL url = null;
        try {
            url = new URL("https://data.boch.gov.tw/upload/representImageFile/2019-07-30/921764e2-0b31-480e-84ed-21b1ab759840/DSC_2514.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //利用调整饱和度的方式,只能使原本的色彩转为灰阶,没有办法直接隐藏细节
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter grayFilter = new ColorMatrixColorFilter(cm);
        img.setColorFilter(grayFilter);
        //Glide载入测试(本地资源)
        Glide.with(this)
                .load(R.drawable.itnsl)
                .apply(RequestOptions.circleCropTransform())
                .into(img2)
        ;
        //Glide载入测试(url)
        DrawableCrossFadeFactory factory =
                new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        Glide.with(this)
                .load(url)

                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .error(android.R.drawable.stat_notify_error)
                //.placeholder(R.drawable.progress)

                .into(img3);
        Glide.with(this)
                .load("ABC")
                .error(android.R.drawable.stat_notify_error)
                .into(img4);

        //Handler
//         Handler handler=new Handler(){
//             @Override
//             public void handleMessage(Message msg){
//              msg_txt.setText(S);
//             }
//         };


    }

    //Listener
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.toast_btn:
                    //toast("hello world~~~~~~~~~~~~~~~~~~~",10*1000);
                    //ToastTest("hello~~~~~~~~~",30*1000);

                    showToast(LayoutInflater.from(MainActivity.this).inflate(R.layout.view_toast_popwindow, null));

                    break;

            }

        }
    };

    //Toast方法
//    private void toast(final String s,final int ms){
//        new ToastPopWindow(MainActivity.this,s,ms).show();
//        System.out.println("毫秒"+ms);
//    }
    public void ToastTest(String s, int duration) {
        GenericToast toast = GenericToast.makeText(this, s, duration);
        toast.show();
    }

    private void toast(final String s, final int ms) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ToastPopWindow(getApplicationContext(), s, ms).show();


            }
        });
    }


    public void showToast(View view) {
        // Set the toast and duration

        int toastDurationInMilliSeconds = 30 * 1000;

        count = 0;

        mToastToShow = Toast.makeText(this, s, Toast.LENGTH_LONG);


        // Set the countdown to display the toast


        toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {

            public void onTick(long millisUntilFinished) {
                count++;
                System.out.println("Tick:" + (30 - count));
                mToastToShow.setText(s + (30 - count));
                System.out.println(mToastToShow.getDuration());
                mToastToShow.show();
            }

            public void onFinish() {
                mToastToShow.cancel();
            }
        };

        // Show the toast and starts the countdown
        mToastToShow.show();
        toastCountDown.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Glide.with(this).pauseRequests();
    }
}
