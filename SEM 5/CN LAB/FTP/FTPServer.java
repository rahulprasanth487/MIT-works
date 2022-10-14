import java.net.*;
import java.io.*;
import java.util.*;
class FileTransferServer
{
      Socket soc;
      ServerSocket ss;
      DataInputStream din;
      DataOutputStream dout;
      String fname;
      File recfile;
      String filecon;
      FileTransferServer() throws Exception
      {
            ss=new ServerSocket(2788);
            soc=ss.accept();
            din=new DataInputStream(soc.getInputStream());
            dout=new DataOutputStream(soc.getOutputStream());
      }

      void sendfile() throws Exception
      {
            Scanner in=new Scanner(System.in);
            //dout.writeUTF("R");
            //System.out.println("File Name :");
            fname=din.readUTF();
            System.out.println("File name :"+fname);
            recfile=new File(fname);
            if(recfile.exists())
            {
                  dout.writeUTF("Y");
                  if((din.readUTF()).equalsIgnoreCase("Y"))
                  startsend();
            }
            else
            {
                  System.out.println(" Not Found");
                  dout.writeUTF("N");
            }
      }

      void startsend() throws Exception
      {
            String filecon;
            FileInputStream fos=new FileInputStream(recfile);
            int ch;
            System.out.println("Transferring File.... ");
            while(true)
            {
                  ch=fos.read();
                  //ch=Integer.parseInt(filecon);
                  if(ch!=-1)
                  {
                  dout.writeUTF(String.valueOf(ch));
                  }
                  else break;
            }
            System.out.println("File Transferring Completed .");
      }
}


public class FTPServer
{
      public static void main(String[] args) throws Exception
      {
            FileTransferServer fs=new FileTransferServer();
            fs.sendfile();
            System.out.println("Disconnected .");
      }
}
