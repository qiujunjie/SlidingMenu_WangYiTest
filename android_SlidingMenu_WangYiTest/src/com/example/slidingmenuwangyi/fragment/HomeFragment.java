package com.example.slidingmenuwangyi.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slidingmenuwangyi.R;
import com.example.slidingmenuwangyi.adapter.ContentFragmentPagerAdapter;
import com.example.slidingmenuwangyi.entity.ContentBean;

public class HomeFragment extends Fragment {
	private static final String TAG = TestContentFragment.class.getSimpleName();
	private ViewPager mViewPager;
	private static final String[] titles = {"One","Two","Three","Four","Five"};
	private List<ContentBean> list = new ArrayList<ContentBean>();
	private ContentFragmentPagerAdapter mAdapter;
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		Log.d(TAG, "HomeFragment-----onCreate");
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        
        initData();
        findView(rootView);
        
        return rootView;
    }
	
	private void initData() {
		
		for(int i=0;i<titles.length;i++){
			
			ContentBean cb = new ContentBean();
			cb.setId(i);
			cb.setTitle(titles[i]);
			cb.setContent(titles[i]+"_"+(i+1));
			
			list.add(cb);
		}
	}

	private void findView(View rootView) {
		
		mViewPager = (ViewPager) rootView.findViewById(R.id.mViewPager);
		
		PagerTabStrip mPagerTabStrip = (PagerTabStrip) rootView.findViewById(R.id.mPagerTabStrip);
		mPagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.select_text_color)); 
		
		mAdapter = new ContentFragmentPagerAdapter(getActivity().getSupportFragmentManager(),list);
		mViewPager.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
	}
	
	@Override
	public void onStart() {
		
//		if(mAdapter!=null){
//			mAdapter.notifyDataSetChanged();
//		}
		
		super.onStart();
	}
	
	@Override
	public void onPause() {
		System.out.println("qjj onPause");
		super.onPause();
	}
	
	@Override
	public void onResume() {
		System.out.println("qjj onResume");
		super.onResume();
	}
	
	@Override
	public void onStop() {
		System.out.println("qjj onStop");
		super.onStop();
	}
	
	@Override
	public void onDestroy() {
		System.out.println("qjj onDestroy");
		super.onDestroy();
	}
}
