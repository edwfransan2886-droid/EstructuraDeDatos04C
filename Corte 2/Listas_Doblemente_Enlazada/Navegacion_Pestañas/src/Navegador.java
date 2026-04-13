public class Navegador {
    Pestaña cabeza;
    Pestaña cola;

    public Navegador() {
        this.cabeza = null;
        this.cola = null;
    }

    public void abrirPestaña(Pestaña p) {
        if (cabeza == null) {
            cabeza = p;
            cola = p;
        } else {
            cola.siguiente = p;
            p.anterior = cola;
            cola = p;
        }
    }

    public Pestaña cerrarPestanaActual(String url, Pestaña actual) {
        Pestaña temp = cabeza;

        while (temp != null) {
            if (temp.url.equals(url)) {

                if (temp == cabeza) {
                    cabeza = temp.siguiente;
                    if (cabeza != null) {
                        cabeza.anterior = null;
                    }
                }
                else if (temp == cola) {
                    cola = temp.anterior;
                    if (cola != null) {
                        cola.siguiente = null;
                    }
                }
                else {
                    temp.anterior.siguiente = temp.siguiente;
                    temp.siguiente.anterior = temp.anterior;
                }

                System.out.println("Pestana cerrada: " + temp.url);

                if (temp.anterior != null) {
                    return temp.anterior;
                } else {
                    return cabeza;
                }
            }
            temp = temp.siguiente;
        }

        System.out.println("No se encontro la pestaña");
        return actual;
    }

    public void mostrarPestañas() {
        if (cabeza == null) {
            System.out.println("No hay pestañas");
            return;
        }

        Pestaña temp = cabeza;
        while (temp != null) {
            System.out.println(temp.tituloPagina + " | " + temp.url + " | " + temp.horaApertura);
            temp = temp.siguiente;
        }
    }
}