package br.com.luizhrx.buscadorfilmes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaFilmes {

    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public Titulo buscaFilme(String nomeFilme) throws IOException, InterruptedException {

        String endereco = "https://www.omdbapi.com/?t="+
                nomeFilme.replace(" ", "+") +
                "&apikey=684b618b";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        Titulo titulo = gson.fromJson(response.body(), Titulo.class);

        if (titulo.Response().equalsIgnoreCase("False")) {
            throw new RuntimeException("Filme não encontrado!");
        }

        return titulo;
    }
}
