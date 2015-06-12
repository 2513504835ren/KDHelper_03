package com.gnf.view.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gnf.view.R;

public class ContactListAdapter extends BaseAdapter {

	private Context context;
	private ListView mListView;

	private List<Map<String, String>> mList;
	private Map<String, String> mMap;

	public ContactListAdapter(Context context, ListView mListView) {

		this.context = context;
		this.mListView = mListView;

		initDate();

		this.mListView.setAdapter(this);

	}

	/**
	 * 初始化 数据
	 */
	private void initDate() {

		mList = new ArrayList<Map<String, String>>();

		for (int i = 0; i < 20; i++) {

			mMap = new HashMap<String, String>();
			mMap.put("phone", "1538346562" + i);
			mMap.put("detail", "有你的快递，快点来取，过期不候..........................");
			mMap.put("date", "05:33");
			mMap.put("count", "(1)");
			mList.add(mMap);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder_02 holder;
		if (null == convertView) {

			convertView = LayoutInflater.from(context).inflate(
					R.layout.adp_frag_contact_listview, null);

			holder = new ViewHolder_02();

			// 初始化控件

			holder.tvPhone = (TextView) convertView
					.findViewById(R.id.tv_adp_contact_phone);
			holder.tvDetail = (TextView) convertView
					.findViewById(R.id.tv_adp_contact_detail);
			holder.tvCount = (TextView) convertView
					.findViewById(R.id.tv_adp_contact_count);
			holder.tvDate = (TextView) convertView
					.findViewById(R.id.tv_adp_contact_date);

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder_02) convertView.getTag();
		}

		// 给各个控件赋值

		Map<String, String> map = mList.get(position);

		holder.tvPhone.setText(map.get("phone"));
		holder.tvCount.setText(map.get("count"));
		holder.tvDetail.setText(map.get("detail"));
		holder.tvDate.setText(map.get("date"));

		return convertView;
	}

}

class ViewHolder_02 {
	TextView tvPhone;
	TextView tvCount;
	TextView tvDate;
	TextView tvDetail;
}
