package com.zs.recycler.recyclerviewanim;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LeeJizhou on 2016/4/18.
 * Blog:www.lijizhou.com
 * QQ:3107777777
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private ArrayList<String> mTitle=new ArrayList<>();

    public RecyclerViewAdapter(Context context,ArrayList<String>title){
        mContext=context;
        mTitle=title;
        mLayoutInflater=LayoutInflater.from(context);
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView=(TextView)itemView.findViewById(R.id.tv_text);
        }
    }

    public void remove(int position) {
        mTitle.remove(position);
        notifyItemRemoved(position);
    }

    public void add(String text, int position) {
        mTitle.add(position, text);
        notifyItemInserted(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mLayoutInflater.inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mTitle.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitle==null ? 0 : mTitle.size();
    }
}
