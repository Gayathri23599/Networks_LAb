#include<stdio.h>
int a[100],b[100],i,j,len,k,count=0;
//Generator Polynomial:g(x)=x^16+x^12+x^5+1
int gp[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,};
int main()
{
void div();
system("clear");
printf("\nEnter the length of Data Frame :");
scanf("%d",&len);
printf("\nEnter the Message :");
for(i=0;i<len;i++)
scanf("%d",&a[i]);
//Append r(16) degree Zeros to Msg bits
for(i=0;i<16;i++)
a[len++]=0;

for(i=0;i<len;i++)
	b[i]=a[i];
k=len-16;
div();
for(i=0;i<len;i++)
	b[i]=b[i]^a[i];
printf("\n Data to be transmitted : ");
for(i=0;i<len;i++)
	printf("%2d", b[i]);

printf("\n\n Enter the received data: ");
for(i=0;i<len;i++)
	scanf("%d",&a[i]);

div();

for(
