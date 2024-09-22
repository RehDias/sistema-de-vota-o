package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<Integer> pessoasCandidatas = new ArrayList<Integer>();
  private ArrayList<String> pessoasEleitoras = new ArrayList<String>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();


  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    Integer candidata = pessoasCandidatas.stream()
        .filter(num -> numero == num)
        .findAny()
        .orElse(null);

    if (candidata != null) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(numero);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    String eleitora = pessoasEleitoras.stream()
        .filter(cpf::equals)
        .findAny()
        .orElse(null);

    if (eleitora != null) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(cpf);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}
