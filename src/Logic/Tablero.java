package Logic;

import java.util.ArrayList;
import java.util.Collections;

public class Tablero {

    public static final int palabraTripe = 4;
    public static final int letraTripe = 3;
    public static final int palabraDoble = 2;
    public static final int letraDoble = 1;


    private static final int[] palabraTripleMatriz = {0, 7, 14, 105, 119, 210, 217, 224};
    private static final int[] dobleLetraMatriz = {3, 11, 36, 38, 45, 52, 59, 92, 96, 98, 102, 108, 116, 122, 126, 128,
            132, 165, 172, 179, 186, 188, 213, 221};
    private static final int[] doblePalabraMatriz = {16, 28, 32, 42, 48, 56, 64, 70, 154, 160, 168, 176, 182, 192, 196,
            208};
    private static final int[] tripleLetraMatriz = {20, 24, 76, 80, 84, 88, 136, 140, 144, 148, 200, 204};
    private static final int numCasillas = 225;

    public ListaDoble<Casilla> casillas;

    public Tablero() {
        casillas = new ListaDoble<>();

        for (int i = 0; i < numCasillas; i++) {
            casillas.insertLast(new Casilla(i));
        }
        establecerModPuntos();
    }

    private void establecerModPuntos() {

        for (int i = 0; i < numCasillas; i++) {
            for (int j = 0; j < palabraTripleMatriz.length; j++) {
                if (i == palabraTripleMatriz[j]) {
                    casillas.searchNodo(i).getDato().setAumento_Puntos(palabraTripe);
                    casillas.searchNodo(i).getDato().setLabel("TWS");
                }
            }
            for (int j = 0; j < tripleLetraMatriz.length; j++) {
                if (i == tripleLetraMatriz[j]) {
                    casillas.searchNodo(i).getDato().setAumento_Puntos(letraTripe);
                    casillas.searchNodo(i).getDato().setLabel("TLS");
                }
            }
            for (int j = 0; j < doblePalabraMatriz.length; j++) {
                if (i == doblePalabraMatriz[j]) {
                    casillas.searchNodo(i).getDato().setAumento_Puntos(palabraDoble);
                    casillas.searchNodo(i).getDato().setLabel("DWS");
                }
            }
            for (int j = 0; j < dobleLetraMatriz.length; j++) {
                if (i == dobleLetraMatriz[j]) {
                    casillas.searchNodo(i).getDato().setAumento_Puntos(letraDoble);
                    casillas.searchNodo(i).getDato().setLabel("DLS");
                }
            }
        }
    }



    public ArrayList<Casilla> getCasillasValidas(Estado_Juego estadoJuego) {

        ArrayList<Casilla> validCasillas = new ArrayList<>();

        for (int j=0; j<casillas.getSize();j++){
            casillas.searchNodo(j).getDato().setValido(false);
        }

        boolean tableroVacio = true;

        for (int j=0; j<casillas.getSize();j++){
            if (casillas.searchNodo(j).getDato().EsOcupado()
                    && estadoJuego.Obt_espacios_jugados().contains(casillas.searchNodo(j).getDato())) {
                casillas.searchNodo(j).getDato().setValido(true);
            }
            if (casillas.searchNodo(j).getDato().esValido()) {
                tableroVacio = false;
            }
        }

        if (tableroVacio) {
            casillas.searchNodo(112).getDato().setValido(true);
        }

        if (estadoJuego.Obt_espacios_jugados().isEmpty()) {
            for (int j = 0; j<casillas.getSize(); j++) {
                Casilla cadaCasilla = casillas.searchNodo(j).getDato();
                if (cadaCasilla.esValido()) {
                    if (!casillas.searchNodo(cadaCasilla.getIndex() - 1).getDato().EsOcupado()) {
                        casillas.searchNodo(cadaCasilla.getIndex() - 1).getDato().setValido(true);
                    }
                    if (!casillas.searchNodo(cadaCasilla.getIndex() - 15).getDato().EsOcupado()) {
                        casillas.searchNodo(cadaCasilla.getIndex() - 15).getDato().setValido(true);
                    }
                    if (!casillas.searchNodo(cadaCasilla.getIndex() + 1).getDato().EsOcupado()) {
                        casillas.searchNodo(cadaCasilla.getIndex() + 1).getDato().setValido(true);
                    }
                    if (!casillas.searchNodo(cadaCasilla.getIndex() + 15).getDato().EsOcupado()) {
                        casillas.searchNodo(cadaCasilla.getIndex() + 15).getDato().setValido(true);
                    }
                }
            }
        }


        if (estadoJuego.Obt_espacios_jugados().size() == 1) {
            Casilla firstCasilla = estadoJuego.Obt_espacios_jugados().get(0);
            if (!casillas.searchNodo(firstCasilla.getIndex() - 1).getDato().EsOcupado()) {
                casillas.searchNodo(firstCasilla.getIndex() - 1).getDato().setValido(true);
            } else {
                while (casillas.searchNodo(firstCasilla.getIndex() - 1).getDato().EsOcupado()) {
                    firstCasilla = casillas.searchNodo(firstCasilla.getIndex() - 1).getDato();
                }
                casillas.searchNodo(firstCasilla.getIndex() - 1).getDato().setValido(true);
                firstCasilla = estadoJuego.Obt_espacios_jugados().get(0);
            }


            if (!casillas.searchNodo(firstCasilla.getIndex() - 15).getDato().EsOcupado()) {
                casillas.searchNodo(firstCasilla.getIndex() - 15).getDato().setValido(true);
            } else {
                while (casillas.searchNodo(firstCasilla.getIndex() - 15).getDato().EsOcupado()) {
                    firstCasilla = casillas.searchNodo(firstCasilla.getIndex() - 15).getDato();
                }
                casillas.searchNodo(firstCasilla.getIndex() - 15).getDato().setValido(true);
                firstCasilla = estadoJuego.Obt_espacios_jugados().get(0);
            }

            if (!casillas.searchNodo(firstCasilla.getIndex() + 1).getDato().EsOcupado()) {
                casillas.searchNodo(firstCasilla.getIndex() + 1).getDato().setValido(true);
            } else {
                while (casillas.searchNodo(firstCasilla.getIndex() + 1).getDato().EsOcupado()) {
                    firstCasilla = casillas.searchNodo(firstCasilla.getIndex() + 1).getDato();
                }
                casillas.searchNodo(firstCasilla.getIndex() + 1).getDato().setValido(true);
                firstCasilla = estadoJuego.Obt_espacios_jugados().get(0);
            }

            if (!casillas.searchNodo(firstCasilla.getIndex() + 15).getDato().EsOcupado()) {
                casillas.searchNodo(firstCasilla.getIndex() + 15).getDato().setValido(true);
            } else {
                while (casillas.searchNodo(firstCasilla.getIndex() + 15).getDato().EsOcupado()) {
                    firstCasilla = casillas.searchNodo(firstCasilla.getIndex() + 15).getDato();
                }
                casillas.searchNodo(firstCasilla.getIndex() + 15).getDato().setValido(true);
                firstCasilla = estadoJuego.Obt_espacios_jugados().get(0);
            }

            if (!casillas.searchNodo(firstCasilla.getIndex() - 1).getDato().EsOcupado()
                    && !casillas.searchNodo(firstCasilla.getIndex() + 1).getDato().EsOcupado()) {
                estadoJuego.setOrientacion(Estado_Juego.Vertical);
            } else if (!casillas.searchNodo(firstCasilla.getIndex() + 15).getDato().EsOcupado()
                    && !casillas.searchNodo(firstCasilla.getIndex() - 15).getDato().EsOcupado()) {
                estadoJuego.setOrientacion(Estado_Juego.Horizontal);
            } else if (!casillas.searchNodo(firstCasilla.getIndex() - 15).getDato().EsOcupado()
                    && !casillas.searchNodo(firstCasilla.getIndex() - 1).getDato().EsOcupado()) {
                estadoJuego.setOrientacion(Estado_Juego.Horizontal);
            } else if (!casillas.searchNodo(firstCasilla.getIndex() - 15).getDato().EsOcupado()
                    && !casillas.searchNodo(firstCasilla.getIndex() + 1).getDato().EsOcupado()) {
                estadoJuego.setOrientacion(Estado_Juego.Vertical);
            } else if (!casillas.searchNodo(firstCasilla.getIndex() + 15).getDato().EsOcupado()
                    && !casillas.searchNodo(firstCasilla.getIndex() - 1).getDato().EsOcupado()) {
                estadoJuego.setOrientacion(Estado_Juego.Horizontal);
            } else if (!casillas.searchNodo(firstCasilla.getIndex() + 15).getDato().EsOcupado()
                    && !casillas.searchNodo(firstCasilla.getIndex() + 1).getDato().EsOcupado()) {
                estadoJuego.setOrientacion(Estado_Juego.Horizontal);
            }
        }

        if (estadoJuego.Obt_espacios_jugados().size() >= 2) {
            int lastIndex = estadoJuego.Obt_espacios_jugados().size() - 1;
            ArrayList<Casilla> casillasjugadas = estadoJuego.Obt_espacios_jugados();
            Collections.sort(casillasjugadas);
            int difference = Math.abs(casillasjugadas.get(0).getIndex() - casillasjugadas.get(1).getIndex());
            if (difference >= 15) {
                estadoJuego.setOrientacion(Estado_Juego.Vertical);
                casillas.searchNodo(casillasjugadas.get(0).getIndex() - 15).getDato().setValido(true);
                casillas.searchNodo(casillasjugadas.get(lastIndex).getIndex() + 15).getDato().setValido(true);
            }
            if (difference < 15) {
                estadoJuego.setOrientacion(Estado_Juego.Horizontal);
                casillas.searchNodo(casillasjugadas.get(0).getIndex() - 1).getDato().setValido(true);
                casillas.searchNodo(casillasjugadas.get(lastIndex).getIndex() + 1).getDato().setValido(true);
            }
        }

        for (int j =0; j<casillas.getSize();j++) {
            if (casillas.searchNodo(j).getDato().esValido()) {
                validCasillas.add(casillas.searchNodo(j).getDato());
            }
        }

        return validCasillas;

    }
}
