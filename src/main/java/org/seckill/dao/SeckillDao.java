package org.seckill.dao;

import java.util.List;
import java.sql.Date;

import org.seckill.entity.Seckill;

public interface SeckillDao {
	
	/**
	 * �����
	 * @param seckillId
	 * @param killTime
	 * @return ���>1����ʾ��������
	 */
	int reduceNumber(long seckillId, Date killTime);
	
	
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
	List<Seckill> queryAll(int offset, int limit);

}
