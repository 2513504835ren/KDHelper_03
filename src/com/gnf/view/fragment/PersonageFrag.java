package com.gnf.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gnf.view.R;
import com.gnf.view.adapter.PersonListAdapter;

/**
 * 个人中心界面
 * 
 * @author xin
 * 
 */
public class PersonageFrag extends Fragment {

	private static final String TAG = "ContactFrag";

	private View view;
	private ListView mListView;

	private PersonListAdapter listAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_person, container, false);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mListView = (ListView) view.findViewById(R.id.lv_frag_person);

		listAdapter = new PersonListAdapter(getActivity(), mListView);
	}

}
