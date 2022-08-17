class sum_of_integers
{
    public static void main(String[] args)
    {
        int sum=0;
        for(int i=100;i<=200;++i)
        {
            sum+=(i%3==0)?i:0;
        }

        System.out.println("Sum is = "+sum);
    }
}