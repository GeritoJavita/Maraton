/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dante
 */
public class Jugador {
    private String nombre;
    private int CC;
    private double puntuacion;
    private Nivel[] nivel;
    private Equipo equipo  ;    

    public Jugador(String nombre, int CC, Nivel[] nivel){
        this.CC=CC;
        this.nombre=nombre;
          this.puntuacion = calcularPromedioPruebas(nivel);
        this.nivel=nivel;
       
    }

    public String getNombre() {
        return nombre;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getCC() {
        return CC;
    }

      public double getPuntuacion() {
        double sum = 0;
        for (int i = 0; i < nivel.length; i++) {
            sum += nivel[i].getNivel();
        }
        return sum / nivel.length;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCC(int CC) {
        this.CC = CC;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
    public double calcularPromedioPruebas(Nivel[] pruebas) {
    double promedio = 0.0;
    for (int i = 0; i < pruebas.length; i++) {
        promedio += pruebas[i].getNivel();
    }
    promedio /= pruebas.length;
    return promedio;
}

    public Equipo getEquipo() {
        return equipo;
    }

    void setEquipo() {
       
    }
    

}
    
    

