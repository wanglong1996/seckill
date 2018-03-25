/**
 * created by wanglong on 2018��3��24�� ����9:10:45
 */
package org.seckill.enums;

/**
 * ʹ��ö�ٱ�����������
 * @author 12609
 *
 */
public enum SeckillStatEnum {
	
	SUCCESS(1,"��ɱ"),
	END(0,"��ɱ����"),
	REPEAT_KILL(-1,"c�ظ���ɱ"),
	INNER_ERROR(-2,"ϵͳ�쳣"),
	DATA_REWRITE(-3,"���ݴ۸�");
	
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
	//����state������������
	public static SeckillStatEnum stateOf(int index) {
		for(SeckillStatEnum state : values()) {
			if(state.getState() == index) {
				return state;
			}
		}
		return null;
	}
	

}
