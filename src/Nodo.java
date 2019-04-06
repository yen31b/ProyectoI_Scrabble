public class Nodo <T> {
    public T valor;
    public Nodo<T> siguiente;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
