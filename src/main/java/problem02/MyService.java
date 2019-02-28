package problem02;

public class MyService extends BaseService {

	public String afternoon() {
		return "오후";
	}
	
	@Override
	public void service(String state) {
		// TODO Auto-generated method stub
		if(state.equals("낮")) {
			System.out.println(day() + "서비스시작");
		} else if(state.equals("밤")) {
			System.out.println(night() + "서비스시작");
		} else if(state.equals("오후")) {
			System.out.println(afternoon() + "서비스시작");
		}
	}
}
