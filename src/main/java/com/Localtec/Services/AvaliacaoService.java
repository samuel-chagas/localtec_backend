package com.Localtec.Services;

import java.util.List;

import com.Localtec.Entity.Avaliacao;

public interface AvaliacaoService {

	Avaliacao saveAvaliacao(Avaliacao avaliacao);
	
	List<Avaliacao> getAllAvaliacoes();
	
	Avaliacao getAvaliacaoById(Long id);
	
	Avaliacao updateAvaliacaoById(Long id, Avaliacao newAvaliacao);
	
	String deleteAvaliacaoById(Long id);

}
