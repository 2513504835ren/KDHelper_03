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
		mViewPager.setOffscreenPageLimit(2); // viewPager��Ԥ���ؽ���

		// ʹ��actionbar��ʵ�� tab�ĵ���
		final ActionBar bar = getActionBar();
		
		
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); // ����actionbar�ĵ���ģʽΪѡ������ģʽ

		// ������ʾģʽ������ʾactivity�� �����home
		bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE
				| ActionBar.DISPLAY_SHOW_HOME);

		
		// ��ʼ�� ������
		mTabsAdapter = new TabsAdapter(this, mViewPager);

		// ��� 3�� ��ǩ
		mTabsAdapter.addTab(bar.newTab().setText("ʶ��"), RecognitionFrag.class,
				null);
		mTabsAdapter.addTab(bar.newTab().setText(R.string.tab_sd),
				ContactFrag.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("����.."), PersonageFrag.class,
				null);

		// ����tab ��ʼ��չʾ����
		bar.setSelectedNavigationItem(0);

	}

}
