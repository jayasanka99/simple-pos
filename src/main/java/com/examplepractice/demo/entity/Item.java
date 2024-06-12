package com.examplepractice.demo.entity;

import com.examplepractice.demo.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id",length = 50)
    private int itemId;

    @Column(name = "item_name",length = 50,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 50,nullable = false)
    private MeasuringUnitType measureType;

    @Column(name = "total_qty")
    private int totalQty;

    @Column(name = "supplier_price")
    private double supplierPrice;

    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy="item")
    private List<OrderDetails> orderDetails;
}
