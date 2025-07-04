package br.com.teste.screensound.repository;

import br.com.teste.screensound.model.Artista;
import br.com.teste.screensound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nome%")
    List<Musica> buscarMusicasPorArtista(String nome);
    // select m.* from artistas a join musicas m on m.artista_id = a.id where a.nome ilike '%roberto%'
}