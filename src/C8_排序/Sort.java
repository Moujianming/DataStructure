package C8_����;
import java.util.Arrays;
public class Sort { 
	/**
	 * ֱ�Ӳ�������
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
	   * �۰��������
	   * @param R
	   */
	  public static void BinaryInsertionSort(int[] R)
	  {
		  int n = R.length;
		  int high;
		  for(int i =1;i<n;i++)
		  {
			  high = i-1;
			  int temp = R[i];//Ҫ�����Ԫ��
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
	   * ϣ������
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
	   * ð������
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
	   * ��������
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
	   * ��ѡ������
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
	   * ������
	   * @param arr
	   */
	  public static void Heapsort(int []arr){
	        //1.�����󶥶�
	        for(int i=arr.length/2-1;i>=0;i--){
	            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
	            adjustHeap(arr,i,arr.length);
	        }
	        //2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
	        for(int j=arr.length-1;j>0;j--){
	            swap(arr,0,j);//���Ѷ�Ԫ����ĩβԪ�ؽ��н���
	            adjustHeap(arr,0,j);//���¶Զѽ��е���
	        }

	    }

	    /**
	     * �����󶥶ѣ����ǵ������̣������ڴ󶥶��ѹ����Ļ����ϣ�
	     * @param arr
	     * @param i
	     * @param length
	     */
	    public static void adjustHeap(int []arr,int i,int length){
	        int temp = arr[i];//��ȡ����ǰԪ��i
	        for(int k=i*2+1;k<length;k=k*2+1){//��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
	            if(k+1<length && arr[k]<arr[k+1]){//������ӽ��С�����ӽ�㣬kָ�����ӽ��
	                k++;
	            }
	            if(arr[k] >temp){//����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
	                arr[i] = arr[k];
	                i = k;
	            }else{
	                break;
	            }
	        }
	        arr[i] = temp;//��tempֵ�ŵ����յ�λ��
	    }

	    /**
	     * ����Ԫ��
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
	     * �鲢����
	     * @param arr
	     */
	    public static void mergeSort(int[] arr) {
	        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	    }

	    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
	        if (left < right) {
	            int center = (left + right) / 2;
	            mergeSort(arr, temp, left, center); // ���
	            mergeSort(arr, temp, center + 1, right); // �ұ�
	            merge(arr, temp, left, center + 1, right); // �ϲ���������
	        }
	    }

	    /**
	     * �����������鲢��һ�������
	     *
	     * @param arr
	     * @param temp     ��ʱ����
	     * @param leftPos  ��߿�ʼ�±�
	     * @param rightPos �ұ߿�ʼ�±�
	     * @param rightEnd �ұ߽����±�
	     */
	    public static void merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd) {
	        int leftEnd = rightPos - 1; // ��߽����±�
	        int tempPos = leftPos; // ����߿�ʼ��
	        int numEle = rightEnd - leftPos + 1; // Ԫ�ظ���
	        while (leftPos <= leftEnd && rightPos <= rightEnd) {
	            if (arr[leftPos] <= arr[rightPos])
	                temp[tempPos++] = arr[leftPos++];
	            else
	                temp[tempPos++] = arr[rightPos++];
	        }
	        while (leftPos <= leftEnd) {  // ��������ʣ��
	            temp[tempPos++] = arr[leftPos++];
	        }
	        while (rightPos <= rightEnd) { // �ұ������ʣ��
	            temp[tempPos++] = arr[rightPos++];
	        }
	        // ��temp���Ƶ�arr
	        for (int i = 0; i < numEle; i++) {
	            arr[rightEnd] = temp[rightEnd];
	            rightEnd--;
	        }
	    }
	
	  public static void main(String[] args) {
		int[] R = {38,49,38,65,97,76,13,27,49};
		System.out.println("����ǰ:"+Arrays.toString(R));
		//Example.InsertSort(R);//
		//Example.Binary_Insertion_Sort(R);
		//Arrays.sort(R);
	     //Example.Shell_Sort(R);
		//Example.BubbleSort(R);
		//Example.QuickSort(R, 0, R.length-1);
		//Sort.SelectSort(R);
		//Sort.Heapsort(R);
		Sort.mergeSort(R);
		System.out.println("�����:"+Arrays.toString(R));
	}
}
