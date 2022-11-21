package com.cautela.armamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cautela.armamento.models.Cautela;

@Repository
public interface CautelaRepository extends JpaRepository <Cautela, Long>{
    

}

/*
 * Repositoory => utiliza o JPA para utilizar as funcões de Crud
*/