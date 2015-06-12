package com.gnf.view;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.gnf.view.adapter.TabsAdapter;
import com.gnf.view.fragment.ContactFrag;
import com.gnf.view.fragment.PersonageFrag;
import com.gnf.view.fragment.RecognitionFrag;


/**
 * jjdjfjdk
 * @author ren
 *
 */
public class MainActivity extends Activity {


	private ViewPager mViewPager;

	TabsAdapter mTabsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setOffscreenPageLimit(2); // viewPager的预加载界面

		// 使用actionbar来实现 tab的导航
		final ActionBar bar = getActionBar();
		
		
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); // 设置actionbar的导航模式为选卡导航模式

		// 设置显示模式，不显示activity的 标题和home
		bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE
				| ActionBar.DISPLAY_SHOW_HOME);

		
		// 初始化 适配器
		mTabsAdapter = new TabsAdapter(this, mViewPager);

		// 添加 3个 标签
		mTabsAdapter.addTab(bar.newTab().setText("识别"), RecognitionFrag.class,
				null);
		mTabsAdapter.addTab(bar.newTab().setText(R.string.tab_sd),
				ContactFrag.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("更多.."), PersonageFrag.class,
				null);

		// 设置tab 初始化展示界面
		bar.setSelectedNavigationItem(0);

	}

}
