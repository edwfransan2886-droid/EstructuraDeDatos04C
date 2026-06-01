public class ArbolJugadores {

    private Jugador raiz;

    public ArbolJugadores() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Jugador insertar(Jugador nodo, int elo, String nombreUsuario,
                             String pais, int partidasJugadas) {

        if (nodo == null)
            return new Jugador(elo, nombreUsuario, pais, partidasJugadas);

        if (elo < nodo.elo)
            nodo.izquierdo = insertar(nodo.izquierdo, elo, nombreUsuario, pais, partidasJugadas);

        else if (elo > nodo.elo)
            nodo.derecho = insertar(nodo.derecho, elo, nombreUsuario, pais, partidasJugadas);

        else
            System.out.println("Ya existe un jugador con ELO " + elo);

        return nodo;
    }

    public void insertar(int elo, String nombreUsuario,String pais, int partidasJugadas) {

        raiz = insertar(raiz, elo, nombreUsuario, pais, partidasJugadas);
    }


    private Jugador buscar(Jugador nodo, int elo) {

        if (nodo == null)
            return null;

        if (elo == nodo.elo)
            return nodo;

        if (elo < nodo.elo)
            return buscar(nodo.izquierdo, elo);
        else
            return buscar(nodo.derecho, elo);
    }

    public Jugador buscar(int elo) {
        return buscar(raiz, elo);
    }

    private void inOrden(Jugador nodo) {

        if (nodo != null) {

            inOrden(nodo.izquierdo);

            System.out.println(nodo);

            inOrden(nodo.derecho);
        }
    }

    public void inOrden() {

        if (isEmpty()) {
            System.out.println("Arbol vacio");
            return;
        }

        System.out.println("=== RANKING ELO ===");
        inOrden(raiz);
    }

    private void listarEnRango(Jugador nodo, int eloMin, int eloMax) {

        if (nodo == null)
            return;

        if (nodo.elo < eloMin) {

            listarEnRango(nodo.derecho, eloMin, eloMax);

        } else if (nodo.elo > eloMax) {

            listarEnRango(nodo.izquierdo, eloMin, eloMax);

        } else {

            listarEnRango(nodo.izquierdo, eloMin, eloMax);

            System.out.println(nodo);

            listarEnRango(nodo.derecho, eloMin, eloMax);
        }
    }

    public void listarEnRango(int eloMin, int eloMax) {

        if (isEmpty()) {
            System.out.println("Arbol vacio");
            return;
        }

        System.out.println("=== JUGADORES CLASIFICADOS ===");

        listarEnRango(raiz, eloMin, eloMax);
    }
}
