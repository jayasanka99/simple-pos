package com.examplepractice.demo.repo;


import com.examplepractice.demo.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface ItemRepo  extends JpaRepository<Item, Integer> {

    Page<Item> findAllByActiveStateEquals(boolean activeStatus, Pageable pageable);

    int countAllByActiveStateEquals(boolean activeStatus);
}
