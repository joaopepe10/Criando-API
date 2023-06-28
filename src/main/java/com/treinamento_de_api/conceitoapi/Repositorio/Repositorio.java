package com.treinamento_de_api.conceitoapi.Repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento_de_api.conceitoapi.Modelo.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{

    //LISTA TODAS AS PESSOAS SALVAS
    List<Pessoa> findAll();
    List<Pessoa> findByOrderByNome();
    List<Pessoa> findByOrderByCodigo();
    List<Pessoa> findByOrderByIdade();

    //FILTRA DE ACORDO COM O NUMERO DO CODIGO PASSADO
    Pessoa findByCodigo(int codigo);
}
