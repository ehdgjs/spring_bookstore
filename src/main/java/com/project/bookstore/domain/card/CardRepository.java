package com.project.bookstore.domain.card;

import com.project.bookstore.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, String> {
    List<Card> findAllByUsers_Id(String userid);
}
