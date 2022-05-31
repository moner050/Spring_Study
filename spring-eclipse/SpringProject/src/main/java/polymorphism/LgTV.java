package polymorphism;

import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("===> LgTV 생성");
	}
	
	public void powerOn(){
		System.out.println("LgTV--- 전원 키기");
	}
	public void powerOff(){
		System.out.println("LgTV--- 전원 끄기");
	}
	public void volumeUp(){
		System.out.println("LgTV--- 소리 높히기");
	}
	public void volumeDown(){
		System.out.println("LgTV--- 소리 줄이기");
	}
	
}
