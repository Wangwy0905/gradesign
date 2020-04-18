package com.libei.service;

import com.libei.Dto.OrderDto;
import com.libei.Dto.OrderItemDetailDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.entity.OrderEntity;
import com.libei.entity.OrderItem;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
    List<OrderDto> query();

    Boolean delete(Long id);

    Boolean add(OrderAddRequest request);

    List<OrderItemDetailDto> queryFront(Long userId);

    List<OrderItemDetailDto> queryDetails();

    List<OrderDto> search(String orderId,String account);

    List<OrderItemDetailDto> searchDetail(String account);

    Boolean deleteItem(Long id);
}
