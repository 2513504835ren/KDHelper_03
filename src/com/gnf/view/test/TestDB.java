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

	// ���Դ������ݱ�
	public void testCreateDB(){
		
		DBHelper helper = new DBHelper(getContext());
		helper.getWritableDatabase();
	}
	
	
	/**
	 * ���ݿ������� ������ ��������....
	 */
	public void testInsert(){
		ClientImplBaseDAO clientDao = new ClientImplBaseDAO(getContext());
		Client m = new Client();
		m.setDesignation("���޼�");
		m.setPhoneNum("273733");
		clientDao.insert(m);
	}
	
	public void testTemInsert(){
		TemplateImplBaseDAO temp = new TemplateImplBaseDAO(getContext());
		Template m = new Template();
		m.setTag("̫ԭ��ҵѧԺ");
	//	m.setDetail("����ȡ���...");
		long insert = temp.insert(m);
		Log.d(TAG, insert+":�������ݿ�֮��ķ���ֵ");
	}
	
	
	/**
	 * ���� ���ݿ� ɾ������
	 * 
	 * ������ ��ɾ������ ��������
	 */
	public void testDeleteClient(){
		ClientImplBaseDAO clientDao = new ClientImplBaseDAO(getContext());
		clientDao.delete(1);
		
	}public void testDeleteTemplate(){
		TemplateImplBaseDAO temp = new TemplateImplBaseDAO(getContext());
		temp.delete(3);
	}
	
	
	/**
	 * ���� update ����
	 * 
	 * �����ԣ�update ���� ��������
	 */
	
	public void testUpdateClient(){
		ClientImplBaseDAO clientDao = new ClientImplBaseDAO(getContext());
		
		Client m = new Client();
		m.setId(2);
		m.setDesignation("������");
		m.setAddress("�䵱������");
		clientDao.update(m);
		
	}
	public void testUpdateTemplate(){
		TemplateImplBaseDAO temp = new TemplateImplBaseDAO(getContext());
		Template m = new Template();
		m.setId(2);
		m.setTag("̫ԭ��ҵѧԺ");
		m.setDetail("����ȡ���...");
		temp.update(m);
	}
	
	
	/**
	 * ���� ��ӵĲ�ѯ����
	 * 
	 * ���� ��ѯ��������
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
