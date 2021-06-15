package tcp;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class atiendeCliente {
	
	comunHilos.anadir(socket);

	DataInputStream entrada = new DataInputStream(socket.getInputStream());

	while(true) {
	String mensaje = entrada.readUTF();
	System.out.println ("Ha llegado el mensaje" + mensaje);


	while(true) {
	Socket socket = servidor.accept();
	AtiendeCliente atiendeCliente = new AtiendeCliente(socket, comunHilos);
	atiendeCliente.start();
	System.out.println("");


}
}