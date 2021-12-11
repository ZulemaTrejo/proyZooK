Primero crea un nodo, se crea un nodo de secuencia temporal 
y elimina el nodo después de ejecutar el programa.
Cada vez que crea un nodo, el programa debe checar su tamaño, 
por lo que primero debe ordenar los nodos.
Puede checar que valor tiene un nodo en cierta posicion y obtener 
el tamaño de un nodo en cierta posición,elimina y consulta si existe. 

Ejemplo de los acesores
public boolean create(String path, bytes[] data) {
		if (this.exists(path)) return false;
	}
	
	public boolean exists(String path, Boolean watch) {
		
	}
		
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZookeeperNode node = new ZookeeperNode();
		node.create(“myapplication/directory/path”, null);
		node.exists(“myapplication/directory/path”, false); // => returns true
		node.exists(“myapplication/directory/otherpath”, false); // => returns false	

	}

