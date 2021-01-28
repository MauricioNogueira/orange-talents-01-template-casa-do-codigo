package br.com.zup.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
