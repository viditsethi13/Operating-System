import static java.lang.Integer.min;
import java.util.Scanner;

public class PageReplacementLRU {
    
    static int indexOf(int t[],int n,int m)
    {
        int i=0; 
        while(i<n){ 
            if (t[i]==m){ 
                return i; 
            } 
            else{ 
                i=i+1; 
            } 
        }
        return -1;
    }
    static int getMin(int t[],int n)
    {
        int m=t[0]; 
        for (int i=1;i<n;i++) 
            m=min(m,t[i]); 
        return indexOf(t,n,m);   
    }
    
    int t1[],t2[],t3[];
    public static void main(String[] args) {
        int n,npf,hit=0,pfault=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of pages..");
        n=sc.nextInt();
        System.out.println("Enter no of page frames..");
        npf=sc.nextInt();
        int pg[]=new int[n];
        int pf[]=new int[npf];
        int time[]=new int[npf];
        for(int i=0;i<npf;i++)
            pf[i]=-1;
        System.out.println("Enter page requests...");
        for(int i=0;i<n;i++)
        {
           pg[i]=sc.nextInt();
        }
        int counter=0;
        for(int i=0;i<n;i++)
        {
            int flag1=0,flag2=0,pos=0;
            for(int j=0;j<npf;j++)
            {
                if(pg[i]==pf[j])
                {
                    hit++;
                    counter++;
                    time[j]=counter;
                    flag1=1;
                    flag2=1;
                    break;
                }
            }   
            if(flag1==0)
            {
                for(int j=0;j<npf;j++)
                {
                    if(pf[j]==-1)
                    {
                        counter++;
                        pfault++;
                        pf[j]=pg[i];
                        time[j]=counter;
                        flag2=1;
                        break;
                    }
                }
            }
            if(flag2==0)
            {
                pos=getMin(time,npf);
                counter++;
                pfault++;
                pf[pos]=pg[i];
                time[pos]=counter;
            }
        }
        System.out.println("Final Page Frame:");
        for(int i=0;i<npf;i++)
            System.out.println(pf[i]);
        System.out.println("Page Hits:"+hit);
        System.out.println("Page Faults:"+pfault);
    }
}