import java.util.*;
public class Perm_Comb {
    int fact(int n)
    {
        if(n<2) return 1;
        else return n*fact(n-1);
    }
    
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("n= ");
        int n=inp.nextInt();
        System.out.print("r= ");
        int r=inp.nextInt();
        Perm_Comb obj=new Perm_Comb();
        System.out.println("Permutation = "+(obj.fact(n)/(obj.fact(n-r))));
        System.out.println("Permutation = "+(obj.fact(n)/(obj.fact(r)*(obj.fact(n-r)))));
    }
}
