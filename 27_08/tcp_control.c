#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#define NO_PACKETS 10
int rand1(int a){
	int rn = (random() % 10) % a;
	return rn = 0 ? 1 : rn;
}
int main(){
	int packets[NO_PACKETS],i,clk,bsize,oprate,rem=0,op,prize,ptime;
	for(i=0;i<NO_PACKETS;i++){
		packets[i] = rand1(6) * 10;
		printf("%d\n",packets[i]);
	}
	printf("\nEnter the output rate");
	scanf("%d",&oprate);
	printf("\nEnter the bucket size:");
	scanf("%d",&bsize);
	for(i=0;i<NO_PACKETS;i++){
		if((packets[i] + rem) > bsize){
			if(packets[i] > bsize)
				printf("\n\nIncoming packet size (%d, bytes) is greater than bucket capacity (%d,bytes) PACKET REJECTED",packets[i],bsize);
			else
				printf("\n\nBucket capacity exceeded");
		}
		else{
			rem += packets[i];
			printf("\n\nIncoming packet size %d",packets[i]);
			printf("\nBytes remaining to transmit : %d",rem);
			ptime = 10;
			printf("\nTime left for transmission : %d ",ptime);
			for(clk = 10;clk <= ptime ; clk += 10){
				sleep(1);
				if(rem){
					if(rem < oprate){
						op = rem;
						rem = 0;
					}
					else{
						op = oprate;
						rem = rem - oprate;
					}
					printf("\nPacket of size %d transmitted",op);
					printf("\n...Bytes remaining to transmit : %d",rem);
				}
				else{
					printf("\nTime left for transmission : %d",ptime-clk);
					printf("\nNo packets to transmit");
				}
			}
		}
	}
}
