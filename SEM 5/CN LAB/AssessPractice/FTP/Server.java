import java.net.*;
import java.io.*;

public class Server {
      public static void main(String[] args) throws IOException {
            ServerSocket ss=new ServerSocket(5000);
            Socket s=ss.accept();
            File f=new File("p2.jpg");
            FileInputStream file=new FileInputStream(f);
            BufferedInputStream br=new BufferedInputStream(file);
            OutputStream out=s.getOutputStream();
            //InetAddress inet=InetAddress.getByName("localhost");
            byte buf[];
            long current=0;
            long fileSize=f.length();
            //long start = System.nanoTime();

            while(current!=fileSize)
            {
                  System.out.println("Start sending");
                  int size=10000;
                  if(fileSize-current >= size)
                  {
                        current+=size;
                  }
                  else
                  {
                        size=(int)(fileSize-current);
                        current=fileSize;
                  }

                  buf=new byte[size];
                  br.read(buf,0,size);
                  out.write(buf);
                  System.out.println("FILES SENDING..");
            }

            out.flush();
            System.out.println("File sent");
            br.close();
            ss.close();
            s.close();

      }
}
