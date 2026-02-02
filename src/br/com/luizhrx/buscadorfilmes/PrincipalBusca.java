package br.com.luizhrx.buscadorfilmes;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalBusca {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Titulo> filmes = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                if (opcao == 1) {
                    buscarFilme();
                } else if (opcao == 2) {
                    mostrarHistorico();
                } else if (opcao == 3) {
                    System.out.println("Você saiu.");
                    break;
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao processar a requisição.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("1 - Buscar filme");
        System.out.println("2 - Ver histórico");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void buscarFilme() throws Exception {
        System.out.print("Digite o nome do filme: ");
        String busca = scanner.nextLine();

        String endereco = "https://www.omdbapi.com/?t="
                + busca.replace(" ", "+")
                + "&apikey=684b618b";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Titulo titulo = gson.fromJson(response.body(), Titulo.class);

        if (titulo.Response().equalsIgnoreCase("False")) {
            System.out.println("Filme não encontrado. Tente novamente.");
        } else {
            filmes.add(titulo);
            exibirFilme(titulo);
        }
    }

    private static void exibirFilme(Titulo t) {
        System.out.println("------------------------------");
        System.out.println("Filme: " + t.nome());
        System.out.println("Ano: " + t.ano());
        System.out.println("Duração: " + t.duraco());
        System.out.println("Diretor: " + t.diretor());
        System.out.println("------------------------------\n");
    }

    private static void mostrarHistorico() {
        if (filmes.isEmpty()) {
            System.out.println("A lista está vazia.\n");
            return;
        }

        System.out.println("Histórico de filmes:");
        for (Titulo t : filmes) {
            System.out.printf("- %s (%s)\n", t.nome(), t.ano());
        }
        System.out.println();
    }
}
