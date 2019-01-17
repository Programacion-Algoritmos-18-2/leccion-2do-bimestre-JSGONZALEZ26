/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelado;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jairo
 */
public class Operaciones {

    ArrayList<Participante> informacion = new ArrayList<>();  // Declaración de ArrayList global para usarla en todos los procesos

    public ArrayList<Participante> unirLista(ArrayList<Participante> lista2, ArrayList<Participante> lista3) { //Se recibe como parámetros las listas sin unir
        ArrayList<Participante> lista = new ArrayList<>(); // Se crea un ArrayList auxiliar
        lista.addAll(lista2);  //Se agrega la información de la primera lista al auxiliar
        lista.addAll(lista3); //Se agrega la información al auxiliar
        informacion = lista; //Información recibe los valores del ArrayList Auxiliar
        return informacion; //Se devuelve el ArrayList información a la Clase Principal
    }

    public void ordenarPorCanton() {  //Proceso para ordenar según el atributo cantón
        ArrayList<Participante> dataPorCantones = new ArrayList<>(); //Lista que contendrá los valores ya ordenados
        dataPorCantones.addAll(informacion); //Se agrega la información del ArrayList a la nueva lista
        Collections.sort(dataPorCantones,  //Se procede a ordenar por cantones
                (o1, o2) -> o1.canton.compareTo(o2.canton));
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.println(dataPorCantones.get(i));  //Se presenta en pantalla la información ordenada
        }
    }

    public ArrayList<Participante> ordenarPorNombre() { // Proceso similar al anterio solo que ahora se ordena por nombres
        ArrayList<Participante> dataPorNombres = new ArrayList<>();
        dataPorNombres.addAll(informacion);
        Collections.sort(dataPorNombres,
                (o1, o2) -> o1.getNombres().compareTo(o2.getNombres()));        
        return dataPorNombres; // Se devuelve la información a la Clase Principal
    }

    public void calcular() { // Se calcula cuantos tienen dichas características según su atributo, se presenta en pantalla
        int adecuado = 0;
        int porConvocar = 0;
        int idoneo = 0;
        int noIdoneo = 0;
        for (int i = 0; i < informacion.size(); i++) {
            Participante p = informacion.get(i);
            if (p.getPersonalidad().equals("ADECUADO")) {
                adecuado++;
            } else {
                porConvocar++;
            }
        }
        for (int i = 0; i < informacion.size(); i++) {
            Participante p = informacion.get(i);
            if (p.getDictamenIdoniedad().equals("IDONEO")) {
                idoneo++;
            } else {
                noIdoneo++;
            }
        }
        System.out.printf("Número de participantes catalogados como 'Adecuados': %d\nNúmero de participantes catalogados como 'Por Convocar': %d\n", adecuado, porConvocar);
        System.out.printf("Número de participantes catalogados como 'Idoneos': %d\nNúmero de participantes catalogados como 'No Idoneos': %d\n", idoneo, noIdoneo);
    }
}
