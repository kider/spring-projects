package com.spring.boot.starter.example.service;

import com.spring.boot.starter.example.entity.Order;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@CacheConfig(cacheNames = "orders")
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.uid=:uid")
    List<Order> findByUserId(@Param("uid") Long uid);

}
