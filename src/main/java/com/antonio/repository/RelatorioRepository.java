package com.antonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonio.model.Hospital;
import com.antonio.repository.hospital.RelatorioRepositoryQuery;
/**Interface usada para realizar operações na base de dados dos hospitais
 * 
 * @author anton
 *
 */
public interface RelatorioRepository extends JpaRepository<Hospital, Long>, RelatorioRepositoryQuery{

}
