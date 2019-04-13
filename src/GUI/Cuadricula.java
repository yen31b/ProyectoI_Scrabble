package GUI;
import Logic.ListaDoble;
import Logic.*;
import Logic.CasillaB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cuadricula extends JFrame{

    public static java.awt.Color DEFAULT_BUTTON_COLOR;


    private javax.swing.JButton challengeButton;
    private JPanel panelControl;
    private JPanel dummyBoardPanel;
    private JButton BotonTerminarTurno;
    private JLabel Intrucciones;
    private JLabel LabelJug1;
    private JLabel LabelPuntJug1;
    private JLabel LabelJug2;
    private JLabel LabelPuntJug2;
    private JButton Ficha1;
    private JButton Ficha2;
    private JButton Ficha3;
    private JButton Ficha4;
    private JButton Ficha5;
    private JButton Ficha6;
    private JButton Ficha7;
    private JButton But_nuevojuego;


    private JPanel panelTablero;
    private ListaDoble<CasillaB> botonBaraja;
    private ListaDoble<CasillaB> listBotonCasilla;

    public Cuadricula () {
    }


    public void ComponentesBasicos(Tablero tablero) {
        panelTablero = new JPanel();
        panelControl = new javax.swing.JPanel();
        But_nuevojuego = new javax.swing.JButton();
        DEFAULT_BUTTON_COLOR = But_nuevojuego.getBackground();
        Ficha1 = new CasillaB();
        Ficha2 = new CasillaB();
        Ficha3 = new CasillaB();
        Ficha4 = new CasillaB();
        Ficha5 = new CasillaB();
        Ficha6 = new CasillaB();
        Ficha7 = new CasillaB();
        botonBaraja = new ListaDoble<>();
        listBotonCasilla = new ListaDoble<>();
        Intrucciones = new javax.swing.JLabel();
        LabelJug1 = new javax.swing.JLabel();
        LabelPuntJug1 = new javax.swing.JLabel();
        LabelJug2 = new javax.swing.JLabel();
        LabelPuntJug2 = new javax.swing.JLabel();
        BotonTerminarTurno = new javax.swing.JButton();
        challengeButton = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(628, 780));
        setResizable(true);
        setLocationRelativeTo(null);
        setResizable(false);


        Intrucciones.setText("Coloque la ficha en la casilla que desea");
        Intrucciones.setVisible(false);


        LabelJug1.setText("Jugador 1-Puntos:");
        LabelPuntJug1.setText("0");


        LabelJug2.setText("Jugador 2-Puntos:");
        LabelPuntJug2.setText("0");


        BotonTerminarTurno.setText("Terminar Turno");


        Ficha1.setPreferredSize(new java.awt.Dimension(80, 62));
        Ficha1.setEnabled(false);
        Ficha2.setPreferredSize(new java.awt.Dimension(80, 62));
        Ficha2.setEnabled(false);
        Ficha3.setPreferredSize(new java.awt.Dimension(80, 62));
        Ficha3.setEnabled(false);
        Ficha4.setPreferredSize(new java.awt.Dimension(80, 62));
        Ficha4.setEnabled(false);
        Ficha5.setPreferredSize(new java.awt.Dimension(80, 62));
        Ficha5.setEnabled(false);
        Ficha6.setPreferredSize(new java.awt.Dimension(80, 62));
        Ficha6.setEnabled(false);
        Ficha7.setPreferredSize(new java.awt.Dimension(80, 62));
        Ficha7.setEnabled(false);

        botonBaraja.insertLast((CasillaB) Ficha1);
        botonBaraja.insertLast((CasillaB) Ficha2);
        botonBaraja.insertLast((CasillaB) Ficha3);
        botonBaraja.insertLast((CasillaB) Ficha4);
        botonBaraja.insertLast((CasillaB) Ficha5);
        botonBaraja.insertLast((CasillaB) Ficha6);
        botonBaraja.insertLast((CasillaB) Ficha7);


        panelTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelTablero.setPreferredSize(new java.awt.Dimension(616, 600));
        panelTablero.setLayout(new java.awt.GridLayout(0, 15));


        panelControl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelControl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelControl.setPreferredSize(new java.awt.Dimension(616, 151));


        But_nuevojuego.setText("Iniciar Juego");


        for (int i = 0; i < tablero.casillas.getSize(); i++) {

            listBotonCasilla.insertLast(new CasillaB());

            listBotonCasilla.searchNodo(i).getDato().setText(tablero.casillas.searchNodo(i).getDato().obtLabel());
            if (tablero.casillas.searchNodo(i).getDato().obtLabel().equalsIgnoreCase("Px3")) {
                listBotonCasilla.searchNodo(i).getDato().setBackground(Color.RED);
            } else if (tablero.casillas.searchNodo(i).getDato().obtLabel().equalsIgnoreCase("Lx3")) {
                listBotonCasilla.searchNodo(i).getDato().setBackground(Color.BLUE);
            } else if (tablero.casillas.searchNodo(i).getDato().obtLabel().equalsIgnoreCase("Px2")) {
                listBotonCasilla.searchNodo(i).getDato().setBackground(Color.ORANGE);
            } else if (tablero.casillas.searchNodo(i).getDato().obtLabel().equalsIgnoreCase("Lx2")) {
                listBotonCasilla.searchNodo(i).getDato().setBackground(Color.CYAN);
            }

            listBotonCasilla.searchNodo(i).getDato().setMargin(new Insets(0, 0, 0, 0));
            listBotonCasilla.searchNodo(i).getDato().setCasillaAsig(tablero.casillas.searchNodo(i).getDato());


            if (i == 112) {
                listBotonCasilla.searchNodo(i).getDato().setBackground(Color.LIGHT_GRAY);
                listBotonCasilla.searchNodo(i).getDato().obtCasillaAsig().setValido(true);
            }

            if (listBotonCasilla.searchNodo(i).getDato().obtCasillaAsig().esValido()) {
                listBotonCasilla.searchNodo(i).getDato().setEnabled(true);
            } else {
                listBotonCasilla.searchNodo(i).getDato().setEnabled(false);
            }
            panelTablero.add(listBotonCasilla.searchNodo(i).getDato());

        }

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(panelControl);
        panelControl.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
                controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPanelLayout.createSequentialGroup()
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(But_nuevojuego)
                                                        .addComponent(BotonTerminarTurno))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LabelJug1)
                                                        .addComponent(LabelJug2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(LabelPuntJug2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LabelPuntJug1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(challengeButton))
                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(Ficha1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Ficha2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Ficha3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Ficha4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Ficha5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Ficha6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Ficha7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(Intrucciones)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
                controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPanelLayout.createSequentialGroup()
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(But_nuevojuego)
                                                        .addComponent(LabelJug1)
                                                        .addComponent(LabelPuntJug1)))
                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(challengeButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LabelJug2)
                                        .addComponent(LabelPuntJug2)
                                        .addComponent(BotonTerminarTurno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Intrucciones)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Ficha4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Ficha1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Ficha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Ficha3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Ficha5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Ficha6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(Ficha7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelControl, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    public void AC_BotonNuevoJuego(ActionListener listener) {
        But_nuevojuego.addActionListener(listener);
    }

    public void AC_BotonTerminarTurno(ActionListener listener) {
        BotonTerminarTurno.addActionListener(listener);
    }

    public void AC_BotonFicha1(ActionListener listener) {
        Ficha1.addActionListener(listener);
    }

    public void AC_BotonFicha2(ActionListener listener) {
        Ficha2.addActionListener(listener);
    }

    public void AC_BotonFicha3(ActionListener listener) {
        Ficha3.addActionListener(listener);
    }

    public void AC_BotonFicha4(ActionListener listener) {
        Ficha4.addActionListener(listener);
    }

    public void AC_BotonFicha5(ActionListener listener) {
        Ficha5.addActionListener(listener);
    }

    public void AC_BotonFicha6(ActionListener listener) {
        Ficha6.addActionListener(listener);
    }

    public void AC_BotonFicha7(ActionListener listener) {
        Ficha7.addActionListener(listener);
    }

    public void AC_BotonCasillaLista(ActionListener listener) {
        for (int i = 0; i < 225; i++) {
            listBotonCasilla.searchNodo(i).getDato().addActionListener(listener);
        }
    }


    public void ActualizarBaraja(Jugador jugador) throws IndexOutOfBoundsException {
        for (int j=0; j<botonBaraja.getSize(); j++) {
            botonBaraja.searchNodo(j).getDato().setVisible(false);
            System.out.println(botonBaraja.searchNodo(j).getDato());
        }

        for (int i = 0; i < jugador.Obtener_baraja().getSize(); i++) {

            Ficha fichaAsignada = jugador.Obtener_baraja().searchNodo(i).getDato();
            System.out.println(fichaAsignada.getLetra());

            if (fichaAsignada.getPuntos() == 0) {
                fichaAsignada.setLetra('?');
            }

            botonBaraja.searchNodo(i).getDato().setFichaAsig(fichaAsignada);
            botonBaraja.searchNodo(i).getDato().setVisible(true);
            botonBaraja.searchNodo(i).getDato().setEnabled(true);

        }

    }
    public void ActualizarTablero(Tablero tablero) {
        for (int i = 0; i < tablero.casillas.getSize(); i++) {

            if (tablero.casillas.searchNodo(i).getDato().obtFichaAsig() == null) {

                if (tablero.casillas.searchNodo(i).getDato().obtLabel().equalsIgnoreCase("Px3")) {
                    listBotonCasilla.searchNodo(i).getDato().setBackground(Color.RED);
                } else if (tablero.casillas.searchNodo(i).getDato().obtLabel().equalsIgnoreCase("Lx3")) {
                    listBotonCasilla.searchNodo(i).getDato().setBackground(Color.BLUE);
                } else if (tablero.casillas.searchNodo(i).getDato().obtLabel().equalsIgnoreCase("Px2")) {
                    listBotonCasilla.searchNodo(i).getDato().setBackground(Color.PINK);
                } else if (tablero.casillas.searchNodo(i).getDato().obtLabel().equalsIgnoreCase("Lx2")) {
                    listBotonCasilla.searchNodo(i).getDato().setBackground(Color.CYAN);
                }

                if (i == 112) {
                    listBotonCasilla.searchNodo(i).getDato().setBackground(Color.MAGENTA);
                }

            }


            if (tablero.casillas.searchNodo(i).getDato().esValido()) {
                listBotonCasilla.searchNodo(i).getDato().setEnabled(true);
            } else {
                listBotonCasilla.searchNodo(i).getDato().setEnabled(false);
            }

        }
    }


    public void setRackButton1Enabled(boolean enabled) {
        Ficha1.setEnabled(enabled);
    }

    public void setRackButton2Enabled(boolean enabled) {
        Ficha2.setEnabled(enabled);
    }

    public void setRackButton3Enabled(boolean enabled) {
        Ficha3.setEnabled(enabled);
    }

    public void setRackButton4Enabled(boolean enabled) {
        Ficha4.setEnabled(enabled);
    }

    public void setRackButton5Enabled(boolean enabled) {
        Ficha5.setEnabled(enabled);
    }

    public void setRackButton6Enabled(boolean enabled) {
        Ficha6.setEnabled(enabled);
    }

    public void setRackButton7Enabled(boolean enabled) {
        Ficha7.setEnabled(enabled);
    }

    public void setRackButton1bg(java.awt.Color color) {
        Ficha1.setBackground(color);
    }

    public void setRackButton2bg(java.awt.Color color) {
        Ficha2.setBackground(color);
    }

    public void setRackButton3bg(java.awt.Color color) {
        Ficha3.setBackground(color);
    }

    public void setRackButton4bg(java.awt.Color color) {
        Ficha4.setBackground(color);
    }

    public void setRackButton5bg(java.awt.Color color) {
        Ficha5.setBackground(color);
    }

    public void setRackButton6bg(java.awt.Color color) {
        Ficha6.setBackground(color);
    }

    public void setRackButton7bg(java.awt.Color color) {
        Ficha7.setBackground(color);
    }


    public void setStartNewGameButton1Enabled(boolean enabled) {
        But_nuevojuego.setEnabled(enabled);
    }


    public void showInstructions(boolean enabled) {
        Intrucciones.setVisible(enabled);
    }

    public void setPlayer1Score(int newScore) {
        LabelPuntJug1.setText(String.valueOf(newScore));
    }

    public void setPlayer2Score(int newScore) {
        LabelPuntJug2.setText(String.valueOf(newScore));
    }


}

