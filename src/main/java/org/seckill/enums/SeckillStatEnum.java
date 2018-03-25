/**
 * created by wanglong on 2018年3月24日 下午9:10:45
 */
package org.seckill.enums;

/**
 * 使用枚举表述常量数据
 * @author 12609
 *
 */
public enum SeckillStatEnum {
	
	SUCCESS(1,"秒杀"),
	END(0,"秒杀结束"),
	REPEAT_KILL(-1,"c重复秒杀"),
	INNER_ERROR(-2,"系统异常"),
	DATA_REWRITE(-3,"数据篡改");
	
	private int state;
	private String stateInfo;
	/**
	 * @param state
	 * @param stateInfo
	 */
	private SeckillStatEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	public int getState() {
		return state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	//根据state迭代所有类型
	public static SeckillStatEnum stateOf(int index) {
		for(SeckillStatEnum state : values()) {
			if(state.getState() == index) {
				return state;
			}
		}
		return null;
	}
	

}
