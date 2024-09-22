package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata candidata = pessoasCandidatas.stream()
        .filter(num -> numero == num.getNumero())
        .findAny()
        .orElse(null);

    if (candidata != null) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pessoa = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoa);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    Optional<PessoaEleitora> eleitora = pessoasEleitoras.stream()
        .filter(p -> cpf.equals(p.getCpf()))
        .findAny();

    if (eleitora.isPresent()) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoa = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoa);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    String computados = cpfsComputados.stream()
        .filter(cpfPessoaEleitora::equals)
        .findAny()
        .orElse(null);

    if (computados != null) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      Optional<PessoaCandidata> candidato = pessoasCandidatas.stream()
          .filter(num -> num.getNumero() == numeroPessoaCandidata)
          .findAny();

      candidato.get().receberVoto();
      cpfsComputados.add(cpfPessoaEleitora);
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      pessoasCandidatas.forEach(pessoa -> System.out.println("Nome: " + pessoa.getNome()
          + " - " + pessoa.getVotos() + " ( " + pessoa.getVotos() / cpfsComputados.size()
          + "% )"));
      System.out.println("Total de votos: " + cpfsComputados.size());
    }
  }
}
