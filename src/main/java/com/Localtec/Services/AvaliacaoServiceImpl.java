package com.Localtec.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Localtec.Entity.Avaliacao;
import com.Localtec.Repository.AvaliacaoRepository;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService{

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Override
	public Avaliacao saveAvaliacao(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public List<Avaliacao> getAllAvaliacoes() {
		List<Avaliacao> allAvaliacoes = avaliacaoRepository.findAll();
		return allAvaliacoes;
	}

	@Override
	public Avaliacao getAvaliacaoById(Long id) {
		Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
		if(avaliacao.isPresent()) {
			return avaliacao.get();
		}
		return null;
	}

	@Override
	public Avaliacao updateAvaliacaoById(Long id, Avaliacao newAvaliacao) {
		Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
		
		if(avaliacao.isPresent()) {
			Avaliacao avaliacaoOriginal = avaliacao.get();
			
			
			
			return avaliacaoRepository.save(avaliacaoOriginal);
		}
		return null;
	}

	@Override
	public String deleteAvaliacaoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
