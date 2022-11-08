
import java.io.*;
import java.util.*;
import java.net.*;

public class Client {
    
    public static void main(String[] args) throws IOException {
        
        DatagramSocket s=new DatagramSocket(4150);
        InetAddress inet=InetAddress.getByName("localhost");
        byte[] buf=new byte[1024];
        DatagramPacket pack=new DatagramPacket(buf,buf.length);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Client running");
        while(true)
        {
            String str=new String(br.readLine());
            buf=str.getBytes();
            if(str.equals("STOP")){
            s.send(new DatagramPacket(buf,str.length(),inet,4160));
            break;
            }
            s.send(new DatagramPacket(buf,str.length(),inet,4160));v
            
            s.receive(pack);
            String st=new String(pack.getData(),0,pack.getLength());
            System.out.println("Server = "+st);
            
        }
        s.close();
    }
}
