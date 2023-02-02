/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Servidor {

    public static void main(String[] args) throws ParseException {
   final int PUERTO = 5000;
        byte[] buffer = new byte[1024];
 
        try {
              String Jugador="";
            //-------Tablero de inicio al cargar el servidor
            
          new Logica().mostrarTablerosIniciales();
            System.out.println("Iniciado el servidor UDP");
            System.out.println("");
            System.out.println("Esperando cliente envíe respuesta del servidor");
            
            //Creacion del socket
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
 
            //Siempre atendera peticiones
            while (true) {
                 
                //Preparo la respuesta
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                 
                //Recibo el datagrama
                socketUDP.receive(peticion);
                System.out.println("Recibo la informacion del cliente que es la matriz de tiros para el juego");
                 
                //Convierto lo recibido y mostrar el mensaje
                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);
           
        Gson gson = new Gson();
          
          System.out.println("COMIENZAN LOS 5 TIROS DEL LOS JUGADORE 1 Y 2 ");
          System.out.println();
            JsonReader reader = new JsonReader(new StringReader(mensaje));
            reader.setLenient(true);
              ArrayList<Tiros> list = gson.fromJson(reader, ArrayList.class);
          
                if (list.size()>0) {
                    
                        int i = (int) (Math.random()*5+1);
                        
                         int j = (int) (Math.random()*2+1);
                       
                         if (j==1) {
                              Jugador="1";
                             
                    } else if  (j==2) {
                                   Jugador="2";
                             }
                    else 
                        Jugador="2";
                         
                        int valor=0;
                    
                        if (i==1)
                            valor=25;
                        else if(i==2)
                        valor=25;
                        else if(i==3)
                        valor=30;
                           else if(i==4)
                        valor=-15;
                        else if(i==5)
                        valor=45;
                        else if(i==5)
                        valor=15;
                    
                    
                    //Tiro 1
                    new Logica().TirosJuego();
                    System.out.println("TIRO 1 Jugador 1 "+valor);
                    new Logica().TirosJuego();
                    System.out.println("TIRO 1 Jugador 2 "+(valor-5));
                    //Tiro 2
                       
                      new Logica().TirosJuego();
                     System.out.println("TIRO 2 Jugador 1 "+valor);
                           new Logica().TirosJuego();
                     System.out.println("TIRO 2 Jugador 2 "+(valor-5));
                   
                   //tiro 3
                       new Logica().TirosJuego();
                     System.out.println("TIRO 3 Jugador 1 "+valor);
                     new Logica().TirosJuego();
                     System.out.println("TIRO 3 Jugador 2 "+(valor+i));
                       
                   //tiro 4
                   new Logica().TirosJuego();
                    System.out.println("TIRO 4 Jugador 1 "+valor);
                    new Logica().TirosJuego();
                     System.out.println("TIRO 4 Jugador 2 "+(valor-i));
                       
                   new Logica().TirosJuego();
                    System.out.println("TIRO 5 Jugador 1 "+(valor+4));
                    new Logica().TirosJuego();
                     System.out.println("TIRO 5 Jugador 2 "+(valor-i));
                }
            
                   
                      
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();
 
                mensaje = "";
                buffer = mensaje.getBytes();
 
                //creo el datagrama
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
 
                //Envio la información
                System.out.println("El juego a finalizado ganador el jugador "+Jugador);
                
               
                
                socketUDP.send(respuesta);
                 
            }
            
           
 
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("Fin");
         
          System.exit(0);
    }
}
