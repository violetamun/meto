/*La clase puntaje va a contener la cantidad de cartas, la cantidad de oros, la cantidad de escobas
un valor bouleano ṕara eel siete de oro y un array con la cantidad de sietes. Para calcular el puntaje total del juego, 
voy a tener que comparar la clase puntaje de los dos jugadores. **/package intentobarajas;

import java.util.ArrayList;

public class Puntaje extends Jugador{

    private int cantidadCartas;

    private int cantidadOros;

    private int cantidadEscobas;

    private Baraja ArraySietes;

    private int cantidadSietes;



   

    public Puntaje( ) {
        this.ArraySietes = ArraySietes;
    }



    public int getCantidadCartas() {
        return cantidadCartas;
    }

    public void setCantidadCartas(int cantidadCartas) {
        this.cantidadCartas = cantidadCartas;
    }

    public int getCantidadOros() {
        return cantidadOros;
    }

    public void setCantidadOros(int cantidadOros) {
        this.cantidadOros = cantidadOros;
    }

    public int getCantidadEscobas() {
        return cantidadEscobas;
    }

    public void setCantidadEscobas(int cantidadEscobas) {
        this.cantidadEscobas = cantidadEscobas;
    }

    public Baraja getArraySietes() {
        return ArraySietes;
    }

    public void setArraySietes(Baraja ArraySietes) {
        this.ArraySietes = ArraySietes;
    }

    public int getCantidadSietes() {
        return cantidadSietes;
    }

    public void setCantidadSietes(int cantidadSietes) {
        this.cantidadSietes = cantidadSietes;
    }

   
    /*Modo para contar la cantidad de cartas qu el jugador acumuló en su array de cartas levantadas
    devuelve un int, y recibe por parámetro un jugador. De ese jugador getea su atributo cartas levantadas, que 
    es una baraja donde se guaran todas las cartas que el jugador levanta en cada mano.De esa baraja toma su lista, que es el arrayLis, 
    y de este con el método size de arrayList obtiene la cantidad de elementos del array**/
    public void contarCartas(Jugador jugador) {
        jugador.getPuntaje().setCantidadCartas(jugador.getCartasLevantadas().getLista().size());
    }

    /*Devuelve un int, recibe un array de cartas levantadas(cuando lo invique debera hacer un get de baraaja y un et de lista)
    recorre el array que recibe, getea su atributo Palo y lo compara con oro. Si es oro, suma uno a cantOros.
    **/
    public void contarOros(Jugador jugador) {
        int cantOros = 0;
        for (int i = 0; i < jugador.getCartasLevantadas().getLista().size(); i++) {
            if (jugador.getCartasLevantadas().getLista().get(i).getPalo().equals("Oro")) {
                cantOros++;
            }

        }

        jugador.getPuntaje().setCantidadOros(cantidadOros);

    }

    /* Idem contar cartas, pero recibe por parámeetro el array que guarda los 7**/
    public void contarSietes(Jugador jugador) {

        int cantSietes = jugador.getPuntaje().getArraySietes().getLista().size();
        jugador.getPuntaje().setCantidadSietes(cantidadSietes);

    }

    /* Recorre el arraay de los 7, y verifica si alguno es oro. Si lo encuentre vuelve true el valor de sieteOro**/
    public boolean sieteOro(Jugador jugador) {
        boolean sieteOro = false;
        for (int i = 0; i < jugador.getPuntaje().getArraySietes().getLista().size(); i++) {
            if (jugador.getPuntaje().getArraySietes().getLista().get(i).getPalo().equals("Oro")) {
                sieteOro = true;
            }
        }

        return sieteOro;

    }

    /* Recorre el Array de cartasLevantadas y devuelve un array con los 7 encontrados.
    IMPORTANTE: este método es abtracto y solo se ejecuta dentro de la clase puntaje, con el objetido de 
    modificar el estado de arraySietes que ya está dentro de esta clase. Dbo tener cuidado cuando lo llamo y 
    despues debo tener cuidado cuando uso el arraySietes**/

    public void armarArrayDeSietes(Jugador jugador) {

        for (int i = 0; i < jugador.getCartasLevantadas().getLista().size(); i++) {
            if (jugador.getCartasLevantadas().getLista().get(i).getNumero() == 7) {
                ArraySietes.getLista().add(jugador.getCartasLevantadas().getLista().get(i));
            }
        }

    }
//Calcula el puntaje final de la partida
    
    public void calcularPuntajeFinal(Jugador jugador1, Jugador jugador2) {
        //Aplica a jugador 1 todos los métodos necesarios para contar sus puntos.
        jugador1.getPuntaje().contarCartas(jugador2);
        jugador1.getPuntaje().contarOros(jugador2);
        jugador1.getPuntaje().armarArrayDeSietes(jugador2);
        jugador1.getPuntaje().contarSietes(jugador2);
        jugador1.getPuntaje().sieteOro(jugador1);

        //Aplica a jugador 2 los mismos métodos
        jugador1.getPuntaje().contarCartas(jugador1);
        jugador1.getPuntaje().contarOros(jugador1);
        jugador1.getPuntaje().armarArrayDeSietes(jugador1);
        jugador1.getPuntaje().contarSietes(jugador1);
        jugador1.getPuntaje().sieteOro(jugador1);

        /*Comparo cantidad de cartas**/
        if (jugador1.getPuntaje().getCantidadCartas() > jugador2.getPuntaje().getCantidadCartas()) {
            jugador1.setCantidadDePuntosObtenidos(jugador1.getCantidadDePuntosObtenidos()+1);
        } else if (jugador1.getPuntaje().getCantidadCartas() < jugador2.getPuntaje().getCantidadCartas()) {
            jugador2.setCantidadDePuntosObtenidos(jugador2.getCantidadDePuntosObtenidos()+1);

        }
        /*Comparo cantidad de oros**/
        if (jugador1.getPuntaje().getCantidadOros() > jugador2.getPuntaje().getCantidadOros()) {
            jugador1.setCantidadDePuntosObtenidos(jugador1.getCantidadDePuntosObtenidos()+1);
            
        } else if (jugador1.getPuntaje().getCantidadOros() < jugador2.getPuntaje().getCantidadOros()) {
            jugador2.setCantidadDePuntosObtenidos(jugador2.getCantidadDePuntosObtenidos()+1);
            
        }
        /*Comparo cantidad de sietes**/

        if (jugador1.getPuntaje().getCantidadSietes() > jugador2.getPuntaje().getCantidadSietes()) {
            jugador1.setCantidadDePuntosObtenidos(jugador1.getCantidadDePuntosObtenidos()+1);

        } else if (jugador1.getPuntaje().getCantidadSietes() < jugador2.getPuntaje().getCantidadSietes()) {
            jugador2.setCantidadDePuntosObtenidos(jugador2.getCantidadDePuntosObtenidos()+1);
            
        }

        if (sieteOro(jugador1)) {
            jugador1.setCantidadDePuntosObtenidos(jugador1.getCantidadDePuntosObtenidos()+1);

        } else {
            jugador2.setCantidadDePuntosObtenidos(jugador2.getCantidadDePuntosObtenidos() + 1);
        }

    }

    @Override
    public void contarCartas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
