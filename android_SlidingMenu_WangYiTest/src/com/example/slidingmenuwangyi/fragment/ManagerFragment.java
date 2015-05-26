package com.example.slidingmenuwangyi.fragment;

import com.example.slidingmenuwangyi.entity.ContentBean;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class ManagerFragment {
	public static Fragment newInstance(ContentBean bean) {
		Fragment newFragment = null;
//		switch (bean.getId()) {
//		case 0:
//			newFragment = new OneFragment();
//			Bundle bundle = new Bundle();
//	        bundle.putString("title", bean.getTitle());
//	        newFragment.setArguments(bundle);
//			break;
//
//		default:
//			break;
//		}
		newFragment = new OneFragment();
		Bundle bundle = new Bundle();
        bundle.putString("title", bean.getTitle());
        newFragment.setArguments(bundle);
        return newFragment;

    }
}
