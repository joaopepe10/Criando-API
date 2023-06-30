package com.treinamento_de_api.conceitoapi.Controle;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento_de_api.conceitoapi.Modelo.Pessoa;
import com.treinamento_de_api.conceitoapi.Repositorio.Repositorio;

@RestController
public class Controle {
    //ATRIBUTOS
    @Autowired
    private Repositorio acao;

    //METODOS

    //CADASTRO DE PESSOAS ATRAVES DA REFERENCIA CRIADA PELO REPOSITORIO DE PESSOAS
    @PostMapping("/cadastrar")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa p){
        return acao.save(p);
    }

    //METODO PARA LISTAR TODA A TABELA
    @GetMapping("/listar")
    public List<Pessoa> listarPessoa(){
        return acao.findAll();
    }
    //NA URL O CODIGO E USADO COMO PARAMETRO, ANOTTATION PATH VARIABLE FAZ MANIPULACAO E FILTRA DE ACORDO COM O CODIGO PASSADO
    @GetMapping("/listar/{codigo}")
    public Pessoa listarPorCodigo(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }

    //METODO PARA ALTERAR UM DETERMINADO OBJETO, PASSA COMO ARGUMENTO TODO O OBJETO
    @PutMapping("/alterar")
    public Pessoa editarPessoa(@RequestBody Pessoa p){
        return acao.save(p);
    }

    //METODO PARA DELETAR UM OBJETO DA TABELA POR ID
    @DeleteMapping("/deletar/{codigo}")
    public String deletarPessoa(@PathVariable int codigo){
        acao.deleteById(codigo);
        String informacao = "Coluna cujo codigo e o %d, deletada com sucesso!";
        return String.format(informacao, codigo);
    }
    @GetMapping("/qtd")
    public long contador(){
        return acao.count();
    }


    //ORDENACAO DE ACORDO COM ATRIBUTO/VARIAVEL
    @GetMapping("/ordernar-nome")
    public List<Pessoa> ordernarNome(){
        return acao.findByOrderByNome();
    }

    @GetMapping("/ordernar-codigo")
    public List<Pessoa> ordernarCodigo(){
        return acao.findByOrderByCodigo();
    }

    @GetMapping("/ordernar-idade")
    public List<Pessoa> ordernarIdade(){
        return acao.findByOrderByIdade();
    }
    @GetMapping("/formato")
    public String formatacao(){
        String inf = "";
        List<Pessoa> pessoas = acao.findAll();
        for (Pessoa p : pessoas) {
            inf += "\nNome: " + p.getNome() + " Idade: " + p.getIdade();
        }
        return inf;
    }
    //FAZ A VERIFICACAO SE CONTEM DETERMINADO CARACTER OU CONJUNTO DE CARACTER
    @GetMapping("/contem/{termo}")
    public List<Pessoa> nomeContem(@PathVariable String termo){
        return acao.findByNomeContaining(termo);
    }

    @GetMapping("/termoInicio/{inicio}")
    public List<Pessoa> nomeInicio(@PathVariable String inicio){
        return acao.findByNomeStartsWith(inicio);
    }
    @GetMapping("/termoFim/{fim}")
    public List<Pessoa> nomeFim(@PathVariable String fim){
        return acao.findByNomeEndsWith(fim);
    }

    //CRIA UMA ROTA VAZIA
    @GetMapping("")
    public String msg(){
        return "Hello World!";
    }
    //CRIA UMA ROTA localhost:8080/boasVindas
    @GetMapping("/boasVindas") 
    public String boasVindas(){
        return "Seja Bem Vindo(a) ";
    }
    //CRIA UMA ROTA QUE MANIPULA A STRING APOS A BARRA: localhost:8080/boasVindas/string
    @GetMapping("/boasVindas/{nome}") 
    public String boasVindas(@PathVariable String nome){
        return "Seja Bem Vindo(a) " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa listarPessoa(@RequestBody Pessoa p){
        return p;
    }
}
