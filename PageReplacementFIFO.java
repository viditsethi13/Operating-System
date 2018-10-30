import java.util.*;


public class PageReplacementFIFO
{
    public static void main(String[] args) {
        int n,npf,j=0,hit=0,pfaults=0,nxtreplace=0;
        boolean check;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of pages..");
        n=sc.nextInt();
        System.out.println("Enter no of page frames..");
        npf=sc.nextInt();
        int pg[]=new int[n];
        int pf[]=new int[npf];
        for(int i=0;i<npf;i++)
            pf[i]=-1;
        System.out.println("Enter pages:");
        for(int i=0;i<n;i++)
        {
            check=false;
            pg[i]=sc.nextInt();
            for(int k=0;k<npf;k++)
            {
                if(pf[k]==pg[i])
                {
                    hit++;
                    check=true;
                    break;
                }
            }
            if(check==false)
            {
                pfaults++;
                pf[nxtreplace++]=pg[i];
                if(nxtreplace==npf)
                    nxtreplace=0;
            }
            }
        System.out.println("Final Page Frame:");
        for(int i=0;i<npf;i++)
            System.out.println(pf[i]);
        System.out.println("Page Hits:"+hit);
        System.out.println("Page Faults:"+pfaults);
   }
}