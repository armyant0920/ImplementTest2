package com.example.implementtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.implementtest.UI.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private List<String> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new MainAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);
        /**
         * 既然是动画，就会有时间，我们把动画执行时间变大一点来看一看效果
         */
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(500);
        defaultItemAnimator.setRemoveDuration(500);
        mRecyclerView.setItemAnimator(defaultItemAnimator);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    /**
     * 这里通过两个菜单按钮来观看我们的动画效果
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_add:
                mAdapter.addData(1);
                break;
            case R.id.action_remove:
                mAdapter.removeData(1);
                break;
        }
        return true;
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    private void test(){
        int charInt='A';
        System.out.println();

    }
}

