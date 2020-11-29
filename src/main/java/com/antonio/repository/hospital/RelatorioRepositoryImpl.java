 package com.antonio.repository.hospital;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.antonio.model.Hospital;
import com.antonio.model.recurso.Pontos;

/**Classe que implementar as operações específicas do RelatorioRepositoryQuery
 * 
 * @author anton
 *
 */
@Service
public class RelatorioRepositoryImpl implements RelatorioRepositoryQuery{
	
	/**Atribuito responsável por acessar e realizar operações na base de dados
	 */
	@PersistenceContext
	private EntityManager manager;
	
	/**Método responsável por filtrar os hospitais com índice de ocupação acima de 90%
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação acima de 90%
	 */
	public List<Hospital> hospitaisComMaisDe90DeOcupacao() {
		TypedQuery<Hospital> consulta = manager.createQuery("SELECT h FROM Hospital h where h.ocupacao>90", Hospital.class);

		List<Hospital> hospitais = consulta.getResultList();
		return hospitais;
	}

	
	/**Método responsável por filtrar os hospitais com índice de ocupação abaixo de 90%
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação abaixo de 90%
	 */
	@Override
	public List<Hospital> hospitaisComMenosDe90DeOcupacao() {
		TypedQuery<Hospital> consulta = manager.createQuery("SELECT h FROM Hospital h where h.ocupacao<90", Hospital.class);

		List<Hospital> hospitais = consulta.getResultList();
		return hospitais;
	}

	/**Método responsável por calcular a média de recursos por hospital
	 * 
	 * @return List<Object>- Retorna uma lista com uma médio de recursos por hospital
	 */
	public List<Object> mediaDeRecursosPorHospital() {
		Query consulta = manager.createQuery("SELECT tipo, count(*) FROM Recurso group by tipo");

		List<Object> hospitais = consulta.getResultList();
		return hospitais;
	}
	
	/**Método responsável por filtrar os hospitais com índice de ocupação acima de 90% por ordem de tempo(os mais antigos para os mais recentes)
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação acima de 90% por mais tempo
	 */
	public List<Hospital> superLotacao(){
		TypedQuery<Hospital> consulta = manager.createQuery("SELECT h FROM Hospital h WHERE OCUPACAO>90 ORDER by ULTIMA_ATUALIZACAO", Hospital.class);

		List<Hospital> hospitais = consulta.getResultList();
		return hospitais;
	}

	/**Método responsável por filtrar os hospitais com índice de ocupação abaixo de 90% por ordem de tempo(os mais antigos para os mais recentes)
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação abaixo de 90% por mais tempo
	 */
	public List<Hospital> abaixoDaSuperLotacao() {
		TypedQuery<Hospital> consulta = manager.createQuery("SELECT h FROM Hospital h WHERE OCUPACAO<90 ORDER by ULTIMA_ATUALIZACAO", Hospital.class);

		List<Hospital> hospitais = consulta.getResultList();
		return hospitais;
	}
}
