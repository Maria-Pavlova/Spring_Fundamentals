package com.example.coffeeshop.service;

import com.example.coffeeshop.models.dto.bindingModels.AddOrderModel;
import com.example.coffeeshop.models.dto.viewModels.OrderViewModel;
import com.example.coffeeshop.models.entity.Order;
import com.example.coffeeshop.models.security.CurrentUser;
import com.example.coffeeshop.repository.CategoryRepository;
import com.example.coffeeshop.repository.OrderRepository;
import com.example.coffeeshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final CategoryRepository categoryRepository;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper,
                        UserRepository userRepository, CurrentUser currentUser,
                        CategoryRepository categoryRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.categoryRepository = categoryRepository;
    }

    public void addOrder(AddOrderModel orderModel) {

        Order order = modelMapper.map(orderModel, Order.class);

        order.setEmployee(userRepository.findByUsername(currentUser.getUsername()).get());
        order.setCategory(categoryRepository.findByName(orderModel.getCategory()));

        orderRepository.save(order);
    }

    public List<OrderViewModel> findAllByPriceDesc() {
      return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .toList();
    }

    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
