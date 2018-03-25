/**
 * created by wanglong on 2018年3月25日 下午12:52:10
 */
package org.seckill.dto;


public class SeckillResult<T> {
	private boolean isSuccess;
	
	private T data;
	
	private String error;

	/**
	 * @param isSuccess
	 * @param data
	 */
	public SeckillResult(boolean isSuccess, T data) {
		this.isSuccess = isSuccess;
		this.data = data;
	}

	/**
	 * @param isSuccess
	 * @param error
	 */
	public SeckillResult(boolean isSuccess, String error) {
		this.isSuccess = isSuccess;
		this.error = error;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "SeckillResult [isSuccess=" + isSuccess + ", data=" + data + ", error=" + error + "]";
	}
	
	
}
