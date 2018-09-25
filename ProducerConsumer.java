import java.util.*;
class producerconsumer 
{
    static int s=1;
    static int full=0;
    static int empty=5;
    Scanner sc;
    int choice;
    
    producerconsumer()
     {
        sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("For producer:1\nFor consumer:2\nFor exit:3\n");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    if(s==1 && empty!=0)
                    {
                        producer();
                    }
                    else
                    {
                        System.out.println("Producer Waiting");
                    }
                    break;
                case 2:
                    if(s==1 && full!=0)
                    {
                        consumer();    
                    }
                    else
                    {
                        System.out.println("Consumer Waiting");
                    }
                    break;
                    
                case 3:
                    System.exit(0);
            }
        } 
     }
    void producer()
    {
        s=wait(s);
        full=signal(full);
        empty=wait(empty);
        System.out.println("Produced...");
        s=signal(s);
    }
    void consumer()
    {
        s=signal(s);
        full=wait(full);
        empty=signal(empty);
        System.out.println("Consumed..");
        s=wait(s);
        
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
        new producerconsumer();
    }
    
}