package com.gnf.view.dao.impl;

import android.content.Context;

import com.gnf.view.bean.Client;
import com.gnf.view.dao.BaseDAOSupport;
import com.gnf.view.dao.bean.ClientDao;

/**
 * 完成 客户表 数据库操作
 * 实现数据表操作的 抽象方法
 * @author xin
 *
 * @param <Client>
 */
public class ClientImplBaseDAO extends BaseDAOSupport<Client> implements ClientDao{

	public ClientImplBaseDAO(Context context) {
		super(context);
	}

}
