/**
 * created by wanglong on 2018��3��24�� ����7:20:15
 */
package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

/**
 * ҵ��ӿڣ�վ�ڡ�ʹ���ߡ��Ƕ���ƽӿ�
 *�������棺�����������ȣ��������������ͣ�return ���ͣ�
 *
 */
public interface SeckillService {
	
	/**
	 * ��ѯ������ɱ��¼
	 * @return
	 */
	List<Seckill> getSeckillList(); 
	
	/**
	 * ��ѯ������ɱ��¼
	 * @param seckill
	 * @return
	 */
	Seckill getById(long seckill);
	
	/**
	 * ��ɱ��������ɱ�ӿڵ�ַ
	 * �������ϵͳʱ�����ɱʱ��
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * ִ����ɱ����
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) 
			throws SeckillException, RepeatKillException, SeckillCloseException;//дǰ��һ���쳣������
	
}











