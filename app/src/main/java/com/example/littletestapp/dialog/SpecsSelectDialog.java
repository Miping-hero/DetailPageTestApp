package com.example.littletestapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.littletestapp.R;
import com.example.littletestapp.adapter.ColorAdapter;
import com.example.littletestapp.adapter.SizeAdapter;
import com.example.littletestapp.javaBean.DetailBean;
import com.example.littletestapp.utils.CustomIntEditView;
import com.example.littletestapp.utils.ItemClickListener;
import com.example.littletestapp.utils.MyLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class SpecsSelectDialog extends Dialog implements View.OnClickListener{

    private Activity activity;
    private RelativeLayout btnPickBySelect, btnPickByTake;
    private RecyclerView mRecyclerView_color;
    private RecyclerView mRecyclerView_size;
    private DetailBean mDetailBean;
    private ImageView mIm_pic;
    private TextView mTv_price;
    private Button mBtn;
    private CustomIntEditView mCus_add_num;
    private ICallBack mICallBack;

    private ColorAdapter adapter_color;
    private SizeAdapter adapter_size;
    private List<String> list = new ArrayList<>();
    private List<String> size_list = new ArrayList<>();
    List<DetailBean.ResultBean.SaleAttrListBean.SaleAttr1ListBean> mAttr1ListBeans;
    List<DetailBean.ResultBean.SaleAttrListBean.SaleAttr2ListBean> mAttr2ListBeans;
    List<DetailBean.ResultBean.SkuInfoBean> mSkuInfoBean;
    List<String> sizeCode = new ArrayList<>();
    private  String color = null;
    private  String size = null;

    public SpecsSelectDialog(Activity activity,ICallBack iCallBack) {
        super(activity, R.style.ActionSheetDialogStyle);
        this.activity = activity;
        this.mICallBack = iCallBack;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specs_select_dialog);
        mRecyclerView_color = (RecyclerView) findViewById(R.id.recycler_color);
        mRecyclerView_size = (RecyclerView) findViewById(R.id.recycler_size);
        mIm_pic = (ImageView) findViewById(R.id.im_pic);
        mTv_price = (TextView) findViewById(R.id.tv_price);
        mBtn = (Button) findViewById(R.id.btn);
        mCus_add_num = (CustomIntEditView) findViewById(R.id.cus_add_num);
        Glide.with(activity).load("https://pic.bonwebuy.com"+
                mDetailBean.getResult().getProductUrl())
                .into(mIm_pic);
        mTv_price.setText("￥"+mDetailBean.getResult().getSalePrice()+"");
        mBtn.setOnClickListener(this);
        //构造skuinfo数据
        mSkuInfoBean =
                mDetailBean.getResult().getSkuInfo();
        //构造颜色数据
        mAttr1ListBeans =
                mDetailBean.getResult().getSaleAttrList().getSaleAttr1List();
        for (DetailBean.ResultBean.SaleAttrListBean.SaleAttr1ListBean saleAttr1ListBean:mAttr1ListBeans) {
            list.add(saleAttr1ListBean.getImageUrl());
        }
        MyLayoutManager layout = new MyLayoutManager();
        //必须，防止recyclerview高度为wrap时测量item高度0
        layout.setAutoMeasureEnabled(true);
//        颜色选择
        mRecyclerView_color.setLayoutManager(layout);
        adapter_color = new ColorAdapter(activity, list);
        mRecyclerView_color.setAdapter(adapter_color);
        mRecyclerView_color.addOnItemTouchListener(new ItemClickListener(mRecyclerView_color, new ItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                color =  mAttr1ListBeans.get(position).getSaleAttr1Value();
                adapter_color.setSelected(position);
                adapter_color.notifyDataSetChanged();
                //遍历出关联的尺寸
                int maxValue = 1;
                    if (!sizeCode.isEmpty()) sizeCode.clear();
                for (int i = 0; i < mSkuInfoBean.size(); i++) {
                    if (mAttr1ListBeans.get(position).getSaleAttr1ValueCode()
                            .equals(mSkuInfoBean.get(i).getSaleAttr1ValueCode())){
                        sizeCode.add(mSkuInfoBean.get(i).getSaleAttr2ValueCode());
                        Log.i("mip1", "onItemClick: "+sizeCode.size());
                        maxValue = mSkuInfoBean.get(i).getStockNum();
                    }
                }
                Log.i("mip", "onItemClick: "+sizeCode.size());
                //设置最大值
                mCus_add_num.setmMaxValue(maxValue);
                //更改库存数量
                mCus_add_num.setEditData(maxValue<Integer.parseInt(mCus_add_num.getEditData())?
                        maxValue+"":mCus_add_num.getEditData());
                //设置不可点击
                adapter_size.setSizeCode(sizeCode,true);
                adapter_size.notifyDataSetChanged();

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        //构造尺寸数据
        //构造颜色数据
        mAttr2ListBeans =
                mDetailBean.getResult().getSaleAttrList().getSaleAttr2List();

        for (DetailBean.ResultBean.SaleAttrListBean.SaleAttr2ListBean saleAttr2ListBean:mAttr2ListBeans) {
            size_list.add(saleAttr2ListBean.getSaleAttr2Value());
        }
        //        尺寸选择
        MyLayoutManager layout_size = new MyLayoutManager();
        //必须，防止recyclerview高度为wrap时测量item高度0
        layout_size.setAutoMeasureEnabled(true);
        mRecyclerView_size.setLayoutManager(layout_size);
        adapter_size = new SizeAdapter(activity, size_list);
        mRecyclerView_size.setAdapter(adapter_size);
        adapter_size.setSaleAttr2ListBean(mAttr2ListBeans);
        mRecyclerView_size.addOnItemTouchListener(new ItemClickListener(mRecyclerView_size, new ItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //排除不可点击的选项
//                if (sizeCode.get(position)!=size_list.get(position)) {
                if (sizeCode.contains(mAttr2ListBeans.get(position).getSaleAttr2ValueCode())) {
                    size = mAttr2ListBeans.get(position).getSaleAttr2Value();
                    adapter_size.setSelected(position);
                    adapter_size.notifyDataSetChanged();
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        setViewLocation();
        setCanceledOnTouchOutside(true);//外部点击取消
    }

    public void setColorData(DetailBean detailBean){
        mDetailBean = detailBean;
    }

    /**
     * 设置dialog位于屏幕底部
     */
    private void setViewLocation(){
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = height;
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        onWindowAttributesChanged(lp);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                if (mICallBack!=null) mICallBack.setCallBack(color+","+size);
                dismiss();
                break;
        }
    }

    public void setICallBack(ICallBack iCallBack){
        mICallBack = iCallBack;
    }

    public interface ICallBack{
       void setCallBack(String result);
    }

}
