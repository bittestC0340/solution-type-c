package problem03;

public class MyStack {
	
	private String[] buffer;
	private int current;

	public MyStack( int size ) {
		this.buffer = new String[size];
		this.current = 0;
	}
	
	public void push(String item) {
		if(buffer.length == current) {
			resizing();
		}
		this.buffer[current++] = item;
	}

	public String pop() {
		if(current == 0) return null;
		return this.buffer[--current];
	}

	public boolean isEmpty() {
		return current == 0;
	}
	
	public int size() {
		return current;
	}
	
	private void resizing() {
		String[] temp = this.buffer;
		this.buffer = new String[temp.length * 2];
		for(int i = 0; i < temp.length; i++) {
			buffer[i] = temp[i];
		}
	}
}