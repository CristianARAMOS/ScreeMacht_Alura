import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screnmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screnmatch.calculos.FiltroRecomendacion;

import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);

        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.evalua(1.0);
        miPelicula.evalua(1.0);
        miPelicula.evalua(1.8);

        miPelicula.muestraFichaTecnica();
        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());


        System.out.println("***************************************");

        Serie drHouse = new Serie("Dr house" , 2004);
        drHouse.setTemporadas(8);
        drHouse.setMinutosPorEpisodio(45);
        drHouse.setEpisodiosPorTemporada(6);
        drHouse.muestraFichaTecnica();
        System.out.println(drHouse.getDuracionEnMinutos());
        System.out.println("Total de temporadas: " + drHouse.getTemporadas());


        Pelicula pelicula2 = new Pelicula("Rambo 4", 2014);



        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(drHouse);
        calculadora.incluye(pelicula2);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);


        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("Vida o Muerte");
        episodio.setSerie(drHouse);
        episodio.setTotalVisualizaciones(3500);
        filtroRecomendacion.filtra(episodio);

        var terceraPelicula = new Pelicula("Lords Of The Rings", 2001);
        terceraPelicula.setFechaDeLanzamiento(2001);
        terceraPelicula.setDuracionEnMinutos(198);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>(3);
        listaDePeliculas.add(terceraPelicula);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(pelicula2);

        System.out.println("Size of the list: " + listaDePeliculas.size());
        System.out.println("The first movie is: " + listaDePeliculas.get(0).getNombre());

        System.out.println(listaDePeliculas);

        System.out.println("web0s");

    }
}
