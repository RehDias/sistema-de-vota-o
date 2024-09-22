package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa.
 */
public abstract class Pessoa {

  protected String nome;

  /**
   * Instantiates a new Pessoa.
   *
   * @param nome the nome
   */
  public Pessoa(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
