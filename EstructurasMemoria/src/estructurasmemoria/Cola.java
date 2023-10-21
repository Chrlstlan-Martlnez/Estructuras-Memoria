package estructurasmemoria;

public class Cola {
    private Jugador primero;
    private Jugador ultimo;
    
    
    public Cola(){
        primero = ultimo = null;
    }
    
    public boolean esVacia() {
        return primero == null;
    }
    
    public void encolar(Jugador jugador) {

        if (ultimo == null) {
            primero = ultimo = jugador;
        } 
        else {
            ultimo.setSiguiente(jugador);
            ultimo = jugador;
        }
    }

    public Jugador desencolar() {
        Jugador aux = primero;
        primero = primero.getSiguiente();
        primero.setCartasPorVoltear(2);
        
        if (primero == null) {
            ultimo = null;
        }
        return aux;
    }

    public Jugador getPrimero() {
        return primero;
    }
    
    public Jugador getUltimo() {
        return ultimo;
    }

}
