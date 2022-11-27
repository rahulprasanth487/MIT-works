

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException{
        Socket s=new Socket(InetAddress.getByName("localhost"),5000);
        FileOutputStream fout=new FileOutputStream("NEW/copied_image.jpg");
        BufferedOutputStream bout=new BufferedOutputStream(fout);
        InputStream in=s.getInputStream();
        
        byte[] contents=new byte[10000];
        int byteread=0;
        
        while((byteread=in.read(contents))!=-1)
            bout.write(contents,0,byteread);
        
        bout.flush();
        s.close();
        System.out.println("File Saved....");
    }
}
