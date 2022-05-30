package polymorphism;

public class SamsungTV extends TV{
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 생성");
	}
	
	public void powerOn(){
		System.out.println("SamsungTV--- 전원 키기");
	}
	public void powerOff(){
		System.out.println("SamsungTV--- 전원 끄기");
	}
	public void volumeUp(){
		System.out.println("SamsungTV--- 소리 높히기");
	}
	public void volumeDown(){
		System.out.println("SamsungTV--- 소리 줄이기");
	}
	
}
