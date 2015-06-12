package com.gnf.view.bean;

import com.gnf.view.annotation.dao.Column;
import com.gnf.view.annotation.dao.ID;
import com.gnf.view.annotation.dao.TableName;
import com.gnf.view.dao.ContentValues_DB;


/**
 * 
 * 短信模板实体类
 * @author xin
 *
 */

@TableName(ContentValues_DB.TABLE_TEMPLATE_NAME)
public class Template {
	
	@ID(autoincrement=true)
	@Column(ContentValues_DB.TABLE_ID)
	private int id;		// 模板id
	@Column(ContentValues_DB.COLUMN_TEMPLATE_DETAIL)
	private String detail;	// 模板内容
	@Column(ContentValues_DB.COLUMN_TEMPLATE_TAG)
	private String tag;	// 模板标签
	
	
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
