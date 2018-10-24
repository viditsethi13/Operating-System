import java.util.*;
class readerwriter
{
    static int s=1;
    static int wrt=1;
    static int readcount=0;
    Scanner sc;
    int choice;
    
    readerwriter()
     {
        sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("For reader:1\nFor writer:2\nFor exit:3\n");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    if(wrt==1)
                    {
                        reader();
                    }
                    else
                    {
                        System.out.println("Reader Waiting because Writer Writing");
                    }
                    break;
                case 2:
                    if(wrt==1 && readcount==0)
                    {
                        writer();    
                    }
                    else
                    {
                        System.out.println("Writer Waiting because Reader reading");
                    }
                    break;
                    
                case 3:
                    System.exit(0);
            }
        } 
     }
    void reader()
    {
		wait(s);
		readcount++;
		if(readcount==1)
		{
			wait(wrt);
		}
		signal(s);
		System.out.println("Reader Reading");
		wait(s);
		readcount--;
		if(readcount==0)
		{
			signal(wrt);
		}
		signal(s);
    }
    void writer()
    {
		wait(wrt);
		System.out.println("Writer Writing");
		signal(wrt);
    }
    int signal(int s)
    {
        return ++s;
    }
    int wait(int s)
    {
        return --s;
    }
}
public class x
{
    public static void main(String sa[])
    {
        new readerwriter();
    }
}