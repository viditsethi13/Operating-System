#include<iostream>
using namespace std;
#define swap(x,y) x=x+y;y=x-y;x=x-y;
struct process
{
	int brutime;
	int priority;
};
int main()
{
	int n,comtime[n],watime[n];
	process p[n];
	double avgtutime,avgwatime;
	cout<<"Enter number of processes:";
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cout<<"Enter Brust time of process no. "<<i+1<<":";
		cin>>p[i].brutime;
		cout<<"priority:";
		cin>>p[i].priority;
	}
    for(int m=0;m<n-1;m++)//1 is treated as highest priority
	{
		int sl=m;
		for(int l=m;l<n;l++)
		{
			if(p[l].priority<p[sl].priority)
			{
				sl=l;
			}
		}
		if(sl!=m)
		{
			swap(p[sl].priority,p[m].priority);
			swap(p[sl].brutime,p[m].brutime);
		}
	}
	//cout<<p[2].brutime;
	for(int i=0;i<n;i++)
	{
		cout<<p[i].brutime<<" "<<p[i].priority<<endl;
	}
	comtime[0]=p[0].brutime;
	avgtutime=comtime[0];
	avgwatime=0;
	cout<<"Process 1:"<<endl;
	cout<<"Waiting time=0"<<endl;
	cout<<"Completion time="<<comtime[0]<<endl;
	for(int i=1;i<n;i++)
	{
		watime[i]=comtime[i-1];
		comtime[i]=watime[i]+p[i].brutime;
		avgtutime=avgtutime+comtime[i];//since arrival time is zero for all process
		avgwatime=avgwatime+watime[i];
		cout<<"Process "<<i+1<<":"<<endl;
		cout<<"Waiting time="<<watime[i]<<endl;
		cout<<"Completion time="<<comtime[i]<<endl;
	}
	avgtutime=avgtutime/n;
	avgwatime=avgwatime/n;
	cout<<endl;
	cout<<"Average Waiting time "<<avgwatime<<endl;
	cout<<"Average TurnAround time "<<avgtutime<<endl;
}
