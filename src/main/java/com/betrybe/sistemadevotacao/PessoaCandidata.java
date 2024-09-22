package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
