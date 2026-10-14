package com.gotico.diario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "poesias")
public class Poesia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String tipo; // "LIVRO", "POESIA" ou "MUSICA"

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    private String spotifyUrl;

    public Poesia() {}

    public Poesia(String titulo, String autor, String tipo, String conteudo, String spotifyUrl) {
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.conteudo = conteudo;
        this.spotifyUrl = spotifyUrl;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public String getSpotifyUrl() { return spotifyUrl; }
    public void setSpotifyUrl(String spotifyUrl) { this.spotifyUrl = spotifyUrl; }
}