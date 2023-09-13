import java.util.*;

public class Main{
    
    public static void mergeSort(int arr[],int low,int high){
        int mid;
        if(low<high){
            mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    
    public static void merge(int arr[],int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int k=low;
        
        int c[]=new int[100];
        
        while((i<=mid)&&(j<=high)){
            if(arr[i]<arr[j]){
                c[k++]=arr[i++];
            }
            else{
                c[k++]=arr[j++];
            }
        }
        
        if(j>high){
            for(;i<=mid;i++){
                c[k++]=arr[i];
            }
        }
        else{
            for(;j<=high;j++){
                c[k++]=arr[j];
            }
        }
        
        for (i = low; i <= high; i++)
            arr[i] = c[i];
    }
    
    public static void main(String args[]){
        int n;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        n=in.nextInt();
        int arr[] = new int [n];
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        
        mergeSort(arr,0,n-1);
        
        System.out.println("Sorted elements are");
        
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
