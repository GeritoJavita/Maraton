/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Equipo {
    private String nombre;
    private int maximoJugadores;
    private Jugador[] jugadores;


    public Equipo(String nombre, int maximoJugadores) {
        this.nombre=nombre;
        this.maximoJugadores=maximoJugadores;
          this.jugadores = new Jugador[maximoJugadores];
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaximoJugadores() {
        return  maximoJugadores;
    }


    public Jugador[] getJugadores() {
        return jugadores;
    }

    public boolean agregarJugador(Jugador jugador) {
    for (int i = 0; i < maximoJugadores; i++) {
        if (jugadores[i] == null) {
            jugadores[i] = jugador;
            jugador.setEquipo();
            return true;
        }
    }
    return false;
}public boolean jugadorAsignado(Jugador jugador) {
    for (int i = 0; i < maximoJugadores; i++) {
        if (jugadores[i] != null && jugadores[i].equals(jugador)) {
            return true;
        }
    }
    return false;
}
}

