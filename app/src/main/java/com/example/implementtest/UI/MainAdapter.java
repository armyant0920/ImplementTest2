package com.example.implementtest.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.implementtest.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mDatas;

    public MainAdapter(Context context, List<String> mDatas) {
        this.mContext = context;
        this.mDatas = mDatas;
    }

    /**
     * 增加数据
     */
    public void addData(int position) {
        mDatas.add(position, "add");
        notifyItemInserted(position);//注意这里
    }

    /**
     * 移除数据
     */
    public void removeData(int position) {
        String s=mDatas.get(position);
        char c=s.charAt(0);
        int i=c;


        System.out.println("remove"+mDatas.get(position)+"整数值:"+c+i);
        mDatas.remove(position);


        notifyItemRemoved(position);//注意这里
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView)itemView.findViewById(R.id.tv);
        }
    }
}