package polymorphism;

public class GoogleTV extends TV{
	
	public GoogleTV() {
		System.out.println("===> GoogleTV 생성");
	}
	
	public void powerOn(){
		System.out.println("GoogleTV--- 전원 키기");
	}
	public void powerOff(){
		System.out.println("GoogleTV--- 전원 끄기");
	}
	public void volumeUp(){
		System.out.println("GoogleTV--- 소리 높히기");
	}
	public void volumeDown(){
		System.out.println("GoogleTV--- 소리 줄이기");
	}
	
}
