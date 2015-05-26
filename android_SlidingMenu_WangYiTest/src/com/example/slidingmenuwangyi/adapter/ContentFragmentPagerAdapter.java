package com.example.slidingmenuwangyi.adapter;

import java.util.List;

import com.example.slidingmenuwangyi.entity.ContentBean;
import com.example.slidingmenuwangyi.fragment.ManagerFragment;
import com.example.slidingmenuwangyi.fragment.TestContentFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.ViewGroup;

public class ContentFragmentPagerAdapter extends FragmentPagerAdapter implements
		OnPageChangeListener {

	private List<ContentBean> list;
	private FragmentManager mFragmentManager;

	public ContentFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public ContentFragmentPagerAdapter(FragmentManager fm,
			List<ContentBean> list) {
		super(fm);
		this.list = list;
		this.mFragmentManager = fm;
	}

	@Override
	public Fragment getItem(int pos) {
//		return ManagerFragment.newInstance(list.get(pos));

		 return TestContentFragment.newInstance(list.get(pos).getContent());

	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Log.e("ContentFragmentPagerAdapter", "position = " + position);
		// return super.instantiateItem(container, position);
		Fragment fragment = getItem(position);
		if (!fragment.isAdded()) { // 如果fragment还没有added
			FragmentTransaction ft = mFragmentManager.beginTransaction();
			ft.add(fragment, fragment.getClass().getSimpleName());
			ft.commit();
			/**
			 * 在用FragmentTransaction.commit()方法提交FragmentTransaction对象后
			 * 会在进程的主线程中，用异步的方式来执行。 如果想要立即执行这个等待中的操作，就要调用这个方法（只能在主线程中调用）。
			 * 要注意的是，所有的回调和相关的行为都会在这个调用中被执行完成，因此要仔细确认这个方法的调用位置。
			 */
			mFragmentManager.executePendingTransactions();
		}

		if (fragment.getView().getParent() == null) {
			container.addView(fragment.getView()); // 为viewpager增加布局
		}

		return fragment.getView();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return list.get(position).getTitle();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}

}
