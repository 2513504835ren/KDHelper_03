package com.gnf.view.dao.impl;

import android.content.Context;

import com.gnf.view.bean.Client;
import com.gnf.view.dao.BaseDAOSupport;
import com.gnf.view.dao.bean.ClientDao;

/**
 * ��� �ͻ��� ���ݿ����
 * ʵ�����ݱ������ ���󷽷�
 * @author xin
 *
 * @param <Client>
 */
public class ClientImplBaseDAO extends BaseDAOSupport<Client> implements ClientDao{

	public ClientImplBaseDAO(Context context) {
		super(context);
	}

}
