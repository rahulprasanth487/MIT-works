import java.io.*;
import java.net.*;
import java.util.*;


public class DNSServer {
      public static void main(String[] args) throws Exception {
            DatagramSocket ss=new DatagramSocket(1390);
            InetAddress inet=InetAddress.getByName("localhost");
            byte buf[] = new byte[1024];
            DatagramPacket dp=new DatagramPacket(buf, 0,buf.length);
            String addr;
            ss.receive(dp);
            addr=new String(dp.getData());
            addr=addr.trim();
            System.out.println("Received = "+addr);



            String ip[] = { "192.165.1.1", "192.165.1.5", "192.168.1.1", "192.165.1.6", "192.165.1.2" };
            String name[] = { "www.google.com", "www.amazon.in", "localhost", "www.gmail.com", "www.youtube.com" };
            int flag=0;
            for(int i=0;i<ip.length;++i)
            {
                  if(addr.equals(ip[i]))
                  {
                        buf=name[i].getBytes();
                        flag=1;
                        break;
                  }
                  else if(addr.equals(name[i]))
                  {
                        buf=ip[i].getBytes();
                        flag=1;
                        break;
                  }
            }

            if(flag==0)
            {
                  buf="Not found".getBytes();
            }

            ss.send(new DatagramPacket(buf,buf.length,inet,1490));
            ss.close();
      }
}
