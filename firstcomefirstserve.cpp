#include<iostream>
using namespace std;

int main()
{
	int n,watime[n],comtime[n],brutime[n];
	double avgtutime,avgwatime;
	cout<<"Enter number of processes:";
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cout<<"Enter Brust time of process no. "<<i+1<<":";
		cin>>brutime[i];
	}
	comtime[0]=brutime[0];
	watime[0]=0;
	avgtutime=comtime[0];
	avgwatime=watime[0];
	cout<<"Process 1:"<<endl;
	cout<<"Waiting time="<<watime[0]<<endl;
	cout<<"Completion time="<<comtime[0]<<endl;
	for(int i=1;i<n;i++)
	{
		watime[i]=comtime[i-1];
		comtime[i]=watime[i]+brutime[i];
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
