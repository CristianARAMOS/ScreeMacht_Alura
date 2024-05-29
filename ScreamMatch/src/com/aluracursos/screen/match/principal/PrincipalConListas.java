package com.aluracursos.screen.match.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(10);
        var terceraPelicula = new Pelicula("Lords Of The Rings", 2001);
        terceraPelicula.evalua(8);
        Pelicula pelicula2 = new Pelicula("Rambo 4", 2014);
        pelicula2.evalua(9);
        Serie drHouse = new Serie("Dr house" , 2004);
        drHouse.evalua(9);
        
        ArrayList<Titulo> lista = new ArrayList<>(3);
        lista.add(terceraPelicula);
        lista.add(miPelicula);
        lista.add(pelicula2);
        lista.add(drHouse);

        for (Titulo item: lista){
            System.out.println(item);
            if ( item instanceof Pelicula pelicula && pelicula.getClasificacion() >9){

                System.out.println(pelicula.getClasificacion());
            }
        }


        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Brumo Mars");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Junior H");
        System.out.println(listaDeArtistas);
        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada: " + listaDeArtistas);
        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: " + lista);
    }
}
