package AssessPractice.HTTP;

import java.net.*;
import java.io.*;

public class postClient {
      public static void main(String[] args) throws IOException {
            Socket s=new Socket("localhost",6789);
            BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br2=new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream dp=new DataOutputStream(s.getOutputStream());

            System.out.println("Enter the URL = ");
            String str=br1.readLine();
            dp.writeBytes(str+'\n');


            System.out.println("RESPOSE : "+br2.readLine());
      }
}
