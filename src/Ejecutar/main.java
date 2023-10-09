/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutar;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Maraton;
import Vista.InOut;

/**
 *
 * @author Dante
 */
public class main {
    public static void main(String[] args) {
        InOut ob = new InOut();
        Maraton maraton = new Maraton(); // Creamos un objeto Maraton
        ob.mostrar("INGRESA LAS PRUEBAS");
        maraton.crearPruebas();
        maraton.mostrarPruebas();
        maraton.crearEquipos();
        maraton.mostrarEquipos();
        int n = maraton.solicitarNumeroPositivo(ob.solicitar("Ingrese la cantidad de jugadores"));
         maraton.crearJugadores(n, maraton);
         maraton.mostrarJugadoresDisponibles();
         maraton.asignarJugadoresAEquipos();
         
     
 
       
String menu = "MENU\n";
menu += "1. Mostrar Pruebas\n";
menu += "2. Mostrar Equipos\n";
menu += "3. Mostrar Jugadores Disponibles\n";
menu += "4. Asignar Jugadores a Equipos\n";
menu += "5. Salir\n";

int opcion;
do {
    ob.mostrar(menu);
    opcion = maraton.solicitarNumeroPositivo(ob.solicitar("Ingrese la opcion"));

    switch(opcion) {
        case 1:
            maraton.mostrarPruebas();
            break;
        case 2:
            maraton.mostrarEquipos();
            break;
        case 3:
            maraton.mostrarJugadoresDisponibles();
            break;
        case 4:
            maraton.asignarJugadoresAEquipos();
            break;
        case 5:
            ob.mostrar("Saliendo del programa...");
            break;
        default:
            ob.mostrar("Opción inválida");
            break;
    }

    if (opcion != 5) { // Si no se eligió la opción "Salir"
       int respuesta = ob.solicitar("Ingrese 1 para regresear al menu, otro valor si desea salir");
        if (respuesta!=1) {
            opcion = 5; // Si la respuesta no es "s", se establece la opción "Salir" para salir del bucle
        }
    }
} while (opcion != 5);


     
        // Luego puedes hacer uso del array de jugadores creado
        // y continuar con la lógica de tu programa
    }
}



