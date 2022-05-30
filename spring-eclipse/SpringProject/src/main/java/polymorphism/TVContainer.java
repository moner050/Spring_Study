package polymorphism;

public class TVContainer {

	public static Object getBean(String id)
	{
		if(id.equals("lg")) return new LgTV();
		else if(id.equals("samsung")) return new SamsungTV();
		else if(id.equals("google")) return new GoogleTV();
		
		return null;
	}
	
}
