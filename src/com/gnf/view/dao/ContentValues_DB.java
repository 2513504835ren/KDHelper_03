package com.gnf.view.dao;
/**
 * ���ݱ��� ʱ ʹ�õ� ����
 * @author xin
 *
 */
public interface ContentValues_DB {

	
	public static final String TABLE_ID = "_id";
	
	// �ͻ�������+����+�绰����+��ַ+��ע
	public static final String TABLE_CLIENT_NAME = "client";	// ����
	public static final String COLUMN_CLIENT_DESIGNATION="client_name";	// ����
	public static final String COLUMN_CLIENT_PHONE="client_phone";	// �绰����
	public static final String COLUMN_CLIENT_ADDRESS="client_address";	//��ַ
	public static final String COLUMN_CLIENT_REMARK = "client_remark";	// ��ע
	
	// ģ�������+����+��ǩ
	public static final String TABLE_TEMPLATE_NAME="template";	//����
	public static final String COLUMN_TEMPLATE_DETAIL = "template_detail";	//ģ������
	public static final String COLUMN_TEMPLATE_TAG="template_tag";	// ģ���ǩ
}
