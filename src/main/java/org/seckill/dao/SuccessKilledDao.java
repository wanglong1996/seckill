/**

 * created by wanglong on 2018��3��23�� ����9:57:38
 */
package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * ���빺����ϸ���ɹ����ظ�����
	 * @param seckillId
	 * @param userPhone
	 * @return ��������
	 */
	int insertSuccessKilled(long seckillId,long userPhone);
	/**
	 * ����id ��ѯSuccesskilled�������ش���ɱ��Ʒ����ʵ��
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(long seckillId);
	
	

}
