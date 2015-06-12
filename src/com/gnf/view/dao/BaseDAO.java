package com.gnf.view.dao;

import java.io.Serializable;
import java.util.List;


/**
 * ���ݱ���� ͨ�ýӿڶ��� 
 * �ֱ�Ϊ �� ɾ �� ��
 * @author xin
 *
 * @param <M>
 */
public interface BaseDAO<M> {
	/**
	 * ����
	 * @param m
	 * @return
	 */
	long insert(M m);
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	int delete(Serializable id);//int long String
	/**
	 * �޸�
	 * @param m
	 * @return
	 */
	int update(M m);
	/**
	 * ��ѯ
	 * @return
	 */
	List<M> findAll();
}
