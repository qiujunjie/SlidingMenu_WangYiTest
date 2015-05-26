package com.example.slidingmenuwangyi.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.slidingmenuwangyi.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class OneFragment extends Fragment {
	private static final String TAG = TestContentFragment.class.getSimpleName();
	String mTitle = "";
	private PullToRefreshListView mListView;
	List<String> list = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		if (args != null) {
			mTitle = args.getString("title");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG, "OneFragment-----onCreate");
		View rootView = inflater.inflate(R.layout.one_fragment,
				container, false);
		initView(rootView);
		return rootView;
	}

	private void initView(View rootView) {
		for (int i = 0; i < 20; i++) {
			list.add("项目"+i);
		}
		mListView = (PullToRefreshListView)rootView.findViewById(android.R.id.list);
		mListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list));
	}
}
