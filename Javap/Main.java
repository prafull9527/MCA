public class Main 
{
    public static void main(String[] args) throws InterruptedException 
    {
        for (char ch = 'A'; ch <= 'Z'; ch++) 
        {
            System.out.println(ch);
            Thread.sleep(2000);
        }
    }
}
// 2 5 17
