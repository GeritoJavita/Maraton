/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Modelo.Equipo;
import Modelo.Nivel;
import Modelo.Jugador;
import Vista.InOut;

/**
 *
 * @author Dante
 */
public class Maraton {
    
    private int numEquipos;
   private  Nivel[] pruebas ;
   private Equipo [] equipos;
   private Jugador[] jugadores;
   private InOut ob;

    public Maraton() {
        
        this.ob = new InOut();
        this.pruebas = new Nivel[3];
        this.numEquipos = 2;
        this.equipos = new Equipo[2];
        this.jugadores = new Jugador[0];
    }
    
    
    
public void crearPruebas() {
    for (int i = 0; i < pruebas.length; i++) {
        String descripcion = ob.solicitarN("Ingrese la descripción de la prueba #" + (i+1));
        int nivel = solicitarNivel(ob.solicitar("Ingrese el nivel de la prueba #" + (i+1)));
        int maxDificultad = 0;
        int minDificultad = 0;
        if (i == 0) {
            maxDificultad = 5;
        } else if (i == 1) {
            maxDificultad = 8;
            minDificultad = 5;
        } else if (i == 2) {
            maxDificultad = 10;
            minDificultad = 8;
        }
        while (nivel < minDificultad || nivel > maxDificultad) {
            ob.mostrar("La dificultad de la prueba #" + (i+1) + " debe estar entre " + minDificultad + " y " + maxDificultad);
            nivel = solicitarNivel(ob.solicitar("Ingrese nuevamente el nivel de la prueba #" + (i+1)));
        }
        String area = ob.solicitarN("Ingrese el área de la prueba #" + (i+1));
        Nivel prueba = new Nivel(descripcion, nivel, area);
        pruebas[i] = prueba;
    }
}

    public void mostrarPruebas ()
    {
     String s ="Las pruebas se muestran a continuacion: \n";
        for(int i=0;i<pruebas.length;i++){
            s+= "\nPrueba #" +(i+1)+" :";
            s+="\nDescripcion: " +pruebas[i].getDescripcion()+"\n";
            s+="\nNivel de la prueba: "+pruebas[i].getNivel()+"\n";
            s+="\nArea en que se apuntara: "+pruebas[i].getArea()+"\n";
            
        }
        ob.mostrar(s);
    }    
    public void crearEquipos() {
        for (int i = 0; i < numEquipos; i++) {
            String nombreEquipo = ob.solicitarN("Ingrese el nombre del equipo #" + (i + 1) + ":");
            int maximoJugadores = solicitarNumeroPositivo(ob.solicitar("Ingrese la cantidad maxima de jugadores que puede tener el equipo:"));
            while (maximoJugadores > 5) {
                ob.mostrar("Recuerde que un equipo es conformado por maximo 5 participantes");
                maximoJugadores = solicitarNumeroPositivo(ob.solicitar("Ingrese la cantidad maxima de jugadores que puede tener el equipo:"));
            } 
            Equipo equipo = new Equipo(nombreEquipo, maximoJugadores);
            equipos[i] = equipo;
        }
    }





public void mostrarEquipos() {
    String s = "Los equipos registrados son: \n";
    for(int i = 0; i < numEquipos; i++) {
        s += "\nEquipo #" + (i + 1) + " :";
        s += "\nNombre: " + equipos[i].getNombre() + "\n";
        s += "\nCantidad maxima de jugadores: " + equipos[i].getMaximoJugadores()+ "\n";
      
    }
    ob.mostrar(s);
}


public void crearJugadores(int n, Maraton maraton) {
double promedio;
    jugadores = new Jugador[n];

    for (int i = 0; i < n; i++) {
        Nivel prueba;
        String nombre = ob.solicitarN("Ingrese el nombre del jugador #" + (i + 1));
        int cc = solicitarNumeroPositivo(ob.solicitar("Ingrese su Identificacion"));
        maraton.mostrarPruebas();
        int numPruebas = maraton.pruebas.length;
        Nivel[] pruebas = new Nivel[numPruebas];

        for (int j = 0; j < numPruebas; j++) {
            int nivel = solicitarNivel(ob.solicitar("Ingrese su promedio en la prueba #" + (j + 1)));
            while (nivel < 0 || nivel > maraton.pruebas[j].getNivel()) {
                ob.mostrar("El promedio debe estar entre 0 y " + maraton.pruebas[j].getNivel());
                nivel = solicitarNivel(ob.solicitar("Ingrese nuevamente su promedio en la prueba #" + (j + 1)));
            }
/*if (j == 0 && nivel < 3) {
    ob.mostrar("Lo siento, el jugador " + nombre + " no puede continuar en las demás pruebas debido a que su promedio en la prueba 1 es menor a 3.");
    for (int k = j + 1; k < numPruebas; k++) {
prueba = new Nivel(maraton.pruebas[k].getDescripcion(), 0, maraton.pruebas[k].getArea());
         pruebas[k] = prueba;
    }
    Jugador jugador = new Jugador(nombre, cc, pruebas);
    
     promedio = jugador.calcularPromedioPruebas(pruebas);

        jugador.setPuntuacion(promedio);
        
        jugadores[i] = jugador;
    break;
} else if (j == 1 && nivel < 6) {
    ob.mostrar("Lo siento, el jugador " + nombre + " no puede avanzar a la prueba 3 debido a que su promedio en la prueba 2 es menor a 6.");
    for (int k = j + 1; k < numPruebas; k++) {
       
        prueba = new Nivel(maraton.pruebas[k].getDescripcion(), 0, maraton.pruebas[k].getArea());
        pruebas[k]= prueba;
    }
    Jugador jugador = new Jugador(nombre, cc, pruebas);
    
       promedio = jugador.calcularPromedioPruebas(pruebas);

        jugador.setPuntuacion(promedio);
        
        jugadores[i] = jugador;
    break;
}*/
            prueba = new Nivel(maraton.pruebas[j].getDescripcion(), nivel, maraton.pruebas[j].getArea());
            pruebas[j] = prueba;
        }

        Jugador jugador = new Jugador(nombre, cc, pruebas);
       promedio = jugador.calcularPromedioPruebas(pruebas);

        jugador.setPuntuacion(promedio);
        
        jugadores[i] = jugador;
    }

        String a= "Jugadores ha participar son:\n";

    for (int i = 0; i < n; i++) {
    a += "\n" + (i + 1) + ". " + jugadores[i].getNombre() + " (" + jugadores[i].getCC() + ")";
    a += "\nSu promedio es: " + jugadores[i].getPuntuacion();
        
    }  
    ob.mostrar(a);
}
public void mostrarJugadoresDisponibles() {
    String jugadoresDisponibles = "Jugadores disponibles:\n";
    int numJugadoresDisponibles = 0;
    for (int i = 0; i < jugadores.length; i++) {
        if (jugadores[i] != null && jugadores[i].getEquipo() == null) {
            numJugadoresDisponibles++;
            jugadoresDisponibles += numJugadoresDisponibles + ". " + jugadores[i].getNombre() + "\n CC: (" + jugadores[i].getCC() + ")\n";
        }
    }

}
public void asignarJugadoresAEquipos() {
    int[] indicesJugadores = new int[jugadores.length];
    for (int i = 0; i < jugadores.length; i++) {
        indicesJugadores[i] = i;
    }

    // Mezclar aleatoriamente los índices de los jugadores
    for (int i = 0; i < jugadores.length; i++) {
        int j = (int) (Math.random() * jugadores.length);
        int temp = indicesJugadores[i];
        indicesJugadores[i] = indicesJugadores[j];
        indicesJugadores[j] = temp;
    }

    // Asignar los jugadores a los equipos
    for (int i = 0; i < jugadores.length; i++) {
        int indiceEquipo = indicesJugadores[i] % equipos.length;
        equipos[indiceEquipo].agregarJugador(jugadores[indicesJugadores[i]]);
        jugadores[indicesJugadores[i]].setEquipo(equipos[indiceEquipo]);
        ob.mostrar("El jugador " + jugadores[indicesJugadores[i]].getNombre() + " ha sido asignado al equipo #" + (indiceEquipo + 1) + ".");
    }

    // Mostrar los equipos con sus jugadores
    String a = "Los equipos y sus jugadores son:\n";
    for (int i = 0; i < equipos.length; i++) {
        a += "Equipo #" + (i + 1) + ": " + equipos[i].getNombre() + "\n";
        a += "Jugadores:";
        Jugador[] jugadoresEquipo = equipos[i].getJugadores();
        if (jugadoresEquipo != null) {
            for (int j = 0; j < jugadoresEquipo.length; j++) {
                if (jugadoresEquipo[j] != null) {
                    a += " " + jugadoresEquipo[j].getNombre();
                    a+= " "+jugadoresEquipo[j].getPuntuacion();
                }
            }
        }
        a += "\n\n";
    }
    ob.mostrar(a);
 Equipo equipoMasFuerte = null;
double promedioMasAlto = 0.0;
for (int i = 0; i < equipos.length; i++) {
    double promedio = 0.0;
    Jugador[] jugadoresEquipo = equipos[i].getJugadores();
    if (jugadoresEquipo != null) {
        for (int j = 0; j < jugadoresEquipo.length; j++) {
            if (jugadoresEquipo[j] != null) {
                promedio += jugadoresEquipo[j].getPuntuacion();
            }
        }
        promedio /= jugadoresEquipo.length;
        if (promedio > promedioMasAlto) {
            promedioMasAlto = promedio;
            equipoMasFuerte = equipos[i];
        }
    }
}

// Mostrar el equipo más fuerte
if (equipoMasFuerte != null) {
    ob.mostrar("El equipo más fuerte es " + equipoMasFuerte.getNombre() + " con un promedio de puntuación de " + promedioMasAlto);
} else {
    ob.mostrar("No se encontró un equipo más fuerte.");
}
}




    
    public static int solicitarNumeroPositivo(int mensaje) {
   InOut ob=new InOut();
    int num = mensaje;
    while (num < 0) {
        num = ob.solicitar("EL numero debe ser positivo");
    }
    return num;
}

public static int solicitarNivel(int mensaje) {
InOut ob=new InOut();
    int nivel = mensaje;
    while (nivel < 0 || nivel > 10) {
        nivel = ob.solicitar("Debe estar entre 1 y 10");
    }
    return nivel;
}


}
