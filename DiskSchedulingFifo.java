import static java.lang.Math.abs;
import java.util.*;
import java.util.Scanner;

public class DiskSchedulingFifo
{
    public static void main(String[] args) {
        int n,creq;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Seek request:");
        n=sc.nextInt();
        int req[]=new int[n];
        System.out.println("Enter Seek requests:");
        for(int i=0;i<n;i++)
            req[i]=sc.nextInt();
        System.out.println("Enter current req:");
        creq=sc.nextInt();
        int dis=0;
        for(int i=0;i<n;i++)
        {
            dis=dis+abs(creq-req[i]);
            creq=req[i];
        }    
        System.out.println("Total Seek Time:"+dis);
}
}