package br.com.zup.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
