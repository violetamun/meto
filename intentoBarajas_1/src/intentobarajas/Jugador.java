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
public abstract class Jugador {

    private String nombre;
    private Baraja cartas;
    private Baraja cartasLevantadas;
    private int cantidadDePuntosObtenidos; 
    private Puntaje puntaje;
   
 
    public Jugador() {
        this.cartasLevantadas = new Baraja ();
        this.cartas = new Baraja();
        this.puntaje= new Puntaje();
       
        
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje= new Puntaje();
        this.cartas = new Baraja();
        this.cartasLevantadas = new Baraja ();
        this.cantidadDePuntosObtenidos=0;
    }

    public int getCantidadDePuntosObtenidos() {
        return cantidadDePuntosObtenidos;
    }

    public void setCantidadDePuntosObtenidos(int cantidadDePuntosObtenidos) {
        this.cantidadDePuntosObtenidos = cantidadDePuntosObtenidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Puntaje puntaje) {
        this.puntaje = puntaje;
    }

    public Baraja getCartas() {
        return cartas;
    }

    public void setCartas(Baraja cartasRepartidas) {
        this.cartas = cartasRepartidas;
    }

    public Baraja getCartasLevantadas() {
        return cartasLevantadas;
    }

    public void setCartasLevantadas(Baraja cartasLevantadas) {
        this.cartasLevantadas = cartasLevantadas;
    }
    public abstract void contarCartas();
            
            
     
    }
    
    
    

