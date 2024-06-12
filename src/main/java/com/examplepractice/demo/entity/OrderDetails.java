package com.examplepractice.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_details_id",length = 50)
    private int orderDetailsId;

    @Column(name = "item_name",length = 50)
    private String itemName;

    @Column(name = "amount",length = 50)
    private double amount;

    @Column(name = "qty",length = 50)
    private double qty;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;


}
