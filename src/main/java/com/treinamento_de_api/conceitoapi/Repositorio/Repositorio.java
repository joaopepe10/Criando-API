package com.treinamento_de_api.conceitoapi.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento_de_api.conceitoapi.Modelo.Pessoa;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {

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

    @Query(value = "SELECT nome FROM pessoas where idade = 23", nativeQuery = true)
    String totalIdade();

    @Query(value = "SELECT nome as 'Idade maior que 23' FROM pessoas where idade >= 23", nativeQuery = true)
    List<String> teste();

    @Query(value = "SELECT * FROM pessoas where idade >= :idade", nativeQuery = true)
    List<Pessoa> idadeMaior(int idade);

}