package com.example.Library.Management.System.repository;

import com.example.Library.Management.System.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
