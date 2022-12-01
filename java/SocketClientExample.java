import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
* This class implements java socket client
* @author pankaj
*
*/
public class SocketClientExample 	
{

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException	
	{

		//get the localhost IP address, if server is running on some other IP, you need to use that
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Scanner myObj = new Scanner(System.in);


		while(true)
		{
			
			System.out.println("Es momento e jugar! a roca, papel, tijera haz tu eleccion. 1 = roca, 2 = papel, 3 = tijeras");

			//Strings

			String opciones = myObj.nextLine();
			int seleccion = Integer.parseInt(opciones);
			boolean first = true; 
			
			if (seleccion == 1)
			{
				System.out.println("Escogiste roca");
			}
			if (seleccion == 2)
			{
				System.out.println("Escogiste papel");
			}
			if (seleccion == 3)
			{
				System.out.println("Escogiste tijeras");
			}
			//establish socket connection to server
			socket = new Socket(host.getHostName(), 9876);
			//write to socket using ObjectOutputStream
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("Esperando al enemigo");
			oos.writeObject(opciones);

			//read the server response message
			ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println("Message: " + message);

			first = false;
			ois.close();
			oos.close();

			
		}
	}
}