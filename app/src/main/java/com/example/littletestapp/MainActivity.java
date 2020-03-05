package com.example.littletestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.littletestapp.dialog.SpecsSelectDialog;
import com.example.littletestapp.fragment.CommentFragment;
import com.example.littletestapp.javaBean.DetailBean;
import com.example.littletestapp.utils.CustomScrollViewPager;
import com.example.littletestapp.utils.HoldTabScrollView;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.littletestapp.adapter.TitleFragmentPagerAdapter;
import com.example.littletestapp.fragment.DetailsFragment;
import com.example.littletestapp.javaBean.ImageSlideshow;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SpecsSelectDialog.ICallBack {

    private ImageSlideshow imageSlideshow;
    private TabLayout mTableLayout;
    private CustomScrollViewPager mViewPager;
    private RelativeLayout mRl_specs;
    private List<String> imageUrlList;
    private List<String> titleList;
    private DetailBean mDetailBean = new DetailBean();
    private TextView mTv_price;
    private TextView mTv_initial_price;
    private TextView mTv_specs;
    private TextView mAdd_to_cart;
    private SpecsSelectDialog mSpecsSelectDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        imageSlideshow = (ImageSlideshow) findViewById(R.id.is_gallery);
        mTableLayout = (TabLayout) findViewById(R.id.tab);
        mViewPager = (CustomScrollViewPager) findViewById(R.id.viewpager);
        mRl_specs = (RelativeLayout) findViewById(R.id.rl_specs);
        mTv_price = (TextView) findViewById(R.id.tv_price);
        mTv_initial_price = (TextView) findViewById(R.id.tv_initial_price);
        mTv_specs = (TextView) findViewById(R.id.tv_specs);
        mAdd_to_cart = (TextView) findViewById(R.id.add_to_cart);
        imageUrlList = new ArrayList<>();
        titleList = new ArrayList<>();

        // 初始化数据
        initBean();
        initData();
        initView();
        initFragment();
        initClick();

        // 为ImageSlideshow设置数据
        imageSlideshow.setDotSpace(12);
        imageSlideshow.setDotSize(20);
        imageSlideshow.setDelay(1000);
        imageSlideshow.setOnItemClickListener(new ImageSlideshow.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
        imageSlideshow.commit();
    }

    private void initView() {
        mTv_price.setText("￥"+mDetailBean.getResult().getSalePrice()+"");
        mTv_initial_price.setText("初上市价格：￥"+mDetailBean.getResult().getMarketPrice()+"");
    }

    private void initBean() {
        try {
            StringBuilder data = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    getResources().getAssets().open("data.json")));
            String line;
            while ((line=reader.readLine())!=null){
                data.append(line);
            }
            String reponData = data.toString();
            parseJSONWithGSON(reponData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initClick() {
        mRl_specs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSpecsSelectDialog.show();
            }
        });
        mAdd_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddressListActivity.class));
            }
        });
    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DetailsFragment(mViewPager));
        fragments.add(new CommentFragment(mViewPager));

        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getSupportFragmentManager(), fragments, new String[]{"详情", "评论"});
        mViewPager.setAdapter(adapter);

        mTableLayout.setupWithViewPager(mViewPager);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mSpecsSelectDialog  = new SpecsSelectDialog(MainActivity.this,this);
        mSpecsSelectDialog.setColorData(mDetailBean);
        List<DetailBean.ResultBean.GalleryListBean> galleryListBeans =  mDetailBean.getResult().getGalleryList();
        for (int i = 0; i < galleryListBeans.size(); i++) {
            imageSlideshow.addImageTitle(galleryListBeans.get(i).getImageUrl(),
                    galleryListBeans.get(i).getImageName());
        }
    }

    @Override
    protected void onDestroy() {
        // 释放资源
        imageSlideshow.releaseResource();
        super.onDestroy();
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        mDetailBean = gson.fromJson(jsonData, new TypeToken<DetailBean>() {
        }.getType());

    }

    @Override
    public void setCallBack(String result) {
        mTv_specs.setText(result);
    }
}
