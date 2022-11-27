package AssessPractice.HTTP;

import java.net.*;
import java.io.*;

public class getClient {
      public static void main(String[] args) throws IOException {
            Socket st=new Socket("localhost",8080);
            BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br2=new BufferedReader(new InputStreamReader(st.getInputStream()));
            DataOutputStream dp=new DataOutputStream(st.getOutputStream());
            
            String x;
            System.out.print("Enter the URL =");
            x=br1.readLine();       
            dp.writeBytes(x+'\n');       
            System.out.println("RESPONSE = "+br2.readLine());
            st.close();
      }
}
