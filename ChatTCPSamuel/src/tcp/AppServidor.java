package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Se debe lanzar primero tcp.AppServidor y depu?s tcp.AppCliente Cuando reciba
 * el primer mensaje devolver? el mismo mensaje a?adiendole texto delante.
 */
public class AppServidor {
	static final int PUERTO = 4444;

	public static void main(String[] args) throws IOException {
		// Creamos el servidor
		ServerSocket servidor = new ServerSocket(PUERTO);
		System.out.println("Escuchando en el puerto " + PUERTO + " ...");

		// Esperamos a la primera petici?n de conexi?n que venga y la aceptamos
		Socket socketTcp = servidor.accept();

		// Obtenemos los canales de entrada de datos y de salida
		DataInputStream entrada = new DataInputStream(socketTcp.getInputStream());
		DataOutputStream salida = new DataOutputStream(socketTcp.getOutputStream());

		// Leemos un mensaje y devolvemos el mismo mensaje
		String mensajeDelCliente = entrada.readUTF();
		System.out.println("Recibido mensaje del cliente: " + mensajeDelCliente);
		salida.writeUTF("T? si que eres " + mensajeDelCliente);

		// Cerramos conexi?n
		socketTcp.close();
		servidor.close();
	}
}
