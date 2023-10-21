package estructurasmemoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    Ventana(String nombre, Color fondo, Dimension tamano){
        this.setTitle(nombre);
        this.getContentPane().setBackground(fondo);
        this.setMinimumSize(tamano);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }
}
