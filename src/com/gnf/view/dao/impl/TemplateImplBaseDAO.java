package com.gnf.view.dao.impl;

import android.content.Context;

import com.gnf.view.bean.Template;
import com.gnf.view.dao.BaseDAOSupport;
import com.gnf.view.dao.bean.TemplateDao;

/**
 * ��� ģ���� ���ݿ����
 * ������ݱ�����ĳ��󷽷�
 * @author xin
 *
 * @param <Template>
 */
public class TemplateImplBaseDAO extends BaseDAOSupport<Template>  implements TemplateDao{

	public TemplateImplBaseDAO(Context context) {
		super(context);
	}

}
