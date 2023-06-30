package com.treinamento_de_api.conceitoapi.Repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento_de_api.conceitoapi.Modelo.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{

    //LISTA TODAS AS PESSOAS SALVAS
    @Override
    List<Pessoa> findAll();

    List<Pessoa> findByOrderByNome();
    List<Pessoa> findByOrderByCodigo();
    List<Pessoa> findByOrderByIdade();

    //FILTRA DE ACORDO COM O NUMERO DO CODIGO PASSADO
    Pessoa findByCodigo(int codigo);

    //FILTRA A BUSCA DE ACORDO COM UMA UNICA LETRA OU UM CONJUNTO DE CARACTER
    List<Pessoa> findByNomeContaining(String termo);

    //FILTRA DE ACORDO SE COMECA OU NAO COM DETERMINADO TERMO
    List<Pessoa> findByNomeStartsWith(String termoInicio);

    //FILTRA DE ACORDO SE TERMINA OU NAO COM DETERMINADO TERMO
    List<Pessoa> findByNomeEndsWith(String termoFinal);
}
