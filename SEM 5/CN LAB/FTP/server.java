

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss=new ServerSocket(5000);
        Socket s=ss.accept();
        InetAddress iadd=InetAddress.getByName("localhost");
        File file=new File("p2.jpg");
        FileInputStream fin=new FileInputStream(file);
        BufferedInputStream bin=new BufferedInputStream(fin);
        OutputStream out=s.getOutputStream();
        byte[] contents;
        long fileLength=file.length();
        long current=0;
        long start=System.nanoTime();
        while(current!=fileLength){
            int size=10000;
            if(fileLength-current >=size){
                current+=size;
            }
            else{
                size=(int)(fileLength-current);
                current=fileLength;
            }
            contents=new byte[size];
            bin.read(contents,0,size);
            out.write(contents);
            System.out.println("Sending file..."+((current*100)/fileLength)+"% complete");
        }
        out.flush();
        ss.close();
        s.close();
        System.out.println("File Sent....");
    }
}
