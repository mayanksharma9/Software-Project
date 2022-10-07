#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
#include<math.h>

//We will declare our Global variables here 
int average=0, Minimum=0,Maximum=0,Medium=0;
int arraylen=7;
int arr[]={90,81,78,95,79,72,85};

int main()
{
    int fork1= fork();
    int fork2= fork();
//We will create child processes here to compute these values
if(fork1>0 && fork2 > 0)
{
    int i=0;
    int add=0;
    for(i=0;i<arraylen;i++)
    {
        add = add+arr[i];
    }
    average=add/(double)arraylen;
    printf("The average value is %d \n",average);
}
else if(fork1==0 && fork2 >0)
{
    int i=0;
    Minimum =arr[0];
    for(i=0;i<arraylen;i++)
    {
        if(arr[i]<Minimum)
        {
            Minimum= arr[i];
        }
    }
    printf("The Minimum value is %d \n",Minimum);
}
else if(fork1 > 0 && fork2==0)
{
    int i=0;
    Maximum= arr[0];
    for(i=0;i<arraylen;i++)
    {
        if(arr[i]>Maximum)
        {
            Maximum= arr[i];
        }
    }
    printf("The Maximumm value is %d\n",Maximum);
}
else
{
    int temp;
    for(int i=0; i<arraylen; i++)
    {
        for(int j =i+1; j<arraylen; j++)
        {
            if(arr[i]>arr[j])
            {
                temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
        }
    }
    int i=0;
    Medium=arr[0];

    if(arraylen%2==0)
    {
        Medium=(arr[(arraylen-1)/2]+arr[arraylen/2])/2;
    }
    else
    {
        Medium= arr[arraylen/2];
    }
    printf("The Medium value is %d \n",Medium);
}

}