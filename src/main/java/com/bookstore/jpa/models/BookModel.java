package com.bookstore.jpa.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @ManyToOne
    @JoinColumn(name = "publisher_id") // Nome da coluna que referencia a tabela Publisher, para criar a foreign key
    private PublisherModel publisher;

    @ManyToMany // Muitos livros podem ter muitos autores
    @JoinTable(name = "tb_book_author", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "book_id"), // Coluna que referencia o livro
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<AuthorModel> authors = new HashSet<>(); // Conjunto de autores do livro

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL) // 
    private ReviewModel review;

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

    public PublisherModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public Set<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorModel> authors) {
        this.authors = authors;
    }

    public ReviewModel getReview() {
        return review;
    }

    public void setReview(ReviewModel review) {
        this.review = review;
    }

}
