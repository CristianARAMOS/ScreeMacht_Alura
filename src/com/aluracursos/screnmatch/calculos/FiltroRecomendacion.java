package com.aluracursos.screnmatch.calculos;

public class FiltroRecomendacion {
    public void filtra (Clasificacion  clasificacion){
        if (clasificacion.getClasificacion() >= 4){
            System.out.println("Muy bien evaluado en el momento!");
        } else if (clasificacion.getClasificacion() >= 2){
            System.out.println("popular en el momento");
        } else  {
            System.out.println("Coloacalo en tu lista de espera!");
        }
    }
}
