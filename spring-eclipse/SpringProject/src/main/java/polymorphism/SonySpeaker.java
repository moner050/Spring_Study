package polymorphism;

public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 생성");
	}
	
	public void volumeUp(){
		System.out.println("SonySpeaker--- 소리 높히기");
	}
	public void volumeDown(){
		System.out.println("SonySpeaker--- 소리 줄이기");
	}
	

}
