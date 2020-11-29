package com.antonio.repository.hospital;

import java.util.List;

import com.antonio.model.Hospital;
/**Interface usada para realizar gerar relatóriso dos hospitais
 * 
 * @author anton
 *
 */
public interface RelatorioRepositoryQuery {
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação acima de 90%
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação acima de 90%
	 */
	public List<Hospital> hospitaisComMaisDe90DeOcupacao(); 
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação abaixo de 90%
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação abaixo de 90%
	 */
	public List<Hospital> hospitaisComMenosDe90DeOcupacao();
	
	/**Método responsável por emitir um relatório com a média de recursos por hospital
	 * 
	 * @return List<Object>- Retorna uma lista com uma médio de recursos por hospital
	 */
	public List<Object> mediaDeRecursosPorHospital();
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação acima de 90% por ordem de tempo(os mais antigos para os mais recentes)
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação acima de 90% por mais tempo
	 */
	public List<Hospital> superLotacao();
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação abaixo de 90% por ordem de tempo(os mais antigos para os mais recentes)
	 * 
	 * @return List<Hospital>- Retorna uma lista de hospitais com índice de ocupação abaixo de 90% por mais tempo
	 */
	public List<Hospital> abaixoDaSuperLotacao();
}
