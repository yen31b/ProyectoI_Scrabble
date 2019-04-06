public class Matriz<T> {

    public Nodo<T> primerNodo = null;

    public void insertar(Nodo<T> nodo) {
        nodo.setSiguiente(primerNodo);
        primerNodo = nodo;
    }

}
