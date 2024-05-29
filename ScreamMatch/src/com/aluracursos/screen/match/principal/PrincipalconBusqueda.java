package com.aluracursos.screen.match.principal;

import com.aluracursos.screem.match.exception.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalconBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.println("Escriba el nombre de una pelicula: ");
            String buscar = URLEncoder.encode(teclado.nextLine(), "UTF-8");
            String titulo = "https://www.omdbapi.com/?t="+buscar+"&apikey=4c311a77";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(titulo))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(miTituloOmdb);

            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println(miTitulo);

            FileWriter datos = new FileWriter("Pelicula.txt");
            datos.write(miTitulo.toString());
            datos.close();

        } catch (NumberFormatException e){
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Error en la URI verifique la direccion. ");
        } catch (ErrorEnConversionDeDuracionException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Finalizo la ejecucion del programa!");
    }
}
