#include<iostream>
using namespace std;

int main()
{
	int n;
	cout<<"Enter number of process:";
	cin>>n;
	int bt[n],rbt[n],wt[n],tat[n],timequantum,t=0,x=0,awt=0,atat=0;
	for(int i=0;i<n;i++)
	{
		cout<<"Enter their burst time of process "<<i+1<<":";
		cin>>bt[i];
		rbt[i]=bt[i];
		wt[i]=0;
	}
	cout<<"Enter Time Quantum:";
	cin>>timequantum;
	while(1)
	{
		x=0;
		for(int i=0;i<n;i++)
		{
			if(rbt[i]>0)
			{
				if(rbt[i]>timequantum)
				{
					t=t+timequantum; 
					rbt[i]=rbt[i]-timequantum;
				}
				else
				{
					t=t+rbt[i];
					rbt[i]=0;
					wt[i]=t-bt[i];
					tat[i]=wt[i]+bt[i];
				}
			}
			else
			{
				x++;
			}
		}
		if(x==n)
		{
			break;
		}
	}
	cout<<endl;
	for(int i=0;i<n;i++)
	{
		cout<<"Process:"<<i+1<<endl;
		cout<<"Waiting time:"<<wt[i]<<endl;
		cout<<"Turn Around time:"<<tat[i]<<endl;
		awt = awt+wt[i];
		atat = tat[i]+atat;
	}
	cout<<endl;
	cout<<"Average Waiting Time:"<<awt/n<<endl;
	cout<<"Average Turn Around Time:"<<atat/n<<endl;	
}
