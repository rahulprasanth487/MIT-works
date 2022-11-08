import java.util.*;
public class Matrix_operations {
    
    void display(int A[][],int m,int n)
    {
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    void addition(int A[][],int B[][],int m,int n)
    {
        int ans[][]=new int[m][n];
        
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                ans[i][j]=A[i][j]+B[i][j];
            }
        }
        Matrix_operations obj=new Matrix_operations();
        this.display(ans, m, n);
    }
    
    void multiplication(int A[][],int B[][],int m,int n)
    {
        int ans[][]=new int[m][n];
        
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                for  (int k=0;k<n;++k)                                                                                                                                                              
                {ans[i][j]+=A[i][k]*B[k][j];}
            }
        }
        Matrix_operations obj=new Matrix_operations();
        this.display(ans, m, n);
    }
    
    void transpose(int A[][],int m,int n)
    {
        int ans[][]=new int[m][n];
        
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                ans[i][j]=A[j][i];
            }
        }
        Matrix_operations obj=new Matrix_operations();
        this.display(ans, m, n);
    }
    
    
    int[][] getmatrix(int m,int n)
    {
        int ans[][]=new int[m][n];
        Scanner inp=new Scanner(System.in);
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                System.out.print("Enter arr["+i+"]["+j+"] = ");
                int x=inp.nextInt();
                ans[i][j]=x;
            }
        }
        
        return ans;
    }
    
    
    
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter the dimension of the matrix = ");
        int m=inp.nextInt();
        int n=inp.nextInt();
        
        Matrix_operations obj=new Matrix_operations();
        System.out.println("Matrx 1:");
        int A[][]=obj.getmatrix(m, n);
        System.out.println("Matrx 2:");
        int B[][]=obj.getmatrix(m, n);
        System.out.println("Addition = ");
        obj.addition(A, B, m, n);
        System.out.println("Multiplication = ");
        obj.multiplication(A, B, m, n);
        System.out.println("Transpose = ");
        obj.transpose(A,m, n);
        
    }
}
