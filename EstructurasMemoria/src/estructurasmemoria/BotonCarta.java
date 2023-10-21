package estructurasmemoria;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class BotonCarta extends JButton implements ActionListener{
    int numero;
    double puntos;
    boolean click;
    ImageIcon imgFondo;
    ImageIcon img;
    static int clicks;
    
    
    BotonCarta(ImageIcon imagen, Color fondo, Dimension tamano){
        setLayout(new BorderLayout());
        setBackground(fondo);
        setIcon(imagen);
        setOpaque(true);
        setPreferredSize(tamano);
        addActionListener(this);
        imgFondo = imagen;
        
        numero = 0;
        click = false;
    }
    
    public void setNumero(int nuevoNumero){
        numero = nuevoNumero;
    }
    
    public void setPuntos(double puntosCarta){
        puntos = puntosCarta;
    }
    
    public void setClick(boolean estadoClick){
        click = estadoClick;
        if (click){
            this.setIcon(img);
        }
        else{
            this.setIcon(imgFondo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            this.setClick(true);
        }
    }
    
}
