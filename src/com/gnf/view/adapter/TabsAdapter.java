package com.gnf.view.adapter;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

/**
 * viewPager的适配器
 * @author xin
 */
public class TabsAdapter extends FragmentPagerAdapter implements
		ActionBar.TabListener, ViewPager.OnPageChangeListener {

	private static final String TAG = "TabsAdapter";
	private final Context mContext;
	private final ActionBar mActionBar;
	private final ViewPager mViewPager;
	private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

	final class TabInfo {
		private final Class<?> clss;
		private final Bundle args;
		private Fragment fragment;

		TabInfo(Class<?> _class, Bundle _args) {
			clss = _class;
			args = _args;
		}
	}

	public TabsAdapter(Activity activity, ViewPager pager) {
		super(activity.getFragmentManager());
		mContext = activity;
		mActionBar = activity.getActionBar();
		mViewPager = pager;

		mViewPager.setAdapter(this);
		mViewPager.setOnPageChangeListener(this);
	}

	/**
	 * 增加tab
	 * 
	 * @param tab
	 * @param clss
	 * @param args
	 */
	public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
		TabInfo info = new TabInfo(clss, args);
		tab.setTag(info);
		tab.setTabListener(this);
		mTabs.add(info);
		mActionBar.addTab(tab);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mTabs.size();
	}

	@Override
	public Fragment getItem(int position) {
		TabInfo info = mTabs.get(position);
		if (info.fragment == null) {
			info.fragment = Fragment.instantiate(mContext, info.clss.getName(),
					info.args);
		}
		return info.fragment;
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
		// Log.d(TAG, "onPageScrolled() 执行");
	}

	@Override
	public void onPageSelected(int position) {

		Log.d(TAG, "onPageSelected()方法执行");

		// Log.d(TAG, "滑动" + position);

		mActionBar.setSelectedNavigationItem(position);
	}

	@Override
	public void onPageScrollStateChanged(int state) {

		Log.d(TAG, "onPageScrollStateChanged方法执行");

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		Log.d(TAG, "onTabSelected被选中");

		Object tag = tab.getTag();
		for (int i = 0; i < mTabs.size(); i++) {
			if (mTabs.get(i) == tag) {
				mViewPager.setCurrentItem(i);
			}
		}

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
}
