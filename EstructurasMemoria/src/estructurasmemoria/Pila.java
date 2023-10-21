package estructurasmemoria;

import javax.swing.ImageIcon;

public class Pila {
    private Carta tope;
    static private int cantidadCartas;
    
    Carta cartaAux = new Carta(0,new ImageIcon(),0);
    Pila pilaAux;
    
    public Pila() {
        tope = null;
    }
    
    public boolean esVacia() {
        return tope == null;
    }
    
    public void agregar(Carta nuevaCarta) {
        if (esVacia()) {
            tope = nuevaCarta;
        }
        else {
            nuevaCarta.setSiguienteCarta(tope);
            tope = nuevaCarta;
        }
        cantidadCartas++;
    }
    
    public void agregarPar(Carta nuevaCarta) {
        cartaAux = new Carta(nuevaCarta.getNumero(), nuevaCarta.getImagen(), nuevaCarta.getPuntos());
                
        agregar(nuevaCarta);
        agregar(cartaAux);
    }
    
    public Carta sacarPrimera() {
        cartaAux = tope;
        if (!esVacia()) {
            tope = tope.getSiguienteCarta();
        }
        cantidadCartas--;
        return cartaAux;
    }
    
    public int getCantidad() {
        return cantidadCartas;
    }
    
    public void mostrar() {
        pilaAux = this;
        
        if (esVacia()) {
            System.out.println("La pila está vacía");
        }
        else {
            while (!pilaAux.esVacia()) {
                System.out.print(pilaAux.sacarPrimera().getNumero() + " -> ");
            }
            System.out.println("null");
        }
    }
}
