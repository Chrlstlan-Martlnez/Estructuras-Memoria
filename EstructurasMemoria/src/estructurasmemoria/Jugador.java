package estructurasmemoria;

import java.awt.Color;

public class Jugador {
    private String nombre;
    private Color color;
    private int cartasParaVoltear;
    private int turnos;
    private double puntos;
    private int parejas;
    private LabelCarta[] arregloCartas;
    private Jugador siguiente;
    
    
    public Jugador(String nombreJug, Color colorJug, int turnosJug, LabelCarta[] arregloCartasJug){
        nombre = nombreJug;
        color = colorJug;
        cartasParaVoltear = 2;
        turnos = turnosJug;
        puntos = 0;
        parejas = 0;
        arregloCartas = arregloCartasJug;
        siguiente = null;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Color getColor(){
        return color;
    }
    
    public int getTurnos(){
        return turnos;
    }
    
    public LabelCarta[] getArreglo(){
        return arregloCartas;
    }
    
    public void setSiguiente(Jugador jugador){
        siguiente  = jugador;
    }
    
    public void setCartasPorVoltear(int cartasVolteables){
        cartasParaVoltear  = cartasVolteables;
    }
    
    public int getCartasPorVoltear(){
        return cartasParaVoltear;
    }
    
    public Jugador getSiguiente(){
        return siguiente;
    }
    
    public void sumarPareja(){
        parejas++;
    }
    
    public void sumarPuntosPareja(double puntosGanados){
        puntos = puntos + (puntosGanados * 2);
    }
    
    public void sumarPuntosTrio(double puntosGanados){
        puntos = puntos + (puntosGanados * 3);
    }
    
    public void sumarTurno(){
        turnos++;
    }
    
    public int getParejas(){
        return parejas;
    }
    
    public double getPuntos(){
        return puntos;
    }
    
}
