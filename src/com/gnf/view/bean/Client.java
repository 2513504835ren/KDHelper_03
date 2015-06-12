package com.gnf.view.bean;

import com.gnf.view.annotation.dao.Column;
import com.gnf.view.annotation.dao.ID;
import com.gnf.view.annotation.dao.TableName;
import com.gnf.view.dao.ContentValues_DB;

/**
 * �ͻ�ʵ����
 * @author xin
 *
 */
@TableName(ContentValues_DB.TABLE_CLIENT_NAME)
public class Client {

	@ID(autoincrement=true)
	@Column(ContentValues_DB.TABLE_ID)
	private int id;
	@Column(ContentValues_DB.COLUMN_CLIENT_DESIGNATION)
	private String designation;	// �ͻ�����
	@Column(ContentValues_DB.COLUMN_CLIENT_ADDRESS)
	private String address;	// �ͻ���ַ
	@Column(ContentValues_DB.COLUMN_CLIENT_PHONE)
	private String phoneNum;	// �ͻ��绰����
	@Column(ContentValues_DB.COLUMN_CLIENT_REMARK)
	private String remark;	// ��ע
	
	private String sortLetters;	//��ʾ����ƴ��������ĸ

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSortLetters() {
		return sortLetters;
	}

	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}
	
	
	/*
	 * 
	 * 	create table client_db(_id integer primary key,name text,address text,phoneNum text,remark text)
	 * 
	 */
	
	

}
