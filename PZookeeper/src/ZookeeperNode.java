import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.Marshaller.Listener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

public class ZookeeperNode<Nodo> {
		// Variable en la cual se va a guardar el valor.
	    private int valor;
	    // Variable para enlazar los nodos.
	    private Nodo siguiente;
	    /**
	     * Constructor que inicializamos el valor de las variables.
	     */
	    public void Nodo(){
	        this.valor = 0;
	        this.siguiente = null;
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
	}
		     


