/**
 * created by wanglong on 2018年3月24日 下午7:40:34
 */
package org.seckill.exception;

/**
 * 重复秒杀异常（运行期异常）
 * @author 12609
 *
 */
public class RepeatKillException extends SeckillException {

	/**
	 * @param message
	 * @param cause
	 */
	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RepeatKillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
