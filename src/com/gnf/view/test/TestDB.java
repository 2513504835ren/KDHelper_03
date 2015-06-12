package com.gnf.view.test;

import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.gnf.view.bean.Client;
import com.gnf.view.bean.Template;
import com.gnf.view.dao.DBHelper;
import com.gnf.view.dao.impl.ClientImplBaseDAO;
import com.gnf.view.dao.impl.TemplateImplBaseDAO;

public class TestDB extends AndroidTestCase {

	private static final String TAG = "TestDB";

	// 测试创建数据表
	public void testCreateDB(){
		
		DBHelper helper = new DBHelper(getContext());
		helper.getWritableDatabase();
	}
	
	
	/**
	 * 数据库插入操作 经测试 工作正常....
	 */
	public void testInsert(){
		ClientImplBaseDAO clientDao = new ClientImplBaseDAO(getContext());
		Client m = new Client();
		m.setDesignation("张无忌");
		m.setPhoneNum("273733");
		clientDao.insert(m);
	}
	
	public void testTemInsert(){
		TemplateImplBaseDAO temp = new TemplateImplBaseDAO(getContext());
		Template m = new Template();
		m.setTag("太原工业学院");
	//	m.setDetail("速来取快递...");
		long insert = temp.insert(m);
		Log.d(TAG, insert+":插入数据库之后的返回值");
	}
	
	
	/**
	 * 测试 数据库 删除操作
	 * 
	 * 经测试 ，删除操作 工作正常
	 */
	public void testDeleteClient(){
		ClientImplBaseDAO clientDao = new ClientImplBaseDAO(getContext());
		clientDao.delete(1);
		
	}public void testDeleteTemplate(){
		TemplateImplBaseDAO temp = new TemplateImplBaseDAO(getContext());
		temp.delete(3);
	}
	
	
	/**
	 * 测试 update 操作
	 * 
	 * 经测试，update 操作 工作正常
	 */
	
	public void testUpdateClient(){
		ClientImplBaseDAO clientDao = new ClientImplBaseDAO(getContext());
		
		Client m = new Client();
		m.setId(2);
		m.setDesignation("张三丰");
		m.setAddress("武当派掌门");
		clientDao.update(m);
		
	}
	public void testUpdateTemplate(){
		TemplateImplBaseDAO temp = new TemplateImplBaseDAO(getContext());
		Template m = new Template();
		m.setId(2);
		m.setTag("太原工业学院");
		m.setDetail("速来取快递...");
		temp.update(m);
	}
	
	
	/**
	 * 测试 最复杂的查询操作
	 * 
	 * 测试 查询操作正常
	 */

	public void testFindClient(){
		ClientImplBaseDAO clientDao = new ClientImplBaseDAO(getContext());
		
		List<Client> findAll = clientDao.findAll();
		Log.i(TAG, "");
		
	}
	
	
	public void testFindTemplate(){
		TemplateImplBaseDAO temp = new TemplateImplBaseDAO(getContext());
		List<Template> findAll = temp.findAll();
		Log.i(TAG, "");
		
	}
}
