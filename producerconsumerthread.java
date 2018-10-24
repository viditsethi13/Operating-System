import java.util.*;
import java.io.*;
class pc
{
    pc()
    {
        ArrayDeque<Integer> b = new ArrayDeque<Integer>();
        Thread ob1 = new Thread(new producer(b));
        Thread ob2 = new Thread(new consumer(b));
        ob1.start();
        ob2.start();
    }
}
class producer implements Runnable
{
    int i=0;
    ArrayDeque<Integer> b=null;
    final int limit =5;
    producer(ArrayDeque<Integer> b)
    {
        this.b=b;
    }
    public void produce()throws InterruptedException
    {
        synchronized(b)
        {
            while(b.size()==limit)
            {
                System.out.println("Producer Waiting");
                b.wait();
            }
        }
        synchronized(b)
        {
            b.add(i);
	    System.out.println("Producing....");
            Thread.sleep(1000);
            b.notify();
        }
    }
    public void run() 
    {
	while(true)
	{
	    i++;
            try
            {
                produce();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.toString());
            }
	}
    }
}
class consumer implements Runnable
{
    ArrayDeque<Integer> b=null;
    consumer(ArrayDeque<Integer> b)
    {
        this.b=b;
    }
    public void consume() throws InterruptedException
    {
	synchronized(b)
	{
	     while(b.isEmpty())
	     {
		System.out.println("Consumer Waiting...");
		b.wait();
	     }
	}
	synchronized(b)
	{
	     b.pop();
	     System.out.println("Consuming");
	     Thread.sleep(1000);
	     b.notify();
	}
     }
    public void run() 
    {
	while(true)
	{
	     try
	     {
		consume();
	     }
	     catch(InterruptedException e)
	     {
		System.out.println(e.toString());
	     }
        }
    }
}
public class producerconsumerthread
{
    public static void main(String[] args) 
    {
      new pc();   
    }
}