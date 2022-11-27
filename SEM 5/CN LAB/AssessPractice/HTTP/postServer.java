package AssessPractice.HTTP;

import java.io.*;
import java.net.*;


public class postServer {
      static String sendPOST(String URL) throws IOException
      {
            URL url=new URL(URL);
            HttpURLConnection uc=(HttpURLConnection) url.openConnection();
            uc.setRequestMethod("POST");
            uc.setRequestProperty("User-Agent", "Google Chrome");
            uc.setDoOutput(true);
            System.out.println("Response code = "+uc.getResponseCode());

            if(uc.getResponseCode()==HttpURLConnection.HTTP_OK)
            {
                  StringBuffer sb = new StringBuffer();
                  String str;
                  BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                  while ((str = br.readLine()) != null) {
                        sb.append(str);
                  }
                  return sb.toString();
            }
            else {
            System.out.println("POST request not worked");
            return (null);
        }
    

      }

      public static void main(String[] args) throws IOException {
            ServerSocket ss=new ServerSocket(6789);
            while(true)
            {
                  Socket s=ss.accept();
                  System.out.println("Connection established");
                  BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                  DataOutputStream dp=new DataOutputStream(s.getOutputStream());
                  String inp=br.readLine()+"\n";
                  dp.writeBytes(sendPOST(inp)+"\n");
                  System.out.println(inp);
                  break;

            }
      }
}
