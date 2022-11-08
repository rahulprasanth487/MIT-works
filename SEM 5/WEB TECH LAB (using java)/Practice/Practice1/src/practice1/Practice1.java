import java.io.*;
import java.util.*;
import java.net.*;

public class Practice1 {
    
    public static void main(String[] args) throws IOException {
        
        DatagramSocket s=new DatagramSocket(4160);
        byte[] buf=new byte[1024];
        DatagramPacket pack=new DatagramPacket(buf,buf.length);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        InetAddress inet=InetAddress.getLocalHost();
        System.out.println("Server is Running...");
        while(true)
        {
            s.receive(pack);
            String y=new String(pack.getData(),0,pack.getLength());
            if(y.equals("STOP"))
            {
                System.out.println("Terminated");
                break;
            }
            System.out.println("Client = "+y);
            String x=new String(br.readLine());
            buf=x.getBytes();
            s.send(new DatagramPacket(buf,x.length(),inet,4150));
        }
        s.close();
    }
}
