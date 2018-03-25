/**
 * created by wanglong on 2018年3月24日 下午7:45:59
 */
package org.seckill.exception;


public class SeckillException extends RuntimeException {

	/**
	 * 秒杀相关异常
	 * @param message
	 * @param cause
	 */
	public SeckillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SeckillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
