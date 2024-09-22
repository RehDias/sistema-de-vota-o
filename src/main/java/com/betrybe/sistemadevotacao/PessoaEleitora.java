package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa eleitora.
 */
public class PessoaEleitora extends Pessoa {

  private String cpf;

  /**
   * Instantiates a new Pessoa eleitora.
   *
   * @param nome the nome
   * @param cpf  the cpf
   */
  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
