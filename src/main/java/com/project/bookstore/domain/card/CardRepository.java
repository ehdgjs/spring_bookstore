package com.project.bookstore.domain.card;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, String> {
    List<Card> findAllByUsers_Id(String userid);
}
