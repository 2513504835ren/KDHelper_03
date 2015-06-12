package com.gnf.view.bean;

import com.gnf.view.annotation.dao.Column;
import com.gnf.view.annotation.dao.ID;
import com.gnf.view.annotation.dao.TableName;
import com.gnf.view.dao.ContentValues_DB;


/**
 * 
 * ����ģ��ʵ����
 * @author xin
 *
 */

@TableName(ContentValues_DB.TABLE_TEMPLATE_NAME)
public class Template {
	
	@ID(autoincrement=true)
	@Column(ContentValues_DB.TABLE_ID)
	private int id;		// ģ��id
	@Column(ContentValues_DB.COLUMN_TEMPLATE_DETAIL)
	private String detail;	// ģ������
	@Column(ContentValues_DB.COLUMN_TEMPLATE_TAG)
	private String tag;	// ģ���ǩ
	
	
	public Template() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	
}
