/*SLIP-1
1.1.Write a multithreading program in java to display all the vowels from a given String.*/
/*class VowelThread extends Thread
{
private String input;
public VowelThread(String input)
{
this.input = input;
}
public void run()
{

System.out.println("Vowels in the string:");
for (int i = 0; i < input.length(); i++) {
char ch = Character.toLowerCase(input.charAt(i));
if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
{
System.out.print(ch + " ");
}
}
}
}
public class VowelFinder
{
public static void main(String[] args)
{
String str = "Multithreading in Java";
VowelThread vt = new VowelThread(str);
vt.start();
}
}*/

/* SLIP-1
1.1. Write a multithreading program in Java to display all the vowels from a given String. */
 /* 
import java.util.Scanner;

class VowelThread extends Thread 
{
    private String input;

    public VowelThread(String input) 
    {
        this.input = input;
    }

    public void run() 
    {
        System.out.println("Vowels in the string:");
        for (int i = 0; i < input.length(); i++) 
        {
            char ch = Character.toLowerCase(input.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
            {
                System.out.print(ch + " ");
            }
        }
    }
}

public class VowelFinder 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        VowelThread vt = new VowelThread(str);
        vt.start();
    }
}
*/

import java.util.Scanner;
class VowelThread extends Thread
{
    private String input;
    public VowelThread(String input)
    {
        this.input=input;
    }

    public void run()
    {
        System.out.println("Vowels in the string: ");
        for(int i=0;i<input.length();i++)
        {
        char ch=Character.toLowerCase(input.charAt(i));
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
        {
            System.out.print(ch+" ");
        }
        }
    }
}

public class VowelFinder
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str=sc.nextLine();
        VowelThread vt=new VowelThread(str);
        vt.start();
    }
}

// 1 8 15  https://github.com/prafull9527/MCA/blob/main/Java/java_all.java