package com.gnf.view.dao;
/**
 * 数据表定义 时 使用的 常量
 * @author xin
 *
 */
public interface ContentValues_DB {

	
	public static final String TABLE_ID = "_id";
	
	// 客户表：主键+姓名+电话号码+地址+备注
	public static final String TABLE_CLIENT_NAME = "client";	// 表名
	public static final String COLUMN_CLIENT_DESIGNATION="client_name";	// 姓名
	public static final String COLUMN_CLIENT_PHONE="client_phone";	// 电话号码
	public static final String COLUMN_CLIENT_ADDRESS="client_address";	//地址
	public static final String COLUMN_CLIENT_REMARK = "client_remark";	// 备注
	
	// 模板表：主键+内容+标签
	public static final String TABLE_TEMPLATE_NAME="template";	//表名
	public static final String COLUMN_TEMPLATE_DETAIL = "template_detail";	//模板内容
	public static final String COLUMN_TEMPLATE_TAG="template_tag";	// 模板标签
}
