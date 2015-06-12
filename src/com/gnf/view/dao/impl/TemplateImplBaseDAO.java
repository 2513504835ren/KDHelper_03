package com.gnf.view.dao.impl;

import android.content.Context;

import com.gnf.view.bean.Template;
import com.gnf.view.dao.BaseDAOSupport;
import com.gnf.view.dao.bean.TemplateDao;

/**
 * 完成 模板表的 数据库操作
 * 完成数据表操作的抽象方法
 * @author xin
 *
 * @param <Template>
 */
public class TemplateImplBaseDAO extends BaseDAOSupport<Template>  implements TemplateDao{

	public TemplateImplBaseDAO(Context context) {
		super(context);
	}

}
