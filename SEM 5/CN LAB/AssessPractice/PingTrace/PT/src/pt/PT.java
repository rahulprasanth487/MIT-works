import java.io.*;
import java.util.*;
import java.net.*;


public class PT {

    void Func(ArrayList<String> arr) throws UnknownHostException, IOException
    {
        ProcessBuilder pb=new ProcessBuilder(arr);
        Process process=pb.start();
        
        BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
        String temp;
        System.out.println("IT IS REACHABLE");
        while((temp=br.readLine())!=null)
        {
            System.out.println(temp);
        }
    }
    
    public static void main(String[] args) throws UnknownHostException,IOException {
        String ip="192.168.132.1";
        
        PT pt = new PT();
        
        ArrayList<String> arr=new ArrayList<>();
        arr.add("ping");
        arr.add(ip);
        
        pt.Func(arr);
        System.out.println("\n\nTRACE ROUTE --->>");
        arr.clear();
        arr.add("tracert");
        arr.add(ip);
        pt.Func(arr);
    }
    
}
