package com.example.littletestapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.littletestapp.R;

import java.util.List;

/**
 */
public class ColorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private Context context;
    private List<String> list;
    private int mPosition;

    public ColorAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setSelected(int position){
        mPosition = position;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = mLayoutInflater.inflate(R.layout.color_item, parent, false);
        return new MyViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
//            myViewHolder.mIm_item_color.setImageResource(list.get(position));

            myViewHolder.mRl.setBackgroundResource(mPosition==position?
                    R.drawable.size_selected:R.drawable.size_unselected);
            Glide.with(context).load("https://pic.bonwebuy.com"+list.get(position))
                    .into(myViewHolder.mIm_item_color);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mIm_item_color;
        RelativeLayout mRl;

        public MyViewHolder(View view) {
            super(view);
            mIm_item_color = (ImageView) view.findViewById(R.id.im_item_color);
            mRl = (RelativeLayout) view.findViewById(R.id.rl);
        }
    }

}
