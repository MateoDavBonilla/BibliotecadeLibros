package com.challenge.literatura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obtenerDatos(String url) {

        // 1️⃣ Crear cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // 2️⃣ Construir la solicitud
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // 3️⃣ Enviar solicitud y recibir respuesta
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 4️⃣ Retornar el JSON recibido
        String json = response.body();
        return json;
    }
}
