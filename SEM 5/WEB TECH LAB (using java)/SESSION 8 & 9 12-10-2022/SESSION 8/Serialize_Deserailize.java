import java.io.*;
import java.util.*;

class Content implements Serializable
{
      public String Country_name, continent;
      public long population;
      Content()
      {
            System.out.println("Enter Country name, continent, population = ");
            Scanner obj=new Scanner(System.in);
            this.Country_name=obj.next();
            this.continent = obj.next();
            this.population = obj.nextInt();
      }
}

class Serialize_Deserailize
{
      void display(Content obj)
      {
            System.out.println("------------------------------");
            System.out.println("Country = "+obj.Country_name);
            System.out.println("Continent = "+obj.continent);
            System.out.println("Population = "+obj.population);
            System.out.println("------------------------------");
      }
      public static void main(String[] args)
      {
            Content obj=new Content();

            //SERIALIZABLE

            //file creation
            try{
                  File fl=new File("Textfile2.txt");
                  fl.createNewFile();
            }catch(IOException e)
            {
                  System.out.println(e);
            }

            try{

                  FileOutputStream out = new FileOutputStream("Textfile2.txt");
                  ObjectOutputStream objout=new ObjectOutputStream(out);

                  objout.writeObject(obj);
                  out.close();
                  objout.close();
                  System.out.println("Successfully Serialized");
            }
            catch(IOException e) 
            {
                  System.out.println(e);
            }

            //DESRIALIZE


            try{
                  Content oriobj=null;
                  FileInputStream fin=new FileInputStream("Textfile2.txt");
                  ObjectInputStream objinp=new ObjectInputStream(fin);
                  oriobj=(Content)objinp.readObject();
                  new Serialize_Deserailize().display(oriobj);
                  fin.close();
                  objinp.close();
                  System.out.println("Successfully deserialized");

            }
            catch(IOException a)
            {
                  System.out.println(a);
            }
            catch (ClassNotFoundException e) {
                  System.out.println(e);
            }


      }
}