package com.antonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonio.model.Hospital;

/**Interface usada para realizar operações na base de dados dos hospitais
 * 
 * @author anton
 *
 */
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
