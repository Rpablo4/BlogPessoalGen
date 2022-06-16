package com.blogpessoal.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogpessoal.blogpessoal.model.UsuarioModel;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);
	
	public Optional<UsuarioModel>findByUsuario(@Param("usuario")String usuario);
}
