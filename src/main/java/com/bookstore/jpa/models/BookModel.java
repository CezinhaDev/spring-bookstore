package com.bookstore.jpa.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L; // Version control for serialization

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // uuid é um identificador único universal

    @Column(nullable = false, unique = true) // Define a coluna como não nula e única
    private String title;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
