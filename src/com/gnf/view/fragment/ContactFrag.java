package com.gnf.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.gnf.view.R;
import com.gnf.view.adapter.ContactListAdapter;
import com.gnf.view.custom.FloatingActionButton;
import com.gnf.view.custom.FloatingActionsMenu;
import com.gnf.view.fragment.contact.CreateSms;

/**
 * 
 * 联系收件人界面
 * @author xin
 * 
 * 
 */
public class ContactFrag extends Fragment {

	private static final String TAG = "ContactFrag";

	private View view;

	private ListView mListView;

	private ContactListAdapter mListAdapter;

	private FloatingActionsMenu fam;
	private FloatingActionButton action_a;
	private FloatingActionButton action_b;

	//
	// private FragmentManager fragmentManager;
	//
	// private CreateSmsFrag createSmsFrag;
	//

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_contact, container, false);

		return view;

	}

	@SuppressLint("NewApi")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		mListView = (ListView) view.findViewById(R.id.lv_frag_contact);

		fam = (FloatingActionsMenu) view.findViewById(R.id.multiple_actions); // 悬浮菜单
		action_a = (FloatingActionButton) view.findViewById(R.id.action_a); // 悬浮子菜单1
		action_b = (FloatingActionButton) view.findViewById(R.id.action_b); // 悬浮子菜单2

		// fragmentManager = getChildFragmentManager();

		// FragmentTransaction beginTransaction =
		// fragmentManager.beginTransaction();

		// 子菜单1
		action_a.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(view.getContext(), "新建短信", 0).show();
				fam.toggle();
				Intent intent = new Intent(getActivity(),CreateSms.class);
				startActivity(intent);
			}
		});

		// 子菜单2
		action_b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(view.getContext(), "通话中心", 0).show();
				fam.toggle();
			}
		});

		mListAdapter = new ContactListAdapter(getActivity(), mListView);
	}

}
