package com.gnf.view.adapter;

import java.util.zip.Inflater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gnf.view.R;

public class PersonListAdapter extends BaseAdapter {

	private Context context;
	private ListView listView;

	private String[] str;

	public PersonListAdapter(Context context, ListView mListView) {
		this.context = context;
		this.listView = mListView;
			str = context.getResources().getStringArray(R.array.frag_person_list);
		listView.setAdapter(this);


	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return str.length;
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

		ViewHolder holder;

		if (null == convertView) {

			convertView = LayoutInflater.from(context).inflate(
					R.layout.adp_frag_person_listview, null);

			holder = new ViewHolder();

			holder.ivIcon = (ImageView) convertView
					.findViewById(R.id.iv_adp_person_icon);
			holder.tv = (TextView) convertView.findViewById(R.id.tv_adp_person);
			holder.ivForword = (ImageView) convertView
					.findViewById(R.id.iv_adp_person_forward);

			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();
		}

		// 如果完成 if 步骤，那么 各个控件已经完成了初始化工作
		// 给各个控件赋值

		holder.tv.setText(str[position]);

		return convertView;

	}

}

class ViewHolder {

	ImageView ivIcon;
	TextView tv;
	ImageView ivForword;
}
