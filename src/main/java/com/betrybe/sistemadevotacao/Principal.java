package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {
  private static boolean menu1 = true;
  private static boolean menu2 = false;
  private static boolean menu3 = false;
  private static boolean isTrue = true;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    menu();
  }

  /**
   * Menu.
   */
  public static void menu() {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciarVotacao = new GerenciamentoVotacao();

    while (isTrue) {
      menuPessoaCandidata(scanner, gerenciarVotacao);
    }

    scanner.close();
  }

  /**
   * Menu pessoa candidata.
   */
  public static void menuPessoaCandidata(Scanner scanner, GerenciamentoVotacao gerenciarVotacao) {
    String nomeCandidato;
    int numeroCandidato;

    while (menu1) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      String opcao = scanner.next();

      switch (opcao) {
        case "1":
          System.out.println("Entre com o nome da pessoa candidata:");
          nomeCandidato = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          numeroCandidato = scanner.nextInt();
          gerenciarVotacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
          break;
        case "2":
          menu2 = true;
          menu1 = false;
          menuPessoaEleitora(scanner, gerenciarVotacao);
          break;
        default:
          System.out.println("Escolha uma opção válida!");
          break;
      }
    }
  }

  /**
   * Menu pessoa eleitora.
   */
  public static void menuPessoaEleitora(Scanner scanner, GerenciamentoVotacao gerenciarVotacao) {
    String nomeEleitora;
    String cpf;

    while (menu2) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      String opcao = scanner.next();

      switch (opcao) {
        case "1":
          System.out.println("Entre com o nome da pessoa eleitora:");
          nomeEleitora = scanner.next();
          System.out.println("Entre com o cpf da pessoa eleitora:");
          cpf = scanner.next();
          gerenciarVotacao.cadastrarPessoaEleitora(nomeEleitora, cpf);
          break;
        case "2":
          menu3 = true;
          menu2 = false;
          menuVotacao(scanner, gerenciarVotacao);
          break;
        default:
          System.out.println("Escolha uma opção válida!");
      }
    }
  }

  /**
   * Menu votacao.
   */
  public static void menuVotacao(Scanner scanner, GerenciamentoVotacao gerenciarVotacao) {
    String cpfEleitora;
    int numeroCandidato;

    while (menu3) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      String opcao = scanner.next();

      switch (opcao) {
        case "1":
          System.out.println("Entre com o cpf da pessoa eleitora:");
          cpfEleitora = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          numeroCandidato = scanner.nextInt();
          gerenciarVotacao.votar(cpfEleitora, numeroCandidato);
          break;
        case "2":
          gerenciarVotacao.mostrarResultado();
          break;
        case "3":
          menu3 = false;
          isTrue = false;
          gerenciarVotacao.mostrarResultado();
          break;
        default:
          System.out.println("Escolha uma opção válida!");
          break;
      }
    }
  }
}
