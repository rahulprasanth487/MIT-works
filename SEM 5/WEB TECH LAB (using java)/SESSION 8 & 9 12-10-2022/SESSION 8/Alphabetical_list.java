import java.util.*;
import java.io.*;
import java.util.Map.Entry;
class Alphabetical_list
{

      void createfile()
      {
            try {
                  File fl = new File("text1.txt");
                  if (fl.createNewFile()) {
                        System.out.println("File successfully created");
                  } else {
                        System.out.println("Already exists\n");
                  }
            } catch (IOException e) {
                  System.out.println(e);
                  e.printStackTrace();
            }
      }

      ArrayList<String> readfile()
      {
            ArrayList<String> arr=new ArrayList<>();
            try{
                  File f1=new File("text1.txt");
                  Scanner rdr=new Scanner(f1);
                  while(rdr.hasNext())
                  {
                        String data=rdr.next();
                        arr.add(data);
                        writefile(data);
                        System.out.println(data);
                  }
                  rdr.close();
            }
            catch(FileNotFoundException e)
            {
                  System.out.println(e.getMessage());
            }
            return arr;
      }

      void writefile(String s)
      {
            try{
                  File fl=new File("newFile1.txt");
                  fl.createNewFile();
                  FileWriter Writer=new FileWriter("newFile1.txt",true);
                  Writer.write(s);
                  Writer.write("\n");
                  Writer.close();
            }
            catch(IOException e)
            {
                  System.out.println(e);
            }
      }
      public static void main(String[] args)
      {
            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

            Alphabetical_list obj=new Alphabetical_list();
            obj.createfile();

            ArrayList<String> arr=obj.readfile(); 
            Map<String,Integer> mp=new HashMap<>();
            
            for(String i:arr)
            {
                  if(mp.containsKey(i))
                  {
                        mp.put(i,mp.get(i)+1);
                  }
                  else{
                        mp.put(i,1);
                  }
            }

            ArrayList<String> kys = new ArrayList<>();
            ArrayList<Integer> values = new ArrayList<>();

            for (Map.Entry entry : mp.entrySet()) {
                  kys.add((String)entry.getKey());
                  values.add((Integer)entry.getValue());
            }

            Collections.sort(kys);
            Collections.sort(values,Collections.reverseOrder());

            try{
                  FileWriter writer=new FileWriter("newFile1.txt",true);
                  writer.write("\n\n");
                  for(String i:kys)
                  {     System.out.println(i + " " + mp.get(i));
                        writer.write(i+" "+mp.get(i)+"\n");
                  }
                  writer.write("\n\n");
                  writer.close();


                  //list 2
                  FileWriter writer2 = new FileWriter("newFile1.txt", true);
                  writer2.write("\n\n");
                  for (Integer i : values) {
                        for (Entry<String, Integer> entry : mp.entrySet()) {
                              if (entry.getValue().equals(i)) {
                                    sortedMap.put(entry.getKey(), i);
                              }
                        }
                  }
                  writer2.close();
                  System.out.println(sortedMap);
                  

                  FileWriter wr=new FileWriter("newFile1.txt",true);
                  wr.write("\n\n");
                  for(Entry<String,Integer> entry : sortedMap.entrySet())
                  {
                        System.out.println(entry.getKey() + " " + entry.getValue() + "\n");
                        wr.write(entry.getKey()+" "+entry.getValue()+"\n");
                  }
                  wr.close();
                  
            }
            catch(IOException a){System.out.println(a.getMessage());}

            
               
      }
}