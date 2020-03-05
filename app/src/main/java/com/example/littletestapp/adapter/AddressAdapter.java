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
import com.example.littletestapp.javaBean.AddressBean;

import java.util.List;

/**
 */
public class AddressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private Context context;
    private List<AddressBean.ResultBean> list;
    private int mPosition;

    public AddressAdapter(Context context, List<AddressBean.ResultBean> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = mLayoutInflater.inflate(R.layout.address_item, parent, false);
        return new MyViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.tv_name.setText(list.get(position).getConsignee());
            myViewHolder.tv_phoneNum.setText(list.get(position).getMobile());
            myViewHolder.tv_defaut_address.setBackgroundResource(list.get(position).isIsdefault()?
                    R.drawable.textview_border:R.drawable.text_setected_selector);
            myViewHolder.tv_defaut_address.setText(list.get(position).isIsdefault()?
                    "默认地址":"设为默认");
            myViewHolder.tv_address.setText(
                    list.get(position).getCountryName()+
                    list.get(position).getProvinceName()+
                    list.get(position).getCityName()+
                    list.get(position).getDistrictName()+
                    list.get(position).getAddress());

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_phoneNum;
        TextView tv_address;
        TextView tv_defaut_address;

        public MyViewHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_phoneNum = (TextView) view.findViewById(R.id.tv_phoneNum);
            tv_address = (TextView) view.findViewById(R.id.tv_address);
            tv_defaut_address = (TextView) view.findViewById(R.id.tv_defaut_address);
        }
    }

}
