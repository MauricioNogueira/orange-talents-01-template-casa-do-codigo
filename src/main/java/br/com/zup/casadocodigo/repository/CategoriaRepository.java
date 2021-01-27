package br.com.zup.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}