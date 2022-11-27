
import java.net.*;
import java.io.*;
import java.util.*;

import javax.naming.NameNotFoundException;

public class shortform {
      public static void main(String[] args) throws IOException{
            Scanner inp=new Scanner(System.in);
            String name=inp.nextLine();
            InetAddress inet=InetAddress.getByName(name);
            System.out.println(inet);
      }
}
