/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoArchivos;

import Modelado.Participante;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jairo
 */
public class ManejoArchivos {

    public Scanner entrada;

    public void abrirArchivo(String nombre) { //Lectura de archivos
        try {
            nombre = nombre;
            entrada = new Scanner(new File(nombre));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
    }

    public ArrayList<Participante> leerRegistros() {  // Se lee la información del archivo contenido
        ArrayList<Participante> lista = new ArrayList<>();
        try {
            entrada.nextLine();
            while (entrada.hasNext()) {  //Dada la información en formato Json, se procede a convertir la información en objetos
                Gson g = new Gson();
                String linea = entrada.nextLine();
                Participante p = g.fromJson(linea, Participante.class);
                lista.add(p); //Se añade la información al ArrayList
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
        return lista;
    }

    public ArrayList<Participante> leerRegistros2() {  //Se añade la información manualmente al ArrayList ya que el formato no es Json
        ArrayList<Participante> lista = new ArrayList<>();
        try {
            while (entrada.hasNext()) {
                Participante p = new Participante();
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<>(Arrays.asList(linea.split(","))); //Cada linea del archivo se vuelve un nuevo ArrayList que se sobreescribe cada vez que itera
                p.setCedula(linea_partes.get(0)); //Se agrega la información en base a índices para cada atributo
                p.setNombres(linea_partes.get(1));
                p.setZona(linea_partes.get(2));
                p.setProvincia(linea_partes.get(3));
                p.setCanton(linea_partes.get(4));
                p.setPersonalidad(linea_partes.get(5));
                p.setRazonamiento(linea_partes.get(6));
                p.setDictamenIdoniedad(linea_partes.get(7));
                lista.add(p);
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
        return lista;
    }

    public void crearArchivo(String nombre, ArrayList<Participante> lista) {
        try {
            String ruta = nombre;
            File file = new File(ruta);  //Se crea un nuevo archivo que contendrá la información ordenada
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < lista.size(); i++) {
                Participante p = lista.get(i); //Se crean nuevos objetos para cada elemento del arraylist
                //Variable auxiliar de tipo cadena que contendrá la información organizada
                String contenido = String.format("%s - %s - %s - %s - %s - %s - %s - %s\n", p.getCedula(), p.getNombres(), p.getZona(), p.getProvincia(), p.getCanton(), p.getPersonalidad(), p.getRazonamiento(), p.getDictamenIdoniedad());
                //La información de añade al nuevo archivo
                bw.write(contenido);
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//Se cierra el archivo
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
} // fin de la clase LeerArchivoTexto

