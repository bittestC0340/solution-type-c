package problem04;

import java.util.Map;

public class GugudanEntry implements Map.Entry<Integer, Integer>{

	private final int key;
	private int value;
	
	public GugudanEntry(int key, int value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}
	
	@Override
	public Integer getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public Integer setValue(Integer value) {
		// TODO Auto-generated method stub
		Integer old = this.value;
		this.value = value;
		return old;
	}

}
