package my.core.order;

public interface OrderService {
    // 주문 서비스 (회원아이디, 물품이름, 물품가격)
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
