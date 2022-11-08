

class Print
{
    public void print(char x,int y)
    {
        System.out.println("Character = "+x);
        System.out.println("Integer = "+y);
    }
    
    public void print(int x,char y)
    {
        System.out.println("Integer = "+x);
        System.out.println("Characer = "+y);
    }
}

public class DiffSeq {
    public static void main(String[] args)
    {    
        Print obj=new Print();
        
        obj.print('A',1);
        System.out.println("\n");
        obj.print(2,'B');
    }
}
