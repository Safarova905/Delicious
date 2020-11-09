//package ru.kpfu.itis.service;
//
//import ru.kpfu.itis.model.Order;
//import ru.kpfu.itis.model.Product;
//import ru.kpfu.itis.model.User;
//import ru.kpfu.itis.repository.OrderRepository;
//
//import java.util.List;
//
//public class OrderServiceImpl implements OrderService {
//
//    private OrderRepository orderRepository;
//
//    public OrderServiceImpl(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//
//    @Override
//    public Order getOrderById(Integer id) {
//        return orderRepository.findById(id);
//    }
//
//    @Override
//    public void createOrder(Order order) {
//        orderRepository.save(order);
//    }
//
//    @Override
//    public Order getUserOrder(User user) {
//        return orderRepository.getUserOrder(user);
//    }
//
//    @Override
//    public List<Product> getAllProductsInOrder(Order order) {
//        return orderRepository.findProducts(order);
//    }
//
//    @Override
//    public void addProductInOrder(Order order, Product product) {
//        orderRepository.addProduct(order, product);
//    }
//
//    @Override
//    public void deleteProductFromOrder(Order order, Product product) {
//        orderRepository.deleteProduct(order, product);
//    }
//}
