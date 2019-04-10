public class Lista {

    private int tamaño = 14;
    private Nodo actual;

    public Lista() {
        actual = null;
    }

    public boolean estaVacio() {
        return (actual == null);
    }


    public void insertar(int tamaño) {
        this.tamaño = tamaño;
        for(int i = 1; i <= tamaño; i++) {
            Nodo nuevoNodo = new Nodo();
            if(estaVacio()){
                actual = nuevoNodo;
            }else if(actual.getSiguiente() == null){
                actual.setSiguiente(nuevoNodo);
                nuevoNodo.setSiguiente(actual);
                actual = nuevoNodo;
            }else{
                nuevoNodo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevoNodo);
                actual = nuevoNodo;
            }
            if(!(actual.getSiguiente() == null)) {
                actual = actual.getSiguiente();
            }
        }
    }


    public void imprimir(){
        for(int i = 1; i <= tamaño; i++) {
            actual.imprimirNodo();
            if(!(actual.getSiguiente() == null)) {
                actual = actual.getSiguiente();
            }
        }
    }

}
