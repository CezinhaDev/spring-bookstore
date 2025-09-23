package com.bookstore.jpa.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_AUTHOR")
public class AuthorModel implements Serializable {
    private static final long serialVersionUID = 1L; // Usado para versionar a classe durante a serialização

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // uuid é um identificador único universal

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Ignora na serialização (GET), mas permite na desserialização (POST/PUT)
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY) // Nome do atributo na classe BookModel que referencia AuthorModel
    private Set<BookModel> books = new HashSet<>(); // Conjunto de livros do autor

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false, unique = true) // Define a coluna como não nula e única
    private String name; // Nome do autor

    public Set<BookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<BookModel> books) {
        this.books = books;
    }

    

}
