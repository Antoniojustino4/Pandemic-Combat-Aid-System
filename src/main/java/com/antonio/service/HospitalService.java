package com.antonio.service;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antonio.model.Hospital;
import com.antonio.repository.HospitalRepository;

/**
 * Classe responsável por garantir as regras de negócio e estabelecer uma
 * interface para a classe HospitalRepository
 * 
 * @author anton
 *
 */
@Service
public class HospitalService {

	/**
	 * Classe usada para acessa a base de dados do sistema
	 */
	@Autowired
	private HospitalRepository hospitalRepository;

	/**
	 * Método responsável por salva o objeto hospital
	 * 
	 * @param hospital Hospital- Objeto que será salvo na base de dados
	 * @return hospital Hospital- Objeto salvo
	 */
	public Hospital save(Hospital hospital) {
		setAtualizacao(hospital);
		return hospitalRepository.save(hospital);
	}

	/**
	 * Método responsável por procura na base de dados o Hospital com esse ID
	 * 
	 * @param id Long- ID do hospital que será procurado na base de dados
	 * @return Optional<Hospital>- Optional com objeto hospital encontrado, em caso
	 *         de não existe hospital com esse ID o optional será nulo
	 */
	public Optional<Hospital> findById(Long id) {
		return hospitalRepository.findById(id);
	}

	/**
	 * Método responsável por atualizar na base de dados o índice de ocupação do
	 * Hospital
	 * 
	 * @param ocupacao int- Novo percentual de ocupação do Hospital
	 * @param id       Long- ID do hospital que terá seus índice de ocupação
	 *                 atualizado, em caso de não existe hospital com esse ID o
	 *                 objeto será nulo
	 * @return
	 */
	public Hospital atualizarOcupacaoDoHospital(int ocupacao, Long id) {
		Optional<Hospital> optional = hospitalRepository.findById(id);
		if (optional.isPresent()) {
			Hospital hospital = optional.get();
			hospital.setIndiceOcupacao(ocupacao);
			save(hospital);
			return hospital;
		}
		return null;
	}

	/**
	 * Método que atribuirá o tempo que o hospital atingiu índice de ocupação
	 * superior a 90%
	 * 
	 * @param hospital Hospital-
	 */
	private void setAtualizacao(Hospital hospital) {
		if (hospital.getIndiceOcupacao() > 90) {
			hospital.setUltimaAtualizacao(Calendar.getInstance().getTime());			
		}
	}

}
