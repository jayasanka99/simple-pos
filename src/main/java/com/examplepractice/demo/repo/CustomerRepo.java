package com.examplepractice.demo.repo;


import com.examplepractice.demo.entity.Customer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface CustomerRepo  extends CrudRepository<Customer,Integer> {

    List <Customer> findAllByActiveStateEquals(boolean activeState);

    Customer getById(int customerId);
}
