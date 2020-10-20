package com.project.bookstore.domain.orderlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderlistRepository extends JpaRepository<Orderlist, OrderlistMultiid> {
}
