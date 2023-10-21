package estructurasmemoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Panel extends JPanel{
    
    Panel(Dimension tamano, Color fondo){
        this.setLayout(new BorderLayout(20,20));
        this.setPreferredSize(tamano);
        this.setBackground(fondo);
    }
    
    Panel(Dimension tamano, Color fondo, LayoutManager tipoLayout){
        this.setLayout(tipoLayout);
        this.setPreferredSize(tamano);
        this.setBackground(fondo);
        
        if (tipoLayout == new BorderLayout()) {
            Panel centro = new Panel(new Dimension(10,10), fondo);
            this.add(centro, BorderLayout.CENTER);
        }
    }
    
    Panel(Dimension tamano, Color fondo, boolean transparente, Border borde, LayoutManager tipoLayout){
        this.setLayout(tipoLayout);
        this.setPreferredSize(tamano);
        this.setBackground(fondo);
        this.setBorder(borde);
        this.setOpaque(transparente);
        
        if (tipoLayout == new BorderLayout()) {
            Panel centro = new Panel(new Dimension(10,10), fondo);
            this.add(centro, BorderLayout.CENTER);
        }
    }
    
    
    
}
