package com.antonio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antonio.model.Hospital;
import com.antonio.repository.RelatorioRepository;

/**Classe responsável por garantir as regras de negócio e estabelecer uma interface para a classe RelatorioRepository  
 * 
 * @author anton
 *
 */
@Service
public class RelatorioService {
	
	/**
	 * Classe usada para acessa a base de dados do sistema
	 */
	@Autowired
	private RelatorioRepository relatorioRepository;
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação acima de 90%
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação acima de 90%
	 */
	public List<Hospital> hospitaisComMaisDe90DeOcupacao() {
		return relatorioRepository.hospitaisComMaisDe90DeOcupacao();
	}
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação abaixo de 90%
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação abaixo de 90%
	 */
	public List<Hospital> hospitaisComMenosDe90DeOcupacao(){
		return relatorioRepository.hospitaisComMenosDe90DeOcupacao();
	}

	/**Método responsável por emitir um relatório com a média de recursos por hospital
	 * 
	 * @return List<Object>- Retorna uma lista com uma médio de recursos por hospital
	 */
	public List<Object> mediaDeRecursosPorHospital() {
		return relatorioRepository.mediaDeRecursosPorHospital();
	}

	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação acima de 90% por ordem de tempo(os mais antigos para os mais recentes)
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação acima de 90% por mais tempo
	 */
	public List<Hospital> superLotacao() {
		return relatorioRepository.superLotacao();
	}
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação abaixo de 90% por ordem de tempo(os mais antigos para os mais recentes)
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação abaixo de 90% por mais tempo
	 */
	public List<Hospital> abaixoDaSuperLotacao() {
		return relatorioRepository.abaixoDaSuperLotacao();
	}
	

}
