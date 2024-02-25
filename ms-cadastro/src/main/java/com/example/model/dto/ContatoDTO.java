package com.example.model.dto;

import java.io.Serializable;

import org.springframework.core.serializer.Serializer;

import com.example.model.entities.Contatos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String documento;
	private String telefone;
	
	
	public ContatoDTO(Contatos entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email =  entity.getEmail();
		this.documento = entity.getDocumento();
		this.telefone = entity.getTelefone();
	}
	 
}
