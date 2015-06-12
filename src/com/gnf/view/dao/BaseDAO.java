package com.gnf.view.dao;

import java.io.Serializable;
import java.util.List;


/**
 * 数据表操作 通用接口定义 
 * 分别为 增 删 改 查
 * @author xin
 *
 * @param <M>
 */
public interface BaseDAO<M> {
	/**
	 * 增加
	 * @param m
	 * @return
	 */
	long insert(M m);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(Serializable id);//int long String
	/**
	 * 修改
	 * @param m
	 * @return
	 */
	int update(M m);
	/**
	 * 查询
	 * @return
	 */
	List<M> findAll();
}
