package br.com.teste.screensound.repository;

import br.com.teste.screensound.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}