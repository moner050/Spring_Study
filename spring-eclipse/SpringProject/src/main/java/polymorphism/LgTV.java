package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	private Speaker speaker;

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
		speaker.volumeUp();
	}
	public void volumeDown(){
		speaker.volumeDown();
	}
	
}
