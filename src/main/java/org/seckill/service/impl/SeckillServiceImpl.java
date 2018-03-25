/**
 * created by wanglong on 2018��3��24�� ����8:21:36
 */
package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import ch.qos.logback.classic.Logger;

@Component
public class SeckillServiceImpl implements SeckillService {
	
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	//ע��service����
	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	private final String slat = "***jjsimida123456789";
	/* (non-Javadoc)
	 * @see org.seckill.service.SeckillService#getSeckillList()
	 */
	public List<Seckill> getSeckillList() {
		// TODO Auto-generated method stub
		return seckillDao.queryAll(0, 4);
	}

	/* (non-Javadoc)
	 * @see org.seckill.service.SeckillService#getById(long)
	 */
	public Seckill getById(long seckillId) {
		// TODO Auto-generated method stub
		return seckillDao.queryById(seckillId);
	}

	/* (non-Javadoc)
	 * @see org.seckill.service.SeckillService#exportSeckillUrl(long)
	 */
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if(seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if (nowTime.getTime()<startTime.getTime()||
				nowTime.getTime()>endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(),startTime.getTime(),
					endTime.getTime());
		}
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5,seckillId);
	}
	
	private String getMD5(long seckillId) {
		
		String base = seckillId+slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
	

	/* (non-Javadoc)
	 * @see org.seckill.service.SeckillService#executeSeckill(long, long, java.lang.String)
	 */
	@Transactional
	/**
	 * ʹ��ע��������﷽���ŵ�
	 * 1�������ŶӴ��һ�£���ȷ��ע���񷽷��ı�̷��
	 * 2����֤����ִ��ʱ�価���ܵĶ�
	 * ��Ҫ���������������rpc/http
	 * 3:�������з�����Ҫ���ֻ��һ���޸Ĳ����Ͳ���Ҫ��ֻ��Ҳ��Ҫ
	 */
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		// TODO Auto-generated method stub
		if(md5==null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill data rewrite");
		}
		//ʵ���߼��������+�ӹ�����Ϊ
		Date nowTime = new Date();
		
		try {
		int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
		if(updateCount <= 0) {
			//û�и��µ���¼����ɱ����
			throw new SeckillCloseException("sekill is closed");
		}else {
			//��¼������Ϊ
			int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
			if(insertCount <= 0) {
				//�ظ���ɱ
				throw new RepeatKillException("seckill is repeated");
			}else {
				//��ɱ�ɹ�
				SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
				return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS,successKilled);
			}
		} }catch (SeckillCloseException e1) {
			throw e1;
		}catch(RepeatKillException e2) {
			throw e2;
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
			//���б����쳣ת��Ϊ�������쳣
			throw new SeckillException("seckill inner error"+e.getMessage());
		}
		
	}

	@Override
	public String toString() {
		return "SeckillServiceImpl [logger=" + logger + ", seckillDao=" + seckillDao + ", successKilledDao="
				+ successKilledDao + ", slat=" + slat + "]";
	}
	
	
	

}
