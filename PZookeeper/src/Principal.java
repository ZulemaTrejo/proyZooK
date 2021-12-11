
public class Principal<E> {

	public static void main(String[] args) throws Exception {
		AcomodoArbol node = new AcomodoArbol();
		
        System.out.println("<<-- Lista de nodos -->>\n");
        
        // Agregar al final de los nodos
        node.agregarAlFinal(12);
        node.agregarAlFinal(15);
        node.agregarAlFinal(9);
        // Agregar in inicio de los nodos
        node.agregarAlInicio(41);
        node.agregarAlInicio(6);
        
        System.out.println("<<-- nodo -->>");
        node.noder();
        
        System.out.println("\n\n<<-- Tamaño -->");
        System.out.println(node.gettam());
        
        System.out.println("\n<<-- Obtener el valor del nodo en la posicion 3 -->>");
        System.out.println(node.getValor(3));
        
        System.out.println("\nInserta un nodo con valor 16 despues del 15");
        node.insertarPorReferencia(15, 16);
        node.noder();
        System.out.print(" | Tamaño: ");
        System.out.println(node.gettam());
        
        System.out.println("\n\nInserta un nodo con valor 44 en la posición 3");
        node.insrtarPorPosicion(3, 44);
        node.noder();
        System.out.print(" | Tamaño: ");
        System.out.println(node.gettam());
        
        System.out.println("\nActualiza el valor 12 del tercer nodo por 13");
        node.editarPorReferencia(12, 13);
        node.noder();
        System.out.print(" | Tamaño: ");
        System.out.println(node.gettam());
        
        System.out.println("\nActualiza el valor nodo en la posición 0 por 17");
        node.editarPorPosicion(0, 17);
        node.noder();
        System.out.print(" | Tamaño: ");
        System.out.println(node.gettam());
        
        System.out.println("\nElimina el nodo con el valor 41");
        node.removerPorReferencia(41);        
        node.noder();
        System.out.print(" | Tamaño: ");
        System.out.println(node.gettam());
        
        System.out.println("\nElimina el nodo en la posición 4");
        node.removerPorPosicion(4);        
        node.noder();
        System.out.print(" | Tamaño: ");
        System.out.println(node.gettam());
        
        System.out.println("\nConsulta si existe el valor 30");
        System.out.println(node.buscar(30));
        
        System.out.println("\nConsulta la posicion del valor 9");
        System.out.println(node.getPosicion(9));
        
        System.out.println("\nElimina el nodo");
        node.eliminar();
        
        System.out.println("\nConsulta si el nodo está vacio");
        System.out.println(node.esVacia());
        
        System.out.println("\n\n<<-- Fin dela lista de nodos-->>");
		
		
	}
}
