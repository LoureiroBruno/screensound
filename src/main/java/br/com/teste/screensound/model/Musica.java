package br.com.teste.screensound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer duracaoSegundos;   // opcional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id")
    private Artista artista;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Integer getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(Integer duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}