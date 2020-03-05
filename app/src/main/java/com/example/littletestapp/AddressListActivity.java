package com.example.littletestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.littletestapp.adapter.AddressAdapter;
import com.example.littletestapp.adapter.ColorAdapter;
import com.example.littletestapp.javaBean.AddressBean;
import com.example.littletestapp.javaBean.DetailBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddressListActivity  extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TextView add_address;
    private AddressAdapter mAddressAdapter;
    private AddressBean mAddressBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_address_list);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_address);
        add_address = (TextView)findViewById(R.id.add_address);


        initData();
        initView();
    }

    private void initData() {
        try {
            StringBuilder data = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    getResources().getAssets().open("addressData.json")));
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

    private void initView() {
        // 设置布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAddressAdapter = new AddressAdapter(this, mAddressBean.getResult());
        mRecyclerView.setAdapter(mAddressAdapter);

        add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddressListActivity.this,EditActivity.class));
            }
        });
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        mAddressBean = gson.fromJson(jsonData, new TypeToken<AddressBean>() {
        }.getType());

    }
}
