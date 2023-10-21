package estructurasmemoria;

import javax.swing.ImageIcon;

public class Carta {
    private int numero;
    private double puntos;
    private ImageIcon imagen;
    private Carta siguiente;
    
    
    public Carta(int numeroCarta, ImageIcon imagenCarta, double puntosCarta){
        numero = numeroCarta;
        imagen = imagenCarta;
        siguiente = null;
        puntos = puntosCarta;
    }
    
    public void setNumero(int numeroCarta) {
        numero = numeroCarta;
    }
    
    public void setImagen(ImageIcon nuevaImg) {
        imagen = nuevaImg;
    }
    
    public void setSiguiente(Carta nuevoSiguiente) {
        siguiente = nuevoSiguiente;
    }
    
    public void setCarta(Carta nueva) {
        setNumero(nueva.getNumero());
        setImagen(nueva.getImagen());
    }
    
    public void setSiguienteCarta(Carta nueva) {
        siguiente = nueva;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public double getPuntos() {
        return puntos;
    }
    
    public int getSiguienteNumero() {
        return siguiente.getNumero();
    }
    
    public ImageIcon getImagen() {
        return imagen;
    }
    
    public ImageIcon getSiguienteImagen() {
        return siguiente.getImagen();
    }
    
    public Carta getCarta() {
        return this;
    }
    
    public Carta getSiguienteCarta() {
        return siguiente;
    }
}
