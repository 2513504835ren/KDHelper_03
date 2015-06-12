package com.gnf.view.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract.Data;
import android.util.Log;

import com.gnf.view.annotation.dao.Column;
import com.gnf.view.annotation.dao.ID;
import com.gnf.view.annotation.dao.TableName;

/**
 * ���� ���ݱ�� ʵ����
 * @author xin
 * @param <M>
 */

public abstract class BaseDAOSupport<M> implements BaseDAO<M> {
	// ����һ�������Ļ�ȡ
	// ���������ν�ʵ���е����ݣ����ն�Ӧ��ϵ���뵽���ݿ����
	// �������������ݱ����е����ݣ����ն�Ӧ��ϵ���뵽ʵ����
	// �����ģ���ȷʵ������������ȡ�������з�װ��ֵ
	// �����壺ʵ��Ķ��󴴽�

	private static final String TAG = "DAOSupport";
	protected Context context;
	protected DBHelper helper;
	protected SQLiteDatabase db;

	public BaseDAOSupport(Context context) {
		super();
		this.context = context;
		helper = new DBHelper(context);
		db = helper.getWritableDatabase();
	}

	@Override
	public long insert(M m) {
		ContentValues values = new ContentValues();
		fillColumn(m, values);// ����Ԫ��һ�������������Ŀ��ڶ�������
		return db.insert(getTableName(), null, values);
	}

	@Override
	public int delete(Serializable id) {
		return db.delete(getTableName(), DBHelper.TABLE_ID + " =?", new String[] { id.toString() });
	}

	@Override
	public int update(M m) {
		ContentValues values = new ContentValues();
		fillColumn(m, values);
		return db.update(getTableName(), values, DBHelper.TABLE_ID + " =?", new String[] { getId(m) });
	}

	public List<M> findByCondition(String[] columns, String selection, String[] selectionArgs, String orderBy) {
		return findByCondition(columns, selection, selectionArgs, null, null, orderBy);
	}

	/**
	 * ������ѯ
	 * 
	 * @param columns
	 * @param selection
	 * @param selectionArgs
	 * @param groupBy
	 * @param having
	 * @param orderBy
	 * @return
	 */
	public List<M> findByCondition(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		List<M> result = null;// List<M>
		Cursor cursor = db.query(getTableName(), columns, selection, selectionArgs, groupBy, having, orderBy);

		if (cursor != null) {
			result = new ArrayList<M>();
			while (cursor.moveToNext()) {
				M m = getInstantce();
				fillField(cursor, m);

				result.add(m);
			}
			cursor.close();
		}

		return result;

	}

	@Override
	public List<M> findAll() {
		List<M> result = null;// List<M>
		Cursor cursor = db.query(getTableName(), null, null, null, null, null, null);

		if (cursor != null) {
			result = new ArrayList<M>();
			while (cursor.moveToNext()) {
				M m = getInstantce();
				fillField(cursor, m);

				result.add(m);
			}
			cursor.close();
		}

		return result;
	}

	/**
	 * ����һ�������Ļ�ȡ
	 * 
	 * @return
	 */
	private String getTableName() {
		// ÿ�����Ӧһ������ʵ��
		// ����һ������ܹ���ȡ��ʵ�壬��ȡ��ʵ��ļ����ƣ�����ĸСд
		// ������������ע�⣬ʵ������ݿ������������ϵ

		// ��ȡ��ʵ�塪��������
		M m = getInstantce();
		// ��ȡʵ���ע�⣬����value������ֵȷ�����������ݿ��

		// �����Ҫ�����е�ʱ���ȡ��ע�����Ϣ�����ô��ʱ��
		TableName tableName = m.getClass().getAnnotation(TableName.class);// annotationType:ע�������
		if (tableName != null) {
			return tableName.value();
		}
		return "";
	}

	/**
	 * ���������ν�ʵ���е����ݣ����ն�Ӧ��ϵ���뵽���ݿ����
	 */
	private void fillColumn(M m, ContentValues values) {
		// values.put(DBHelper.TABLE_NEWS_TITLE, news.getTitle());
		// �˴�ʡ��n�д���

		// for all public fields for the class
		// m.getClass().getFields();
		Field[] fields = m.getClass().getDeclaredFields();
		for (Field item : fields) {
			item.setAccessible(true);
			Column column = item.getAnnotation(Column.class);
			
			Log.d(TAG, "");
			if (column != null) {
				
				// key ��Ϊ���� ���ݿ������
				String key = column.value();
				Log.d(TAG, "");
				
				// Returns the value of the field in the specified object.
				try {
				
					Log.d(TAG, "");
					// valueΪ�������ݱ��ֵ
					Object object = item.get(m);
					// �ж�item.get �Ƿ�Ϊ�գ����Ϊ�գ����������ѭ����ִ����һ�α���
					if(object==null){
						continue;
					}
					
					
					String value = item.get(m).toString();
						Log.d(TAG, "");
						// �����field�������������������ģ�������ӵ�������
						ID id = item.getAnnotation(ID.class);
						if (id != null && id.autoincrement()) {
						} else {
							 
							/*
							 * key Ϊ�������ݿ������
							 * value Ϊ�������ݿ��ֵ
							 */
							values.put(key, value);
							Log.d(TAG, "");
						}
					
					

				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * �������������ݱ����е����ݣ����ն�Ӧ��ϵ���뵽ʵ����
	 * 
	 * @param cursor
	 * @param m
	 */
	private void fillField(Cursor cursor, M m) {
		/*
		 * int columnIndex = cursor.getColumnIndex(DBHelper.TABLE_NEWS_TITLE); String title = cursor.getString(columnIndex); news.setTitle(title); // �˴�ʡ��n�д���
		 */
		Field[] fields = m.getClass().getDeclaredFields();
		for (Field item : fields) {
			item.setAccessible(true);
			Column column = item.getAnnotation(Column.class);
			if (column != null) {
				int columnIndex = cursor.getColumnIndex(column.value());
				String value = cursor.getString(columnIndex);
				// Sets the value of the field in the specified object to the value.
				try {

					if (item.getType() == int.class) {
						item.set(m, Integer.parseInt(value));
					} else if (item.getType() == Data.class) {
						// �ַ���ת��ʱ��
					} else {
						item.set(m, value);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * �����ģ���ȷʵ������������ȡ�������з�װ��ֵ
	 */
	private String getId(M m) {
		Field[] fields = m.getClass().getDeclaredFields();
		for (Field item : fields) {
			item.setAccessible(true);
			ID id = item.getAnnotation(ID.class);

			if (id != null) {
				try {
					return item.get(m).toString();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	/**
	 * �����壺ʵ��Ķ��󴴽�
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private M getInstantce() {
		// ʵ���Ǻ�ʱȷ����

		// ���Ǹ����ӵ��õĸ÷��������Ǹ�����������
		// ���ش� Object ������ʱ�ࡣ
		Class clazz = getClass();
		// Log.i(TAG, clazz.toString());
		// �ڻ�ȡ�ú��ӵĸ��ࣨ��֧�ַ��͡��ĸ��ࣩ
		// clazz.getSuperclass();//
		Type superclass = clazz.getGenericSuperclass();//
		// ����ʵ�ֽӿڣ������������ͣ����涨�˷��͵�ͨ�ò���
		if (superclass != null && superclass instanceof ParameterizedType) {
			Type[] arguments = ((ParameterizedType) superclass).getActualTypeArguments();// 
			
			Log.d(TAG, arguments[0]+"");
			try {
				
				return (M) ((Class) arguments[0]).newInstance();
				
			} catch (InstantiationException e) {
				Log.d(TAG, arguments[0]+"");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				Log.d(TAG, arguments[0]+"");
				e.printStackTrace();
			}
			// Log.i(TAG, "");
		}

		// �ۻ�ȡ�������еĲ���
		return null;
	}

}
