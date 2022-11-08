import java.net.*;
import java.io.*;

public class Sample {

    public static void main(String[] args) throws IOException{
        System.out.println("Enter teh name= ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(bf.readLine());
    }
}
