package br.com.luizhrx.buscadorfilmes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalBusca {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Titulo> filmes = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {

        ConsultaFilmes consulta = new ConsultaFilmes();

        while (true) {
            exibirMenu();

            int opcao;

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números!\n");
                continue;
            }

            switch (opcao) {

                case 1:
                    System.out.print("Digite o nome do filme: ");
                    String busca = scanner.nextLine().trim();

                    if (busca.isEmpty()) {
                        System.out.println("Nome inválido!\n");
                        break;
                    }

                    try {
                        Titulo filme = consulta.buscaFilme(busca);
                        filmes.add(filme);
                        exibirFilme(filme);

                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:
                    exibirHistorico();
                    break;

                case 3:
                    System.out.println("Você saiu.");
                    return;

                default:
                    System.out.println("Opção inválida!\n");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("1 - Buscar filme");
        System.out.println("2 - Ver histórico");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirFilme(Titulo t) {
        System.out.println("------------------------------");
        System.out.println("Filme: " + t.nome());
        System.out.println("Ano: " + t.ano());
        System.out.println("Duração: " + t.duraco());
        System.out.println("Diretor: " + t.diretor());
        System.out.println("------------------------------\n");
    }

    private static void  exibirHistorico() {
        if (PrincipalBusca.filmes.isEmpty()) {
            System.out.println("Lista vazia!\n");
            return;
        }
        System.out.println("\nHistórico de filmes:");

        for (Titulo t : PrincipalBusca.filmes) {
            System.out.printf("- %s (%s)\n", t.nome(), t.ano());
        }

        System.out.println();
    }
}




