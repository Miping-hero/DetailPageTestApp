package com.example.littletestapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.littletestapp.AddressListActivity;
import com.example.littletestapp.R;
import com.example.littletestapp.utils.CustomScrollViewPager;

public class DetailsFragment extends Fragment {

    private CustomScrollViewPager viewPager;
    public DetailsFragment(CustomScrollViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_detail, null);
        viewPager.setObjectForPosition(view,0);
        return view;
    }
}
