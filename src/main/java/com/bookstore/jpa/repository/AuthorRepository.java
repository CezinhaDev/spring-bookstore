package com.bookstore.jpa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.jpa.models.AuthorModel;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
    
}
