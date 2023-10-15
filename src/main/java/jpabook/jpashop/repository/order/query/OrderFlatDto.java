package jpabook.jpashop.repository.order.query;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;
import jpabook.jpashop.domain.Address;
import java.time.LocalDateTime;

@Data
public class OrderFlatDto {
    private Long orderId; //주문번호
    private String name; //회원 이름
    private LocalDateTime orderDate; //주문 날짜
    private OrderStatus orderStatus; //주문 상태
    private Address address; //주문 배송지
    private String itemName; //상품명
    private int orderPrice; //주문 가격
    private int count; //주문 수량

    public OrderFlatDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address, String itemName, int orderPrice, int count) {
        this.orderId=orderId;
        this.name=name;
        this.orderDate=orderDate;
        this.orderStatus=orderStatus;
        this.address=address;
        this.itemName=itemName;
        this.orderPrice=orderPrice;
        this.count=count;
    }
}
