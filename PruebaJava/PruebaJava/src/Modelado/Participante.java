/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelado;

/**
 *
 * @author Jairo
 */
public class Participante {
//Declaración de los atributos
    public String cedula;
    public String nombres;
    public String zona;
    public String provincia;
    public String canton;
    public String personalidad;
    public String razonamiento;
    public String dictamenIdoniedad;

    public Participante() { // Constructor Vacío
    }

    public Participante(String cedula, String nombres, String zona, String provincia, String canton, String personalidad, String razonamiento, String dictamenIdoniedad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.zona = zona;
        this.provincia = provincia;
        this.canton = canton;
        this.personalidad = personalidad;
        this.razonamiento = razonamiento;
        this.dictamenIdoniedad = dictamenIdoniedad;
    }

    // Getters & Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getRazonamiento() {
        return razonamiento;
    }

    public void setRazonamiento(String razonamiento) {
        this.razonamiento = razonamiento;
    }

    public String getDictamenIdoniedad() {
        return dictamenIdoniedad;
    }

    public void setDictamenIdoniedad(String dictamenIdoniedad) {
        this.dictamenIdoniedad = dictamenIdoniedad;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %s - %s - %s - %s\n", getCedula(), getNombres(), getZona(), getProvincia(), getCanton(), getPersonalidad(), getRazonamiento(), getDictamenIdoniedad());
    }
}
