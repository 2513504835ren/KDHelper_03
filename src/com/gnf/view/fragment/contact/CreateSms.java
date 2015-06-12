package com.gnf.view.fragment.contact;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.gnf.view.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class CreateSms extends SlidingFragmentActivity implements OnClickListener{
	
	

	private static final String TAG ="CreateSms";
	private ImageView ivLeft;
	private ImageView ivRight;
	private SlidingMenu sm;
	
	private SmsContact smsContact;	// 联系人界面
	private SmsTemplate smsTemplate;	// 短信模板界面
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setBehindContentView(R.layout.slideing_create_sms_menu);
		setContentView(R.layout.slideing_create_sms);
		sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT_RIGHT);
		sm.setBehindWidth(300);
		sm.setShadowWidth(300);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		sm.setSecondaryMenu(R.layout.slideing_create_sms_menu_right);
		init();
	}

	/**
	 * 初始化控件
	 */
	private void init() {
		
		smsContact = new SmsContact();
		smsTemplate = new SmsTemplate();
		
		ivLeft = (ImageView) findViewById(R.id.iv_left_menu);
		ivRight = (ImageView) findViewById(R.id.iv_right_menu);
		
		ivLeft.setOnClickListener(this);
		ivRight.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.iv_left_menu:
			toggle();
			showMenu(smsTemplate, "smsTemplate");
			break;
		case R.id.iv_right_menu:
			toggle();
			showMenu(smsContact, "smsContact");
			sm.showSecondaryMenu();
			break;
		}
		
	}

	/**
	 * 
	 * @param fm	要显示的fragment
	 * @param tag	标记
	 */
	private void showMenu(Fragment fm, String tag) {
		if (fm == null) {
			if (fm instanceof SmsContact) {
				fm = new SmsContact();
				Log.d(TAG, "SmsContact被初始化");
				
				getFragmentManager().beginTransaction()
						.replace(R.id.slideing_menu_right, fm, tag).commit();
			} else if (fm instanceof SmsTemplate) {
				fm = new SmsTemplate();
				getFragmentManager().beginTransaction()
						.replace(R.id.slideing_menu, fm, tag).commit();
			}
		} else {
			if (fm instanceof SmsContact) {
				Log.d(TAG, "SmsContact没有被初始化");
				
				getFragmentManager().beginTransaction()
						.replace(R.id.slideing_menu_right, fm, tag).commit();
			} else if (fm instanceof SmsTemplate) {
				getFragmentManager().beginTransaction()
						.replace(R.id.slideing_menu, fm, tag).commit();
			}
		}
	}
}
