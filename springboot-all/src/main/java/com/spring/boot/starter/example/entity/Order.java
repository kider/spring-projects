package com.spring.boot.starter.example.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1234567L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Long uid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Order() {

    }

    public Order(Long uid,Integer amount){
        this.uid=uid;
        this.amount=amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order user = (Order) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ",amount='" + amount + '\'' +
                ",uid=" + uid +
                '}';
    }
}
