package org.seckill.dao;

import java.util.List;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

public interface SeckillDao {
	
	/**
	 * �����
	 * @param seckillId
	 * @param killTime
	 * @return ���>1����ʾ��������
	 */
	int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
	
	
	/**
	 * ����Id��ѯ��ɱ����
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * ����ƫ������ѯ��ɱ��Ʒ�б�
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
