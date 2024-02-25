package com.example.model.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.entities.Contatos;
import java.util.List;

@Repository
public interface ContatosDao extends JpaRepository<Contatos, Long>{

	
	
}
