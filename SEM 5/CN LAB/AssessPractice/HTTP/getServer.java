package AssessPractice.HTTP;

import java.io.*;
import java.net.*;

public class getServer {

      static String sendURL(String URL) throws IOException
      {
            URL urlObj=new URL(URL);
            HttpURLConnection hpcon=(HttpURLConnection) urlObj.openConnection();
            hpcon.setRequestMethod("GET");
            hpcon.setRequestProperty("User-Agent", "Google Chrome");

            System.out.println("Response Code : "+hpcon.getResponseCode());
            // if(hpcon.getResponseCode()==HttpURLConnection.HTTP_OK)
            // {
            //       StringBuffer sb = new StringBuffer();
            //       BufferedReader br = new BufferedReader(new InputStreamReader(hpcon.getInputStream()));

            //       String inp;
            //       while ((inp = br.readLine()) != null) {
            //             sb.append(inp);
            //       }
            //       System.out.println("Done");

            //       return sb.toString();
            // }
            // else {
            // System.out.println("GET request not worked");
            // return (null);

            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new
            InputStreamReader(hpcon.getInputStream()));

            String inp;
            while ((inp = br.readLine()) != null) {
            sb.append(inp);
            }
            System.out.println("Done");

            return sb.toString();
        

            
      }

      public static void main(String[] args) throws IOException{
            ServerSocket ss=new ServerSocket(8080);
            while(true)
            {
                  Socket s=ss.accept();
                  System.out.println("Connection established");
                  BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                  DataOutputStream dp=new DataOutputStream(s.getOutputStream());
                  String r=br.readLine()+'\n';
                  String n_r=r;
                  System.out.println("Received URL = "+n_r);
                  dp.writeBytes(sendURL(n_r)+"\n");
                  System.out.print("DONE");
                  break;
            }
      }
}
