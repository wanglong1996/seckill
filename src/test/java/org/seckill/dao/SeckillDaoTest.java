/**
 * created by wanglong on 2018年3月24日 下午1:48:27
 */
package org.seckill.dao;

import java.util.List;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring与junit整合，junit 启动时加载spring
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
	//注入Dao实现类依赖
	@Autowired
	private SeckillDao seckillDao;
	
	
	
	@Test
	public void testQueryById() throws Exception{
		Date aDate =new Date();
		System.out.println(aDate);
		long id = 1002L;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
	
	@Test
	public void testQueryAll() throws Exception{
		
		List<Seckill> seckills = seckillDao.queryAll(0,100);
		for(Seckill seckill : seckills) {
			System.out.println(seckill);
		}
		
	}
	@Autowired
	private SuccessKilledDao successKilledDao;
	@Test
	public void testInsertSuccessKilled() throws Exception{
		int insertCout = successKilledDao.insertSuccessKilled(1001L, 18715331202L);
		System.out.println(insertCout);
	}
	
	@Test
	public void testQueryByIdWithSeckill() throws Exception{
		long id = 1002L;
		long phone = 17715331202L;
		SuccessKilled su = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(su);
		System.out.println(su.getSeckill());
		
		
	}

}
