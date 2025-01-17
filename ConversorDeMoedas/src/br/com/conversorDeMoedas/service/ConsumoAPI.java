package br.com.conversorDeMoedas.service;

import br.com.conversorDeMoedas.utils.Moeda;
import br.com.conversorDeMoedas.utils.MoedaOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    private String apikey = "37776babb0874e428473d249";
    private String url = "https://v6.exchangerate-api.com/v6/"+ apikey + "/pair/";

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .setPrettyPrinting()
            .create();

    public String obterDados(String moedaBase, String moedaAlvo, double valor) {
        String urlfinal = url + moedaBase + "/" + moedaAlvo + "/" + valor;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlfinal))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();

        MoedaOmdb minhaMoedaOmdb = gson.fromJson(json, MoedaOmdb.class);
        Moeda minhaMoeda = new Moeda(minhaMoedaOmdb);
        minhaMoeda.setValor(valor);
        minhaMoeda.ExibeMoeda();
        return json;
    }
}
