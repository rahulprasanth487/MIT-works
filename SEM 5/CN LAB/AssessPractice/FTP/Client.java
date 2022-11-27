import java.io.*;
import java.net.*;
public class Client
{
      public static void main(String[] args) throws Exception {
            Socket ss=new Socket(InetAddress.getByName("localhost"),5000);
            FileOutputStream fout=new FileOutputStream("NEW/copied.jpg");
            BufferedOutputStream br=new BufferedOutputStream(fout);
            InputStream inp=ss.getInputStream();

            byte buf[]=new byte[10000];
            int byteread=0;
            while((byteread=inp.read(buf))!=-1)
            {
                  br.write(buf,0,byteread);
            }

            br.flush();
            br.close();
            ss.close();
      }
}