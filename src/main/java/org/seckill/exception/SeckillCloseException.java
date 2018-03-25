/**
 * created by wanglong on 2018年3月24日 下午7:44:12
 */
package org.seckill.exception;

/**
 * 秒杀关闭异常
 * @author 12609
 *
 */
public class SeckillCloseException extends SeckillException {

	/**
	 * @param message
	 * @param cause
	 */
	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SeckillCloseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
