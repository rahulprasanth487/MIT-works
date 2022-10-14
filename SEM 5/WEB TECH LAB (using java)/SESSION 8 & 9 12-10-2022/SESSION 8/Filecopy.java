import java.io.*;
import java.util.*;

public class Filecopy {
      public static void main(String[] args)
      {
             try{
                  File fl=new File("File3.txt");
                  fl.createNewFile();
             }
             catch(IOException e){System.out.println(e);}

             try{
                  FileWriter writer=new FileWriter("File3.txt");
                  File fle=new File("text1.txt");

                  Scanner scn=new Scanner(fle);
                  while(scn.hasNext())
                  {
                        String x=(scn.next());
                        writer.write(x+"--->"+x.toUpperCase()+"\n");
                  }
                  writer.close();
             }
             catch(IOException e)
             {
                  System.out.println(e);
             }
      }
}
