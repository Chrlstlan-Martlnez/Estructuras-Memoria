package estructurasmemoria;

import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class EstructurasMemoria {

    static void definirPrimerJugador(Cola colaJugadores, Jugador jugador1, Jugador jugador2){
        Random primerTurno = new Random();
        int primerJugador = primerTurno.nextInt(2);
        
        if (primerJugador == 0){
            colaJugadores.encolar(jugador1);
            colaJugadores.encolar(jugador2);
        }
        else {
            colaJugadores.encolar(jugador2);
            colaJugadores.encolar(jugador1);
        }
        
    }

    static void llenarTablerorConBotones(BotonCarta[] botonesTablero, ImageIcon espacioVacio, Panel panelTablero){
        for (int i = 0; i < 24; i++) {
            botonesTablero[i] = new BotonCarta(espacioVacio, new Color(0x111111), new Dimension(80,80));
            panelTablero.add(botonesTablero[i]);
        }
        
    }

    static void asignarLabelsParejasJugador(LabelCarta[] LabelsParejasJ1, LabelCarta[] LabelsParejasJ2, Panel parejasJ1, Panel parejasJ2){
        for (int i = 0; i < 11; i++) {
            LabelsParejasJ1[i] =new LabelCarta(new Color(0x333333), new Dimension(40,40));
            LabelsParejasJ2[i] =new LabelCarta(new Color(0x333333), new Dimension(40,40));
            parejasJ1.add(LabelsParejasJ1[i]);
            parejasJ2.add(LabelsParejasJ2[i]);
        }
    }

    static void llenarPilaCartas(Pila pilaCartas){
        pilaCartas.agregarPar(new Carta(1, new ImageIcon("iconos\\wither.png"), 1));
        pilaCartas.agregar(new Carta(1, new ImageIcon("iconos\\wither.png"), 1));
        pilaCartas.agregarPar(new Carta(2, new ImageIcon("iconos\\huevo.png"), 1.5));
        pilaCartas.agregarPar(new Carta(3, new ImageIcon("iconos\\ojo.png"), 1));
        pilaCartas.agregarPar(new Carta(4, new ImageIcon("iconos\\carne.png"), -1));
        pilaCartas.agregarPar(new Carta(5, new ImageIcon("iconos\\manzana.png"), 1));
        pilaCartas.agregarPar(new Carta(6, new ImageIcon("iconos\\creeper.png"), 1));
        pilaCartas.agregarPar(new Carta(7, new ImageIcon("iconos\\diamante.png"), 1.5));
        pilaCartas.agregarPar(new Carta(8, new ImageIcon("iconos\\mesa.png"), 1));
        pilaCartas.agregarPar(new Carta(9, new ImageIcon("iconos\\espada.png"), 1));
        pilaCartas.agregarPar(new Carta(10, new ImageIcon("iconos\\hierro.png"), 1));
        pilaCartas.agregarPar(new Carta(11, new ImageIcon("iconos\\cama.png"), 1));
        
    }

    static void asignarCartasTablero(Pila pilaC, BotonCarta[] arregloBotones){
        Random r = new Random();
        
        for (int i = 0; i < 23; i++) {
            Carta aux = pilaC.sacarPrimera();
            int pos = r.nextInt(24);
            
            if (aux != null){
                while (arregloBotones[pos].numero != 0){
                    pos = r.nextInt(24);
                }
                
                arregloBotones[pos].img = aux.getImagen();
                arregloBotones[pos].setNumero(aux.getNumero());
                arregloBotones[pos].setPuntos(aux.getPuntos());
                
            }
        }
    }
    
    static boolean arregloCartasVacio(BotonCarta[] arregloBotones, boolean listaVacia){
        for (int i = 0; i < 24; i++) {
            if (arregloBotones[i].numero != 0 ){
                listaVacia = false;
                arregloBotones[i].setEnabled(true);
            }
            else if (arregloBotones[i].numero == 0){
                arregloBotones[i].setEnabled(false);
            }
        }
        return listaVacia;
    }
    
    static void deshabilitarCartasSiPuntua(BotonCarta[] arregloBotones, int primeraCarta) throws InterruptedException{
        for (int k = 0; k <= 23; k++) {
            if ((arregloBotones[k].numero != arregloBotones[primeraCarta].numero)) {
                arregloBotones[k].setEnabled(false);
            }
        }
        Thread.sleep(1000);
    }
    
    static void deshabilitarCartas(BotonCarta[] arregloBotones, int primeraCarta, int segundaCarta) throws InterruptedException{
        for (int k = 0; k <= 23; k++) {
            if (((arregloBotones[k].numero != arregloBotones[primeraCarta].numero) 
                    && (arregloBotones[k].numero != arregloBotones[segundaCarta].numero) 
                    || (( k != primeraCarta) && ( k != segundaCarta)))) {
                
                arregloBotones[k].setEnabled(false);
            }
        }
        Thread.sleep(1000);
    }
    
    static void deshabilitarCartasConWither(BotonCarta[] arregloBotones, int primeraCarta, int segundaCarta, int terceraCarta) throws InterruptedException{
        for (int k = 0; k <= 23; k++) {
            if (((arregloBotones[k].numero != arregloBotones[primeraCarta].numero) 
                    && (arregloBotones[k].numero != arregloBotones[segundaCarta].numero) 
                        || (( k != primeraCarta) && ( k != segundaCarta) && ( k != terceraCarta)))) {
                arregloBotones[k].setEnabled(false);
            }
        }
        Thread.sleep(1000);
    }
    
    static void voltearCartas(BotonCarta[] arregloBoton, int primeraCarta, int segundaCarta){
        arregloBoton[primeraCarta].setClick(false);
        arregloBoton[segundaCarta].setClick(false);
    }
    
    static void eliminarCartaDeTablero(Jugador jugadorActual, BotonCarta[] arregloBotones, LabelCarta[] arregloLabels, int primeraCarta, int segundaCarta, boolean manzanaOro){
        for (int i = 0; i < 6; i++) {
            if (arregloLabels[i].getNumero() == 0){
                arregloLabels[i].setNumero(arregloBotones[primeraCarta].numero);
                arregloLabels[i].setIcon(arregloBotones[primeraCarta].img);
                arregloLabels[i].setIcon(arregloBotones[primeraCarta].img);
                if ((manzanaOro) && (arregloBotones[primeraCarta].numero == 4)) {
                    break;
                }
                else{
                    jugadorActual.sumarPuntosPareja(arregloBotones[primeraCarta].puntos);
                    System.out.println(jugadorActual.getNombre()+ (arregloBotones[primeraCarta].puntos *2));
                    break;
                }
            }
        }
        arregloBotones[primeraCarta].setNumero(0);
        arregloBotones[segundaCarta].setNumero(0);
    }
    
    static void eliminarWitherDeTablero(Jugador jugadorActual, BotonCarta[] arregloBotones, LabelCarta[] arregloLabels, int primeraCarta, int segundaCarta, int terceraCarta){
        for (int i = 0; i < 6; i++) {
            if (arregloLabels[i].getNumero() == 0){
                arregloLabels[i].setNumero(arregloBotones[primeraCarta].numero);
                arregloLabels[i].setIcon(arregloBotones[primeraCarta].img);
                jugadorActual.sumarPuntosTrio(arregloBotones[primeraCarta].puntos);
                System.out.println(jugadorActual.getNombre()+ (arregloBotones[primeraCarta].puntos *3));
                break;
            }
        }
        
        arregloBotones[primeraCarta].setNumero(0);
        arregloBotones[segundaCarta].setNumero(0);
        arregloBotones[terceraCarta].setNumero(0);
    }
    
    static void terceraCabezaWither(BotonCarta[] arregloBotones, LabelCarta[] arregloLabel, int primeraCarta, int segundaCarta, int terceraCarta, Cola colaJugadores){
        eliminarWitherDeTablero(colaJugadores.getPrimero(), arregloBotones, arregloLabel, primeraCarta, segundaCarta, terceraCarta);
        voltearCartas(arregloBotones, primeraCarta, segundaCarta);
        arregloBotones[terceraCarta].setClick(false);
    }
    
    static void parejaEncontrada(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores, boolean manzanaOro) throws InterruptedException{
        deshabilitarCartasSiPuntua(botonesTablero, primerIterador);
        eliminarCartaDeTablero(colaJugadores.getPrimero(), botonesTablero, colaJugadores.getPrimero().getArreglo(), primerIterador, segundoIterador, manzanaOro);
        voltearCartas(botonesTablero, primerIterador, segundoIterador);
        colaJugadores.getPrimero().sumarPareja();
    }
    
    static void parejaNoEncontrada(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores) throws InterruptedException{
        deshabilitarCartas(botonesTablero, primerIterador, segundoIterador);
        voltearCartas(botonesTablero, primerIterador, segundoIterador);
        colaJugadores.getPrimero().sumarTurno();
        colaJugadores.encolar(colaJugadores.desencolar());
    }
    
    static void tercerWitherEncontrado(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, int tercerIterador, Cola colaJugadores) throws InterruptedException{
        System.out.println("siiiiiiiiiiiiiiiiiiiiiiiiiiii");
        deshabilitarCartasSiPuntua(botonesTablero, primerIterador);
        terceraCabezaWither(botonesTablero, colaJugadores.getPrimero().getArreglo(), primerIterador, segundoIterador, tercerIterador, colaJugadores);
        colaJugadores.getPrimero().sumarPareja();
    }
    
    static void tercerWitherNoEncontrado(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, int tercerIterador, Cola colaJugadores) throws InterruptedException{
        System.out.println("noooooooooooooooooooooooooooooo");
        deshabilitarCartasConWither(botonesTablero, primerIterador, segundoIterador, tercerIterador);
        voltearCartas(botonesTablero, primerIterador, segundoIterador);
        botonesTablero[tercerIterador].setClick(false);
        colaJugadores.getPrimero().sumarTurno();
        colaJugadores.encolar(colaJugadores.desencolar());
    }
    
    static void buscarUltimoWither(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, int tercerIterador, Cola colaJugadores) throws InterruptedException{
        if (((botonesTablero[tercerIterador].numero == 1) && (botonesTablero[tercerIterador].click)) && (tercerIterador!=primerIterador)) {
            tercerWitherEncontrado(botonesTablero, primerIterador, segundoIterador, tercerIterador, colaJugadores);
            colaJugadores.getPrimero().setCartasPorVoltear(0);
        }
        else if ((botonesTablero[tercerIterador].numero != 1) && (botonesTablero[tercerIterador].click)) {
            tercerWitherNoEncontrado(botonesTablero, primerIterador, segundoIterador, tercerIterador, colaJugadores);
            colaJugadores.getPrimero().setCartasPorVoltear(0); 
        }
    }
    
    static void segundoWitherEncontrado(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores) throws InterruptedException{
        while (colaJugadores.getPrimero().getCartasPorVoltear() != 0) {
            for (int k = segundoIterador+1; k <= 23; k++) {
                buscarUltimoWither(botonesTablero, primerIterador, segundoIterador, k, colaJugadores);
            }
            for (int k = segundoIterador-1; k >= 0; k--) {
                buscarUltimoWither(botonesTablero, primerIterador, segundoIterador, k, colaJugadores);
            }
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
    
    static void ojosEnderEncontrados(BotonCarta[] botonesTablero) throws InterruptedException{
        for (int i = 0; i < 23; i++) {
            if (botonesTablero[i].numero == 2){
                botonesTablero[i].setClick(true);
                Thread.sleep(1000);
                botonesTablero[i].setClick(false);
                break;
            }
        }
    }
    
    static void carnePodrida(LabelCarta[] parejasJugador, BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores) throws InterruptedException{
        for (int i = 0; i < 11; i++) {
            if (parejasJugador[i].getNumero() == 5){
                System.out.println(parejasJugador[i].getNumero());
                parejaEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores, true);
                break;
            }
            else{
                parejaEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores, false);
                break;
            }
        }
    }
    
    static void buscarSegundaCarta(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores) throws InterruptedException{
        if ((botonesTablero[primerIterador].numero == botonesTablero[segundoIterador].numero) && (botonesTablero[segundoIterador].click)){
            switch(botonesTablero[primerIterador].numero){
                case 1:{
                    colaJugadores.getPrimero().setCartasPorVoltear(1);
                    segundoWitherEncontrado(botonesTablero, primerIterador, segundoIterador, colaJugadores);
                    break;
                }
                case 3:{
                    ojosEnderEncontrados(botonesTablero);
                    parejaEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores, false);
                    break;
                }
                case 4:{
                    carnePodrida(colaJugadores.getPrimero().getArreglo(), botonesTablero, primerIterador, segundoIterador, colaJugadores);
                    break;
                }
                default:{
                    parejaEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores, false);
                    break;
                }
            }
        }
        else if ((botonesTablero[primerIterador].numero != botonesTablero[segundoIterador].numero) && botonesTablero[segundoIterador].click){
            colaJugadores.getPrimero().setCartasPorVoltear(0);
            parejaNoEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores);
        }
    }
    
    public static void main(String[] args) throws InterruptedException { 
        boolean tableroVacio;
        
        Pila pilaCartas = new Pila();
        Cola colaJugadores = new Cola();
        
        ImageIcon espacioVacio = new ImageIcon("iconos\\cartaVacia.png");
        
        Ventana ventanaJuego = new Ventana("Prueba", new Color(0x000000), new Dimension(700,320));
        Panel panelTablero = new Panel(new Dimension(500,320), new Color(0x111111), false, BorderFactory.createLineBorder(Color.yellow), new GridLayout(4,6));
        Panel parejasJ1 = new Panel(new Dimension(100,320), new Color(0x111111), true, BorderFactory.createLineBorder(Color.blue), new GridLayout(11,1));
        Panel parejasJ2 = new Panel(new Dimension(100,320), new Color(0x111111), true, BorderFactory.createLineBorder(Color.red), new GridLayout(11,1));
        
        BotonCarta botonesTablero[] = new BotonCarta[24];
        LabelCarta LabelsParejasJ1[] = new LabelCarta[11];
        LabelCarta LabelsParejasJ2[] = new LabelCarta[11];
        
        Jugador jugador1 = new Jugador("Steve", new Color(0,0,255), 0, LabelsParejasJ1);
        Jugador jugador2 = new Jugador("Alex", new Color(255,0,0), 0, LabelsParejasJ2);
        
        definirPrimerJugador(colaJugadores, jugador1, jugador2);
        llenarTablerorConBotones(botonesTablero, espacioVacio, panelTablero);
        asignarLabelsParejasJugador(LabelsParejasJ1, LabelsParejasJ2, parejasJ1, parejasJ2);
        
        llenarPilaCartas(pilaCartas);
        asignarCartasTablero(pilaCartas, botonesTablero);
        
        ventanaJuego.add(panelTablero, BorderLayout.CENTER);
        ventanaJuego.add(parejasJ1, BorderLayout.WEST);
        ventanaJuego.add(parejasJ2, BorderLayout.EAST);
        ventanaJuego.setVisible(true);
        
        System.out.println(colaJugadores.getPrimero().getNombre());
        do {
            tableroVacio = true;
            tableroVacio = arregloCartasVacio(botonesTablero, tableroVacio);
            
            for (int i = 0; i < 23; i++) {
                if (botonesTablero[i].click){
                    for (int j = i+1; j <= 23; j++) {
                        buscarSegundaCarta(botonesTablero, i, j, colaJugadores);
                    }
                    for (int j = i-1; j >= 0; j--) {
                        buscarSegundaCarta(botonesTablero, i, j, colaJugadores);
                    }
                }
            }
        } while ((!tableroVacio) && ((colaJugadores.getPrimero().getPuntos() < 12.5) || (colaJugadores.getUltimo().getPuntos() < 12.5)));
        
        System.out.println(colaJugadores.getPrimero().getNombre());
        System.out.println(colaJugadores.getPrimero().getParejas());
        System.out.println(colaJugadores.getPrimero().getTurnos());
        System.out.println(colaJugadores.getPrimero().getPuntos());
        System.out.println(colaJugadores.getUltimo().getNombre());
        System.out.println(colaJugadores.getUltimo().getParejas());
        System.out.println(colaJugadores.getUltimo().getTurnos());
        System.out.println(colaJugadores.getUltimo().getPuntos());
    }
      
}
