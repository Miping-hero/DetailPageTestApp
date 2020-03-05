package com.example.littletestapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.littletestapp.R;
import com.example.littletestapp.utils.CustomScrollViewPager;

public class CommentFragment extends Fragment {
    private CustomScrollViewPager viewPager;
    public CommentFragment(CustomScrollViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_comment, null);
        viewPager.setObjectForPosition(view,0);
        return view;
    }
}
