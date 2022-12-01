import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Random;

public class SocketServerExample 
{
	//static ServerSocket variable
	private static ServerSocket server;
 	//socket server port on which it will listen
	private static int port = 9876;

	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		
	
		{
			int r, p, t;

			r = 1;
			p = 2; 
			t = 3;
			//create the socket server object
			server = new ServerSocket(port);
			Random random = new Random();

			//keep listens indefinitely until receives 'exit' call or program terminates
			while(true)
			{
				System.out.println("Esperando la respuesta del jugador");
				//creating socket and waiting for client connection
				Socket socket = server.accept();

				//read from socket to ObjectInputStream object
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

				//create ObjectOutputStream object
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				String message = (String) ois.readObject();
				int player = (int)(Math.random()*3+1);
				System.out.println(player);
				int msg = Integer.parseInt(message); 

				//Roca

				if (msg == 1 && player == 1)
				{
					oos.writeObject("roca vs roca \n empate");
					System.out.println("Elegiste roca");
				}
				if (msg == 1 && player == 2)
				{
					oos.writeObject("roca vs papel \n perdiste");
					System.out.println("Elegiste a la roca");
				}
				if (msg == 1 && player == 3)
				{
					oos.writeObject("roca vs tijera \n Ganaste");
					System.out.println("Elegiste roca");
				}

				//Papel

				if (msg == 2 &&  player == 2)
				{
					oos.writeObject("papel vs papel \n empate");
					System.out.println("Elegiste papel");
				
				if (msg == 2 && player == 1) 
				{
			 		oos.writeObject("papel vs tijera \n perdiste");
					System.out.println("Elegiste papel");
				}
				if (msg == 2 && player == 3)
				{
					oos.writeObject("papel vs roca \n Ganaste");
					System.out.println("Elegiste papel");
				}

				//Tijeras

				if (msg == 3 && player == 3)
				{
					oos.writeObject("tijeras vs tijeras \n empate");
					System.out.println("Elegiste tijeras");
				}
				if (msg == 3 && player == 1)
				{
					oos.writeObject("tijeras vs roca \n Perdiste");
					System.out.println("Elegiste tijeras");
				}
				if (msg == 3 && player == 2)
				{
					oos.writeObject("tijeras vs papel \n Ganaste");
					System.out.println("Elegiste tijeras");
				}

				//close resources
				ois.close();
				oos.close();
				socket.close();
				//terminate the server if client sends exit request;
			}
		}
	}
}
}