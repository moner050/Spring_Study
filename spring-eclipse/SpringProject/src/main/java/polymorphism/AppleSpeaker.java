package polymorphism;

public class AppleSpeaker implements Speaker{
	
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 생성");
	}
	
	public void volumeUp(){
		System.out.println("AppleSpeaker--- 소리 높히기");
	}
	public void volumeDown(){
		System.out.println("AppleSpeaker--- 소리 줄이기");
	}
	

}
