package C8_排序;
import java.util.Arrays;
public class Sort { 
	/**
	 * 直接插入排序
	 * @param R
	 */
	  public static void InsertSort(int[] R)
	  {
		  int n = R.length;
		  int i,j;
		  for(i = 1;i<n;i++)
		  {
			  int temp = R[i];
			  j=i-1;
			  while(j>=0&&temp<R[j])
			  {
				  R[j+1] = R[j];
				  j--;				  
			  }
			  R[j+1] = temp;
		  }
	  }
	  /**
	   * https://www.cnblogs.com/snowcan/p/6244361.html
	   * 折半插入排序
	   * @param R
	   */
	  public static void BinaryInsertionSort(int[] R)
	  {
		  int n = R.length;
		  int high;
		  for(int i =1;i<n;i++)
		  {
			  high = i-1;
			  int temp = R[i];//要插入的元素
			  int low = 0;
			  int mid  = 0;
			  while(low<=high)
			  {
				  mid = (low+high)/2;
				  if(R[mid]>=temp) high = mid-1;
				  if(R[mid]<temp) low = mid+1;
				  
			  }
			  int j = i;
			  while(j>low)
			  {
				  R[j] = R[j-1];
				  j--;
			  }
			  R[low] = temp;
		  }
	  }
	  /**
	   * https://www.cnblogs.com/chengxiao/p/6104371.html
	   * 希尔排序
	   * @param R
	   */
	  public static void ShellSort(int[] R)
	  {
		  int len = R.length;
		  for(int gap = len/2;gap>0;gap/=2)
		  {
			 
			  for(int j = gap;j<len;j++)
			  {
				  if(R[j]<R[j-gap])
				  {
					  int temp = R[j];
					  R[j] = R[j-gap];
					  R[j-gap] = temp;
				  }
			  }
			  
			  
		  }
	  }
	  /**
	   * 冒泡排序
	   * @param R
	   */
	  public static void BubbleSort(int[] R)
	  {
		 int len = R.length;
		 for(int i=0;i<len;i++)
		 {
			 for(int j = i;j<len;j++)
			 {
				 if(R[i]>R[j])
				 {
					 R[i] = R[i]+R[j];
					 R[j] = R[i]-R[j];
					 R[i] = R[i]-R[j];
				 }
			 }
		 }
	  }
	  /**
	   * 快速排序
	   * @param R
	   */
	  public static void QuickSort(int[] R,int l,int r)
	  {
		  int i = l,j = r;
		  if(l<r)
		  {
			  int temp = R[l];
			  while(i!=j)
			  {
				  while(i<j&&R[j]>=temp) j--;
				  R[i] = R[j];
				  while(i<j&&R[i]<temp) i++;
				  R[j] = R[i];
			  }
			  R[i] = temp;
			  QuickSort(R, 0, i-1);
			  QuickSort(R, i+1, r);
		  }
	  }
	  /**
	   * 简单选择排序
	   * @param R
	   */
	  public static void SelectSort(int[] R)
	  {
		  int len = R.length;
		  for(int i = 0;i<len-1;i++)
		  {
			  int k = i;
			  for(int j = i+1;j<len;j++)
			  {
				  if(R[k]>R[j])
				  {
					  k=j;
				  }
			  }
			  if(k!=i)
			  {
				  R[i] = R[i]+R[k];
				  R[k] = R[i]-R[k];
				  R[i] = R[i]-R[k];
			  }
			 
			/*  int temp = R[i];
			  R[i] = R[k];
			  R[k] = temp;*/
		  }
	  }
	  /**
	   * https://www.cnblogs.com/chengxiao/p/6129630.html
	   * 堆排序
	   * @param arr
	   */
	  public static void Heapsort(int []arr){
	        //1.构建大顶堆
	        for(int i=arr.length/2-1;i>=0;i--){
	            //从第一个非叶子结点从下至上，从右至左调整结构
	            adjustHeap(arr,i,arr.length);
	        }
	        //2.调整堆结构+交换堆顶元素与末尾元素
	        for(int j=arr.length-1;j>0;j--){
	            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
	            adjustHeap(arr,0,j);//重新对堆进行调整
	        }

	    }

	    /**
	     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
	     * @param arr
	     * @param i
	     * @param length
	     */
	    public static void adjustHeap(int []arr,int i,int length){
	        int temp = arr[i];//先取出当前元素i
	        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
	            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
	                k++;
	            }
	            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
	                arr[i] = arr[k];
	                i = k;
	            }else{
	                break;
	            }
	        }
	        arr[i] = temp;//将temp值放到最终的位置
	    }

	    /**
	     * 交换元素
	     * @param arr
	     * @param a
	     * @param b
	     */
	    public static void swap(int []arr,int a ,int b){
	        int temp=arr[a];
	        arr[a] = arr[b];
	        arr[b] = temp;
	    }
	    /**
	     * https://blog.csdn.net/donggua3694857/article/details/58309624
	     * 归并排序
	     * @param arr
	     */
	    public static void mergeSort(int[] arr) {
	        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	    }

	    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
	        if (left < right) {
	            int center = (left + right) / 2;
	            mergeSort(arr, temp, left, center); // 左边
	            mergeSort(arr, temp, center + 1, right); // 右边
	            merge(arr, temp, left, center + 1, right); // 合并两个有序
	        }
	    }

	    /**
	     * 将两个有序表归并成一个有序表
	     *
	     * @param arr
	     * @param temp     临时数组
	     * @param leftPos  左边开始下标
	     * @param rightPos 右边开始下标
	     * @param rightEnd 右边结束下标
	     */
	    public static void merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd) {
	        int leftEnd = rightPos - 1; // 左边结束下标
	        int tempPos = leftPos; // 从左边开始算
	        int numEle = rightEnd - leftPos + 1; // 元素个数
	        while (leftPos <= leftEnd && rightPos <= rightEnd) {
	            if (arr[leftPos] <= arr[rightPos])
	                temp[tempPos++] = arr[leftPos++];
	            else
	                temp[tempPos++] = arr[rightPos++];
	        }
	        while (leftPos <= leftEnd) {  // 左边如果有剩余
	            temp[tempPos++] = arr[leftPos++];
	        }
	        while (rightPos <= rightEnd) { // 右边如果有剩余
	            temp[tempPos++] = arr[rightPos++];
	        }
	        // 将temp复制到arr
	        for (int i = 0; i < numEle; i++) {
	            arr[rightEnd] = temp[rightEnd];
	            rightEnd--;
	        }
	    }
	
	  public static void main(String[] args) {
		int[] R = {38,49,38,65,97,76,13,27,49};
		System.out.println("排序前:"+Arrays.toString(R));
		//Example.InsertSort(R);//
		//Example.Binary_Insertion_Sort(R);
		//Arrays.sort(R);
	     //Example.Shell_Sort(R);
		//Example.BubbleSort(R);
		//Example.QuickSort(R, 0, R.length-1);
		//Sort.SelectSort(R);
		//Sort.Heapsort(R);
		Sort.mergeSort(R);
		System.out.println("排序后:"+Arrays.toString(R));
	}
}
