package estructurasmemoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class LabelCarta extends JLabel{
    private int numero;
    
    
    public LabelCarta(Color fondo, Dimension tamano){
        this.setLayout(new FlowLayout());
        this.setBackground(fondo);
        this.setOpaque(true);
        this.setPreferredSize(tamano);
        numero = 0;
    }
    
    public void setNumero(int nuevoNumero){
        numero = nuevoNumero;
    }
    
    public int getNumero(){
        return numero;
    }
    
}
