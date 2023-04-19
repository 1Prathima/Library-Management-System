package com.example.Library.Management.System.repository;

import com.example.Library.Management.System.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    public Author findByEmail(String email);
}
