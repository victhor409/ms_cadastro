package com.example.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.dto.ContatoDTO;
import com.example.model.entities.Contatos;
import com.example.model.entities.repository.ContatosDao;

@Service
public class ContatosService {

	@Autowired
	private ContatosDao dao;
	
	
	
	public List<ContatoDTO> findAll(){
		
		List<Contatos> list = dao.findAll();
		return list.stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
	}
	
	public ContatoDTO salvarContato(ContatoDTO dto) {
		
		Contatos contato = new Contatos();
		
		contato.setId(dto.getId());
		contato.setDocumento(dto.getDocumento());
		contato.setEmail(dto.getEmail());
		contato.setNome(dto.getNome());
		contato.setTelefone(dto.getTelefone());
		
		contato = dao.save(contato);
		
		return new ContatoDTO(contato);
	}
	
	public Optional<ContatoDTO> findById(Long id){
		Optional<Contatos> findbyId = dao.findById(id);
		return findbyId.map(x -> new ContatoDTO(x));
	}
	
	public ContatoDTO updateContato(ContatoDTO dto) {
		Optional<ContatoDTO> contatoAntigo = findById(dto.getId());
		Contatos novoContato = new Contatos();
		
		try {
			if(contatoAntigo.isPresent()) {
				
				ContatoDTO contato = contatoAntigo.get();
				
				novoContato.setDocumento(contato.getDocumento());
				novoContato.setEmail(contato.getEmail());
				novoContato.setNome(contato.getNome());
				novoContato.setTelefone(contato.getTelefone());
				
				novoContato = dao.saveAndFlush(novoContato);
				
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return new ContatoDTO(novoContato);
	}
	
	public void delete(Long id) {
		Optional<Contatos> contato = dao.findById(id);
		
		if(contato.isPresent()) {
			dao.deleteById(contato.get().getId());
		}
	}
	
}
