
package org.sfsoft.servidorthreadsocket;

import java.io.IOException;

/**
 * Ejemplo de Servidor con soporte para m�ltiples cliente
 * utilizando hilos
 * 
 * @author Santiago Faci
 *
 */
public class ServidorThreadSocket {

	public static void main(String args[]) {
		
		Servidor servidor = new Servidor(7);
		ConexionCliente cliente = null;
		
		try {
			// Inicia el servidor
			servidor.conectar();
			// Mientras el servidor est� conectado aceptas nuevas
			// conexiones de clientes, que ser�n atendidas a trav�s
			// de hilos
			while (servidor.estaConectado()) {
				cliente = new ConexionCliente(servidor.escuchar());
				System.out.println("Nuevo cliente conectado");
				cliente.start();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
