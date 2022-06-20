package polymorphism;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {

	public static void main(String[] args) {
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		
		List<String> addressList = bean.getAddressList();
		
		for(String address : addressList) {
			System.out.println("---> " + address.toString());
		}
		
		container.close();
	}
	
	
}