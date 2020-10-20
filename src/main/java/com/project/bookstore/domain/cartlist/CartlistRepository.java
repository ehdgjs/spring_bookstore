package com.project.bookstore.domain.cartlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartlistRepository extends JpaRepository<Cartlist, MultiId> {
}
