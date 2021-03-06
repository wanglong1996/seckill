/**
 * created by wangLong on 2018年3月24日 下午7:20:15
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
 * 业务接口：站在“使用者”角度设计接口
 *三个方面：方法定义粒度，参数，返回类型（return 类型）
 *
 */
public interface SeckillService {
	
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList(); 
	
	/**
	 * 查询单个秒杀记录
	 * @param seckill
	 * @return
	 */
	Seckill getById(Long seckill);
	
	/**
	 * 秒杀开启是秒杀接口地址
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(Long seckillId);
	
	/**
	 * 执行秒杀操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5) 
			throws SeckillException, RepeatKillException, SeckillCloseException;//写前面一个异常就行了
	
}











