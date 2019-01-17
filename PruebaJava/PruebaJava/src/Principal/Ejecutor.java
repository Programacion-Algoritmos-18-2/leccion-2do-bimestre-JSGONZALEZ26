/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import ManejoArchivos.ManejoArchivos;
import Modelado.Operaciones;
import Modelado.Participante;
import java.util.ArrayList; //Se realizan las importaciones necesarias

/**
 *
 * @author Jairo
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManejoArchivos lA = new ManejoArchivos(); //Creación de objetocs para la manipulación de archivos
        ManejoArchivos lA2 = new ManejoArchivos();
        ManejoArchivos lA3 = new ManejoArchivos();
        Operaciones op = new Operaciones(); //Creación de objeto para realizar operaciones
        ArrayList<Participante> lista; //Creación de ArrayList para el contenido de ambos archivos
        ArrayList<Participante> listaNombres; //ArrayList para la información ordenada alfabéticamente
        lA.abrirArchivo("data/data2.txt"); //Se procede a abrir los archivos 
        lA2.abrirArchivo("data/data1.csv");
        ArrayList<Participante> lista2 = lA.leerRegistros(); //Se agrega la información del archivo 1 a un nuevo ArrayList
        ArrayList<Participante> lista3 = lA2.leerRegistros2(); //Se agrega la información del segundo archivo
        lista = op.unirLista(lista2, lista3); //Se añade la información de ambos archivos al ArrayList previamente declarado
        op.ordenarPorCanton(); // Se ordena la información por cantón y se presenta en pantalla
        listaNombres = op.ordenarPorNombre(); //Se ordena la información por nombre
        op.calcular(); //Se calcular el número de participanetes según atributos específicos(características del participante)
        lA3.crearArchivo("data/data3.csv", listaNombres); //Se crea el nuevo archivo
        lA.cerrarArchivo();
        lA2.cerrarArchivo();
        lA3.cerrarArchivo();
    }

}
