package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorPessoa gerenciador = new GerenciadorPessoa();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Salvar uma pessoa");
            System.out.println("2. Listar todas as pessoas");
            System.out.println("3. Deletar uma pessoa pelo e-mail");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o e-mail: ");
                    String email = scanner.nextLine();
                    gerenciador.salvarPessoa(new Pessoa(nome, email));
                    break;
                case 2:
                    gerenciador.listarPessoas();
                    break;
                case 3:
                    System.out.print("Digite o e-mail da pessoa a ser deletada: ");
                    String emailDeletar = scanner.nextLine();
                    gerenciador.deletarPessoa(emailDeletar);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
