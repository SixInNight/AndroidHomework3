package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView lav;
    private ListView lvv;
    ArrayAdapter<String> aa;
    private String[] items = {"王一", "赵二", "张三", "李四", "肖五", "侯六", "胡七", "夏八"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View v = inflater.inflate(R.layout.fragment_placeholder, container, false);
        lav = v.findViewById(R.id.lav);
        lvv = v.findViewById(R.id.lvv);
        aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, items);
        lvv.setAdapter(aa);
        lvv.setAlpha(0);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator ex3_4_1 = ObjectAnimator.ofFloat(lav, "alpha", 1.0f, 0f);
                ex3_4_1.setDuration(800);
                ObjectAnimator ex3_4_2 = ObjectAnimator.ofFloat(lvv,"alpha",0f,1.0f);
                ex3_4_2.setDuration(800);
                AnimatorSet ex3_4 = new AnimatorSet();
                ex3_4.playTogether(ex3_4_1, ex3_4_2);
                ex3_4.start();
            }
        }, 5000);
    }
}
