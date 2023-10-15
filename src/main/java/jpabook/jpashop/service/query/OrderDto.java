package jpabook.jpashop.service.query;

import jpabook.jpashop.api.OrderApiController;
import jpabook.jpashop.domain.Order;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto{
    private Long orderId;
    private String name;
    private String orderDate;
    private String orderStatus;
    private String address;
    private List<OrderItemDto> orderItems;
    public OrderDto(Order order) {
        orderId = order.getId();
        name = order.getMember().getName();
        orderDate = order.getOrderDate().toString();
        orderStatus = order.getStatus().toString();
        address = order.getDelivery().getAddress().toString();
        orderItems = order.getOrderItems().stream().map(OrderItemDto::new).collect(Collectors.toList());

    }
}