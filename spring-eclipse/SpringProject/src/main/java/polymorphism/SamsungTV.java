package polymorphism;

public class SamsungTV implements TV{
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 생성");
	}
	
	public void 맴버변수초기화() {
		System.out.println("---> 맴버변수초기화");
		price = 1700000;
	}
	
	public void 자원해제(){
		System.out.println("---> 자원해제");
		price = 0;
	}
	
	public void powerOn(){
		System.out.println("SamsungTV--- 전원 키기 " + price);
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
