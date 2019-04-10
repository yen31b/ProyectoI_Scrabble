public class Nodo {
    private int valor;
    private Nodo siguiente;
    private Nodo abajo;

    public Nodo() {
        this.valor = 0;
        this.siguiente = null;
        this.abajo = null;
    }

    public void imprimirNodo() {
        System.out.println(valor + "");
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAbajo() {
        return abajo;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }
}
