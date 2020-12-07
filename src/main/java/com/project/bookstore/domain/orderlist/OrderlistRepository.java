package com.project.bookstore.domain.orderlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

public interface OrderlistRepository extends JpaRepository<Orderlist, OrderlistMultiid> {

}
