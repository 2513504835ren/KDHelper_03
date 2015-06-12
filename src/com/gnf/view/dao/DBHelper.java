package com.gnf.view.dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 建立数据表
 * 
 * @author xin
 */
public class DBHelper extends SQLiteOpenHelper implements ContentValues_DB {

	private static final String DB_NAME = "kd_help.db";

	private static final int DB_VERSION = 1;


	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// String sql = create table client(_id primary key
		// autoincrement,client_designation text,client_phone
		// text,client_address text,client_remark text);

		// 创建 客户表
		db.execSQL("CREATE TABLE " + TABLE_CLIENT_NAME + "(" + TABLE_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CLIENT_DESIGNATION
				+ " TEXT," + COLUMN_CLIENT_PHONE + " TEXT,"
				+ COLUMN_CLIENT_ADDRESS + " TEXT," + COLUMN_CLIENT_REMARK
				+ " TEXT)");

		// 创建模板表
		String sql = "CREATE TABLE " + TABLE_TEMPLATE_NAME + "(" + TABLE_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TEMPLATE_DETAIL
				+ " TEXT," + COLUMN_TEMPLATE_TAG + " TEXT)";
		System.out.println(sql);
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
