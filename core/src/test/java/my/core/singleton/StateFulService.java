package my.core.singleton;

public class StateFulService {

    // Spring Bean 은 항상 무상태로 설계하자!!

    // 상태를 유지하는 필드
//    private int price;

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }

}
