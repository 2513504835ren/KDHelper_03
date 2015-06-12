package com.gnf.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.gnf.view.R;


/**
 * 识别界面
 * @author xin
 * 识别界面设计
 */

public class RecognitionFrag extends Fragment {
	private static final String TAG = "ContactFrag";
	private View view;
	
	private Spinner sp;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		sp = (Spinner) view.findViewById(R.id.sp_recognition);

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_recognition, container, false);
		return view;
	}
	
	
	
	
	
	
	
	
	
	
}
