package com.example.implementtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {
    Context ctx;
    TextView t1,t2,t3,t4;
    LinearLayout layout3;
    private String s;
    private boolean responseOnUiThread=true;

    Handler mhandle=new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        layout3=(LinearLayout) findViewById(R.id.layout3);
        t1=(TextView) findViewById(R.id.textView);
//        t2=(TextView) findViewById(R.id.textView2);
//        t3=(TextView) findViewById(R.id.textView3);
//        t4=(TextView) findViewById(R.id.textView4);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //layout3.removeView(t1);//测试删除view
                okhttp3TEST();

            }
        });







    }

    private void okhttp3TEST(){
        //建立client
        OkHttpClient client =new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(20, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(20, TimeUnit.SECONDS)//设置写入超时时间
                .build();
//建立request
        Request request=new Request.Builder()
                .url("https://data.boch.gov.tw/opendata/assetsCase/6.1.json")
                .build();
//建立call
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                System.out.println("response正常,responsecode="+response.code());
                s=response.body().string();
                //System.out.println(s);
                Main3Activity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        t1.setText(s);//
                    }
                });


            }
        });

    }

    private void handleResponse(Call call, final Response response, final ResponseCallback callback) {
        String printResult = null;
        if (call != null && callback != null) {
            final Request request = call.request();
            final int code = response.code();
            try {
                Type genType = callback.getClass().getGenericInterfaces()[0];
                Type type;
                if (genType instanceof ParameterizedType) {
                    type = ((ParameterizedType) genType).getActualTypeArguments()[0];
                } else {
                    type = String.class;
                }
                System.out.println(type.getTypeName());
                final String result = response.body().string();
                if (result != null) {
                    printResult = result.toString();
                }
                postResult(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(request, response, result, code);
                    }
                });
            } catch (final IOException e) {
                postResult(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(request, e);

                    }
                });
            }
        }

    }

    public interface ResponseCallback {

        void onSuccess(Request request, Response response, String result, int code);

        void onFailure(Request request, IOException e);

    }

    private void postResult(Runnable r) {
        if (r == null) {
            return;
        }
        if (responseOnUiThread && Looper.myLooper() != Looper.getMainLooper()) {
            mhandle.post(r);
        } else {
            r.run();
        }
    }


}
