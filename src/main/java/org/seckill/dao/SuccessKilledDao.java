/**

 * created by wanglong on 2018年3月23日 下午9:57:38
 */
package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * 插入购买明细，可过滤重复操作
	 * @param seckillId
	 * @param userPhone
	 * @return 插入行数
	 */
	int insertSuccessKilled(long seckillId,long userPhone);
	/**
	 * 根据id 查询Successkilled，并返回带秒杀产品对象实体
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(long seckillId);
	
	

}
