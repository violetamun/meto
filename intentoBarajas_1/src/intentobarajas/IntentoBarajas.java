/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentobarajas;

import java.util.ArrayList;

/**
 *
 * @author estefania
 */
public class IntentoBarajas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Crea una baraja odenada

        Baraja bar1 = new Baraja();
        bar1.setLista(bar1.crearBaraja());

        System.out.println("Baraja Ordenada");
        //Muestra la baraja ordenada

        bar1.mostrarBaraja();
        //crea otro objeto baraaja

        Baraja barMezclada = new Baraja();
        //Mezcla el arrayList del nuevo objeto baraja
        barMezclada.setLista(bar1.mezclarBaraja(bar1.getLista()));
        //Muestra la baraja mezclada        
        System.out.println("Baraja desordenada");
        System.out.println("------------------------");

        barMezclada.mostrarBaraja();

        System.out.println("Baraja Cortada");
        //Cortar Mazo

        Baraja barCortada = new Baraja();

        barCortada.setLista(barMezclada.cortarMazo(barMezclada.getLista()));
        barCortada.mostrarBaraja();

        //Crea un jugador
        Jugador jug1 = new Jugador("Jugador 1") {
            @Override
            public void contarCartas() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        //reparte cartas al jugador
        jug1.getCartas().setLista(barCortada.repartir1(barCortada));
        System.out.println("Cartas jugador 1");
        System.out.println("----------------------------------------------------");
        System.out.println("");
        //Muestra las cartas del jugador
        jug1.getCartas().mostrarBaraja();

        Jugador jug2 = new Jugador("Jugador 2") {
            @Override
            public void contarCartas() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        jug2.getCartas().setLista(barCortada.repartir2(barCortada));
        System.out.println("----------------------------------------------------");
        System.out.println("Cartas jugador 2");
        System.out.println("");
        jug2.getCartas().mostrarBaraja();

        
        Mesa mesa= new Mesa();
        
       mesa.getMesa().setLista(barCortada.repartirMesa(barCortada));
        System.out.println("----------------------------------------------------");
        System.out.println("Catas de la Mesa");
        System.out.println("");
        mesa.getMesa().mostrarBaraja();
        
        
        
        

    }

}
