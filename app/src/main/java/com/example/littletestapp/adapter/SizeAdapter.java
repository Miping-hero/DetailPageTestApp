package com.example.littletestapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.littletestapp.R;
import com.example.littletestapp.javaBean.DetailBean;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class SizeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private Context context;
    private List<String> list;
    private int mPosition;
    List<String> mSizeCode = new ArrayList<>();
    List<DetailBean.ResultBean.SaleAttrListBean.SaleAttr2ListBean> mSaleAttr2ListBean =new ArrayList<>();
    private boolean isRefresh =true;

    public SizeAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setSelected(int isSelected){
        mPosition = isSelected;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = mLayoutInflater.inflate(R.layout.size_item, parent, false);
        return new MyViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.mTv_item_size.setText(list.get(position));
                //排除不可点击的选项
                if (!mSizeCode.isEmpty()) {
                    if (mSizeCode.contains(mSaleAttr2ListBean.get(position).getSaleAttr2ValueCode())) {
                        myViewHolder.mTv_item_size.setEnabled(true);
                        myViewHolder.mTv_item_size.setBackgroundResource(mPosition == position ?
                                R.drawable.size_selected : R.drawable.size_unselected);
                        Log.i("mipss", "onBindViewHolder: ");
                    } else {
                        myViewHolder.mTv_item_size.setEnabled(false);
                        myViewHolder.mTv_item_size.setBackgroundResource(R.drawable.size_unselected);
                    }
                } else {
                    myViewHolder.mTv_item_size.setEnabled(true);
                    myViewHolder.mTv_item_size.setBackgroundResource(mPosition == position ?
                            R.drawable.size_selected : R.drawable.size_unselected);
                }
        }
    }

    public void setSizeCode(List<String> sizeCode,boolean isRefresh){
        if (!mSizeCode.isEmpty()) mSizeCode.clear();
        mSizeCode.addAll(sizeCode);
    }

    public void setSaleAttr2ListBean(List<DetailBean.ResultBean.SaleAttrListBean.SaleAttr2ListBean> saleAttr2ListBean){
        if (!mSaleAttr2ListBean.isEmpty()) mSaleAttr2ListBean.clear();
        mSaleAttr2ListBean.addAll(saleAttr2ListBean);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        Button mTv_item_size;
        RelativeLayout mRl;

        public MyViewHolder(View view) {
            super(view);
            mTv_item_size = (Button) view.findViewById(R.id.tv_item_size);
            mRl = (RelativeLayout) view.findViewById(R.id.rl);
        }
    }

}
