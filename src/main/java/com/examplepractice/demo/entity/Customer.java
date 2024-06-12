package com.examplepractice.demo.entity;

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

@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id",length = 50)
    private int customerId;

    @Column(name = "customer_name",length = 30)
    private String customerName;

    @Column(name = "customer_address",length = 50,nullable = false)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

//    @Column(name = "contact_numbers",length = 50,nullable = false)
//    private int contactNumbers;

    @Column(name = "customer_nic" )
    private String customerNic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy="customer")
    private List<Order> orders;

}
