
public class AcomodoArbol {
	// Puntero que indica el inicio de la lista o conocida tambien
    // como cabeza de la lista.
    private ZookeeperNode inicio;
    // Variable para registrar el tamaño de la lista.
    private int tam;
    /**
     * Constructor por defecto.
     */
    public void Lista(){
        inicio = null;
        tam = 0;
    }
    /**
     * Consulta si la lista esta vacia.
     * true si el primer ZookeeperNode (inicio), no apunta a otro ZookeeperNode.
     */
    public boolean esVacia(){
        return inicio == null;
    }
    /**
     * Consulta cuantos elementos (ZookeeperNodes) tiene la lista.
     * numero entero entre [0,n] donde n es el numero de elementos
     * que contenga la lista.
     */
    public int gettam(){
        return tam;
    }
    /**
     * Agrega un nuevo ZookeeperNode al final de la lista.
     * valor a agregar.
     */
    public  void agregarAlFinal(int valor){
        // Define un nuevo ZookeeperNode.
        ZookeeperNode nuevo = new ZookeeperNode();
        // Agrega al valor al ZookeeperNode.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo ZookeeperNode.
            inicio = nuevo;
        // Caso contrario recorre la lista hasta llegar al ultimo ZookeeperNode
        //y agrega el nuevo.
        } else{
            // Crea ua copia de la lista.
            Object aux = inicio;
            // Recorre la lista hasta llegar al ultimo ZookeeperNode.
            while(((ZookeeperNode) aux).getSiguiente() != null){
                aux = ((ZookeeperNode) aux).getSiguiente();
            }
            // Agrega el nuevo ZookeeperNode al final de la lista.
            ((ZookeeperNode) aux).setSiguiente(nuevo);
        }
        // Incrementa el contador de tamaño de la lista
        tam++;
    }
    /**
     * Agrega un nuevo ZookeeperNode al inicio de la lista.
     * valor a agregar.
     */   
    public  void agregarAlInicio(int valor){
        // Define un nuevo ZookeeperNode.
        ZookeeperNode nuevo = new ZookeeperNode();
        // Agrega al valor al ZookeeperNode.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo ZookeeperNode.
            inicio = nuevo;
        // Caso contrario va agregando los ZookeeperNodes al inicio de la lista.
        } else{
            // Une el nuevo ZookeeperNode con la lista existente.
            nuevo.setSiguiente(inicio);
            // Renombra al nuevo ZookeeperNode como el inicio de la lista.
            inicio = nuevo;
        }
        // Incrementa el contador de tamaño de la lista.
        tam++;
    }
    /**
     * Inserta un nuevo ZookeeperNode despues de otro, ubicado por el valor que contiene.
     * referencia valor del ZookeeperNode anterios al nuevo ZookeeperNode a insertar.
     * valor del ZookeeperNode a insertar.
     */
    public void insertarPorReferencia(int referencia, int valor){
        // Define un nuevo ZookeeperNode.
        ZookeeperNode nuevo = new ZookeeperNode();
        // Agrega al valor al ZookeeperNode.
        nuevo.setValor(valor);
        // Verifica si la lista contiene elementos
        if (!esVacia()) {
            // Consulta si el valor existe en la lista.
            if (buscar(referencia)) {
                // Crea ua copia de la lista.
                ZookeeperNode aux = inicio;
                // Recorre la lista hasta llegar al ZookeeperNode de referencia.
                while (aux.getValor() != referencia) {
                    aux = (ZookeeperNode) aux.getSiguiente();
                }
                // Crea un respaldo de la continuación de la lista.
                ZookeeperNode siguiente = (ZookeeperNode) aux.getSiguiente();
                // Enlaza el nuevo ZookeeperNode despues del ZookeeperNode de referencia.
                aux.setSiguiente(nuevo);
                // Une la continuacion de la lista al nuevo ZookeeperNode.
                nuevo.setSiguiente(siguiente);
                
                // Incrementa el contador de tamaño de la lista.
                tam++;
            }
        }
    }
    /**
     * Inserta un nuevo ZookeeperNode despues en una posición determinada.
     * @param posicion en la cual se va a insertar el nuevo ZookeeperNode.
     * @param valor valor del nuevo ZookeeperNode de la lista.
     */
    public void insrtarPorPosicion(int posicion, int valor){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y <= que el numero de elementos del la lista.
        if(posicion>=0 && posicion<=tam){
            ZookeeperNode nuevo = new ZookeeperNode();
            nuevo.setValor(valor);
            // Consulta si el nuevo ZookeeperNode a ingresar va al inicio de la lista.
            if(posicion == 0){
                // Inserta el nuevo ZookeeperNode al inicio de la lista.
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            }
            else{
                // Si el ZookeeperNode a inserta va al final de la lista.
                if(posicion == tam){
                    ZookeeperNode aux = inicio;
                    // Recorre la lista hasta llegar al ultimo ZookeeperNode.
                    while(aux.getSiguiente() != null){
                        aux = (ZookeeperNode) aux.getSiguiente();
                    }
                    // Inserta el nuevo ZookeeperNode despues de del ultimo.
                    aux.setSiguiente(nuevo);              
                }
                else{
                    // Si el ZookeeperNode a insertar va en el medio de la lista.
                    ZookeeperNode aux = inicio;
                    // Recorre la lista hasta llegar al ZookeeperNode anterior
                    // a la posicion en la cual se insertara el nuevo ZookeeperNode.
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = (ZookeeperNode) aux.getSiguiente();
                    }
                    // Guarda el ZookeeperNode siguiente al ZookeeperNode en la posición
                    // en la cual va a insertar el nevo ZookeeperNode.
                    ZookeeperNode siguiente = (ZookeeperNode) aux.getSiguiente();
                    // Inserta el nuevo ZookeeperNode en la posición indicada.
                    aux.setSiguiente(nuevo);
                    // Une el nuevo ZookeeperNode con el resto de la lista.
                    nuevo.setSiguiente(siguiente);
                }
            }
            // Incrementa el contador de tamaño de la lista.
            tam++;
        }
    }
    /**
     * Obtiene el valor de un ZookeeperNode en una determinada posición.
     * posicion del ZookeeperNode que se desea obtener su valor.
     * return un numero entero entre [0,n-1] n = numero de ZookeeperNodes de la lista.
     * throws Exception
     */
    public int getValor(int posicion) throws Exception{
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if(posicion>=0 && posicion<tam){
            // Consulta si la posicion es el inicio de la lista.
            if (posicion == 0) {
                // Retorna el valor del inicio de la lista.
                return inicio.getValor();
            }else{
                // Crea una copia de la lista.
                ZookeeperNode aux = inicio;
                // Recorre la lista hasta la posición ingresada.
                for (int i = 0; i < posicion; i++) {
                    aux = (ZookeeperNode) aux.getSiguiente();
                }
                // Retorna el valor del ZookeeperNode.
                return aux.getValor();
            }
        // Crea una excepción de Posicion inexistente en la lista.
        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }
    /**
     * Busca si existe un valor en la lista.
     * referencia valor a buscar.
     * regresa un true si existe el valor en la lista.
     */
    public boolean buscar(int referencia){
        // Crea una copia de la lista.
        ZookeeperNode aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while(aux != null && encontrado != true){
            // Consulta si el valor del ZookeeperNode es igual al de referencia.
            if (referencia == aux.getValor()){
                // Canbia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avansa al siguiente. ZookeeperNode.
                aux = (ZookeeperNode) aux.getSiguiente();
            }
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }
    /**
     * Consulta la posición de un elemento en la lista
     *  referencia valor del ZookeeperNode el cual se desea saber la posición.
     * retorna un valor entero entre [0,n] que indica la posición del ZookeeperNode. 
     * @throws Exception 
     */
    public int getPosicion(int referencia) throws Exception{
        // Consulta si el valor existe en la lista.
        if (buscar(referencia)) {
            // Crea una copia de la lista.
            ZookeeperNode aux = inicio;
            // COntado para almacenar la posición del ZookeeperNode.
            int cont = 0;
            // Recoore la lista hasta llegar al ZookeeperNode de referencia.
            while(referencia != aux.getValor()){
                // Incrementa el contador.
                cont ++;
                // Avansa al siguiente. ZookeeperNode.
                aux = (ZookeeperNode) aux.getSiguiente();
            }
            // Retorna el valor del contador.
            return cont;
        // Crea una excepción de Valor inexistente en la lista.
        } else {
            throw new Exception("Valor inexistente en la lista.");
        }
    }
    /**
     * Actualiza el valor de un ZookeeperNode que se encuentre en la lista ubicado
     * por un valor de referencia.
     *  referencia valor del ZookeeperNode el cual se desea actualizar.
     *  valor nuevo valor para el ZookeeperNode.
     */
    public void editarPorReferencia(int referencia, int valor){
        // Consulta si el valor existe en la lista.
        if (buscar(referencia)) {
            // Crea ua copia de la lista.
            ZookeeperNode aux = inicio;
            // Recorre la lista hasta llegar al ZookeeperNode de referencia.
            while(aux.getValor() != referencia){
                aux = (ZookeeperNode) aux.getSiguiente();
            }
            // Actualizamos el valor del ZookeeperNode
            aux.setValor(valor);
        }
    }
    /**
     * Actualiza el valor de un ZookeeperNode que se encuentre en la lista ubicado
     * por su posición.
     * posicion en la cual se encuentra el ZookeeperNode a actualizar.
     *  valor nuevo valor para el ZookeeperNode.
     */
    public void editarPorPosicion(int posicion , int valor){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if(posicion>=0 && posicion<tam){
            // Consulta si el ZookeeperNode a eliminar es el primero.
            if(posicion == 0){
                // Alctualiza el valor delprimer ZookeeperNode.
                inicio.setValor(valor);
            }
            else{
                // En caso que el ZookeeperNode a eliminar este por el medio 
                // o sea el ultimo
                ZookeeperNode aux = inicio;
                // Recorre la lista hasta lleger al ZookeeperNode anterior al eliminar.
                for (int i = 0; i < posicion; i++) {
                    aux = (ZookeeperNode) aux.getSiguiente();
                }
                // Alctualiza el valor del ZookeeperNode.
                aux.setValor(valor);
            }
        }
    }
    /**
     * Elimina un ZookeeperNode que se encuentre en la lista ubicado
     * por un valor de referencia.
     * referencia valor del ZookeeperNode que se desea eliminar.
     */
    public void removerPorReferencia(int referencia){
        // Consulta si el valor de referencia existe en la lista.
        if (buscar(referencia)) {
            // Consulta si el ZookeeperNode a eliminar es el pirmero
            if (inicio.getValor() == referencia) {
                // El primer ZookeeperNode apunta al siguiente.
                inicio = (ZookeeperNode) inicio.getSiguiente();
            } else{
                // Crea ua copia de la lista.
                ZookeeperNode aux = inicio;
                // Recorre la lista hasta llegar al ZookeeperNode anterior 
                // al de referencia.
                while(((ZookeeperNode) aux.getSiguiente()).getValor() != referencia){
                    aux = (ZookeeperNode) aux.getSiguiente();
                }
                // Guarda el ZookeeperNode siguiente del ZookeeperNode a eliminar.
                ZookeeperNode siguiente = (ZookeeperNode) ((ZookeeperNode) aux.getSiguiente()).getSiguiente();
                // Enlaza el ZookeeperNode anterior al de eliminar con el 
                // sguiente despues de el.
                aux.setSiguiente(siguiente);  
            }
            // Disminuye el contador de tamaño de la lista.
            tam--;
        }
    }
    /**
     * Elimina un ZookeeperNode que se encuentre en la lista ubicado
     * por su posición.
     * posicion en la cual se encuentra el ZookeeperNode a eliminar.
     */
    public void removerPorPosicion(int posicion){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if(posicion>=0 && posicion<tam){
            // Consulta si el ZookeeperNode a eliminar es el primero
            if(posicion == 0){
                // Elimina el primer ZookeeperNode apuntando al siguinte.
                inicio = (ZookeeperNode) inicio.getSiguiente();
            }
            // En caso que el ZookeeperNode a eliminar este por el medio 
            // o sea el ultimo
            else{
                // Crea una copia de la lista.
                ZookeeperNode aux = inicio;
                // Recorre la lista hasta lleger al ZookeeperNode anterior al eliminar.
                for (int i = 0; i < posicion-1; i++) {
                    aux = (ZookeeperNode) aux.getSiguiente();
                }
                // Guarda el ZookeeperNode siguiente al ZookeeperNode a eliminar.
                ZookeeperNode siguiente = (ZookeeperNode) aux.getSiguiente();
                // Elimina la referencia del ZookeeperNode apuntando al ZookeeperNode siguiente.
                aux.setSiguiente(siguiente.getSiguiente());
            }
            // Disminuye el contador de tamaño de la lista.
            tam--;
        }
    }
    /**
     * Elimina la lista
     */
    public void eliminar(){
        // Elimina el valor y la referencia a los demas ZookeeperNodes.
        inicio = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tam = 0;
    }
    /**
     * Mustra en pantalla los elementos de la lista.
     */
    public void listar(){
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            ZookeeperNode aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while(aux != null){
                // Imprime en pantalla el valor del ZookeeperNode.
                System.out.print(i + ".[ " + aux.getValor() + " ]" + " ->  ");
                // Avanza al siguiente ZookeeperNode.
                aux = (ZookeeperNode) aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }
	public void noder() {
		// TODO Auto-generated method stub
		
	}
	
	
}
