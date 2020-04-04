package algData2Assessed1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QuickSort {
	
	
	//QUESTÝON1A----------------------------------------------------------------------------
	
	
	
	
	public static int partition(int[] A,int p,int r) {
		int x=A[r];
		int i=p-1;
		for (int j=p;j<r;j++) { // careful its not r-1 as specified in pseudocode.!ITs r.
			if(A[j]<=x) {
				i=i+1;
				int temp=A[i]; // temp variables are assigned to perform swap
				A[i]=A[j];
				A[j]=temp;
		}
			}
		int temp2=A[i+1];
		A[i+1]=A[r];
		A[r]=temp2;
		return i+1;
	}
	
	public static void quickSort(int[] A,int p,int r) {
		if (p<r) {
			int q=partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
		
		
		
	}


	
	// QUESTÝON 1B-----------------------------------------------------
	
	
	
	public static void insertionSort(int[] arr, int low, int n)
	{
		for (int i = low + 1; i <= n; i++)
		{
			int value = arr[i];
			int j = i;

			while (j > low && arr[j - 1] > value)
			{
				arr[j] = arr[j - 1];
				j--;
			}
			

			arr[j] = value;
		}
	}
	
	
	public static void optimizedQuickSort(int[] A, int low, int high,int k) 
	//k is the number you specifiy so that insertion sort algorithm used instead of normal quickSort when a subsets number of elements are lower than k.
	{
		while (low < high)
		{
			// do insertion sort if k or smaller
			if(high - low < k)
			{
				insertionSort(A, low, high);
				//System.out.print("Doing insertion");
				break;
			}
			else
			{
				int pivot = partition(A, low, high);
				//System.out.print("doing optimzed");
				if (pivot - low < high - pivot) {
					optimizedQuickSort(A, low, pivot - 1,k);
					low = pivot + 1;
				} else {
					optimizedQuickSort(A, pivot + 1, high,k);
					high = pivot - 1;
				}
			}
		}
	}
	
	
	
	
	
	//QUESTÝON 1C---------------------------------------------------------

	
	
	
	
	public static int partitionMedian3(int[] A,int p,int r) {
		int x=getMedian(A,p,r); //only difference between classic and this partition is that x equals to median value instead of right most element.
		int i=p-1;
		for (int j=p;j<r;j++) { 
			if(A[j]<=x) {
				i=i+1;
				int temp=A[i]; 
				A[i]=A[j];
				A[j]=temp;
		}
			}
		int temp2=A[i+1];
		A[i+1]=A[r];
		A[r]=temp2;
		return i+1;
	}
	
	
//method to find median between 3 values.
public static int getMedian(int[] a,int left,int right){
   
	int center = (left+right)/2;
    
   if(a[left] > a[center])
       swap(a,left,center);
    
   if(a[left] > a[right])
       swap(a,left, right);
    
   if(a[center] > a[right])
       swap(a,center, right);
    
   swap(a,center, right);
   return a[right];
}

// This method is used to swap the values between the two given index
//introduced now because there are lots of repetitions of swap code in here.
public static void swap(int[] a,int left,int right){
   int temp = a[left];
   a[left] = a[right];
   a[right] = temp;
}
	
	
	
public static void quickSortMedian3(int[] A,int p,int r) {
	if (p<r) {
		int q=partitionMedian3(A,p,r);
		quickSort(A,p,q-1);
		quickSort(A,q+1,r);
	}
}
//QUESTÝON 1D ----------------------------------------------




private static int[] partition3Way(int[] array, int low, int high) {
	//compare with normal partition
	//we need two more variables: lt, gt
	//lt: the first element with the pivot value
	//the last element with pivot value

	int ilt = low; 
	int jgt = high;
	int vcmp = array[low];
	int si = low;
	
	while (true) {
		if (array[i] < cmp)
			swap(array, i++, lt++);
		else if (array[i] > cmp)
			swap(array, i, gt--);
		else
			i++;
		
		if(i > gt)
			break;
	}

	return new int[] { lt, gt };

}



public static void quickSort3Way(int[] A,int p,int r) {
	if (p<r) {
		int[] pivots = partition3Way(A, p, r); 
	
		int lt = pivots[0]; //smaller ones
		int gt = pivots[1]; //greater ones
		// recursive sort
		quickSort3Way(A, p, lt - 1);
		quickSort3Way(A, gt + 1, r);

}
}
public static boolean isSorted(int a[]){
	 int n = a.length;
	 for (int i = 0; i < n-1; i++){
	 if (a[i] > a[i+1]){
	 return false;
	 }
	 }
	 return true;
	 }
	
	


	//testing
	public static void main(String[] args)throws InterruptedException {
        int[] arr = {4, 5, 1, 2, 3, 3,6,7,8,9,0,14,8,9,0,12,15,678,9,9,90,0,87,64,4,123,54345,6567,75654,456456};
        int[] arr2 = {0, 10, 1, 4, 8, 2};
        int[] arr3 = {8, 100, 6, 89, 12, 25};
        int[] arr4 = {200, 20, 5, 8, 300, 250};
        int[] arr5 = {4, 5, 1, 2, 3, 3};
        //quickSort(arr2, 0, arr2.length-1);
        System.out.println(Arrays.toString(arr));
        //optimizedQuickSort(arr2, 0, arr2.length-1,2); //in this example we specifiy k=2 when no of elements in a sub array becomes less than k it calls insertion for those.!
        System.out.println(Arrays.toString(arr2));
        quickSortMedian3(arr3,0,arr3.length-1);
        System.out.println(Arrays.toString(arr3));// median of these 3 found and then done! 
        //quickSort3Way(arr4,0,arr4.length-1);
        System.out.println(Arrays.toString(arr4));
        
        boolean test=isSorted(arr3);
       //timings
        System.out.print(test);
        
        long startTime = System.nanoTime();

		/* ... the code being measured starts ... */

		// sleep for 5 seconds
		TimeUnit.SECONDS.sleep(5);
		//quickSort(arr, 0, arr.length-1);
		//quickSort3Way(arr5,0,arr5.length-1);
		//quickSortMedian3(arr5,0,arr5.length-1);
		/* ... the code being measured ends ... */

		long endTime = System.nanoTime();

		// get difference of two nanoTime values
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds  : " + timeElapsed);

		System.out.println("Execution time in milliseconds : " + 
								timeElapsed / 1000000);
	
        
        
        
        
        
        
        
        

		
	}

        
	}	
	
	
	
	
	
	
