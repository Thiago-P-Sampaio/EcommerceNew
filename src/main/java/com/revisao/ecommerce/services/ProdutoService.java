package com.revisao.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revisao.ecommerce.dto.CategoriaDTO;
import com.revisao.ecommerce.entities.Categoria;
import com.revisao.ecommerce.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.repositories.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;

	@Autowired
	CategoriaRepository catRepo;
	
	public List<ProdutoDTO> findAll(){
		List<Produto> lista = repo.findAll();
		
		return lista.stream().map(x -> new ProdutoDTO(x)).toList();
	}
	
	public Page<ProdutoDTO> findPagina(Pageable pagina){
		Page<Produto> busca = repo.findAll(pagina);
		return busca.map(x -> new ProdutoDTO(x));
	}

@Transactional
	public ProdutoDTO inset(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setPreco(dto.getPreco());
		entity.setImgUrl(dto.getImgUrl());

		for(CategoriaDTO cdto : dto.getCategorias()){
			Categoria categoria = catRepo.getReferenceById(cdto.getId());
			entity.getCategorias().add(categoria);
		}
		entity = repo.save(entity);
		return new ProdutoDTO(entity);
	}




}
