package C7_ͼ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ��С��������Ϊ����ķ�Ϳ�³˹����
 * ����ķ�㷨�ǰ��յ���м��㣬�ʺ��ڳ���ͼ��
 * ��³˹�������ձ߽��м��㣬�ʺ���ϡ��ͼ
 */
class Edge{
	int i;
	int j;
	int w;
	public Edge(int i, int j, int w) {
		this.i = i;
		this.j = j;
		this.w = w;
	}

	public String toString()
	{
		return " "+w;
	}
}
public class MinTree {

	/**
	 * ��MGraph��ά�����ʾͼ���ٽ����
	 * lowcost[]//�洢��С�ı�Ȩֵ
	 * vset[]//�洢������Ϣ���1��ʾ�������еģ�0��ʾû�в������е�
	 */
	public static void Prim(int[][] MGraph,int v0,int n)
	{		
		int[] vset = new int[n];
		int[] lowcost = new int[n];
		//��ʼ��
		for (int i = 0; i < n; i++) {
			lowcost[i] = MGraph[0][i];
			vset[i] = 0;
		}
		//��0�㿪ʼ���ʵ�
		vset[v0] = 1;
		
		int min = 0;
		int total = 0;
		int k  = 0;
		for(int i = 1;i<n;i++)
		{
			min = Integer.MAX_VALUE;
			for(int j = 1;j<n;j++)
			{
				if(vset[j]==0&&min>lowcost[j])
				{
					min = lowcost[j];
					k = j;
				}
			}
			vset[k] = 1;
			
			total+=min;
			
			//����lowcost[]
			for(int j=1;j<n;j++)
			{
				if(vset[j]==0&&lowcost[j]>MGraph[k][j])
					lowcost[j]= MGraph[k][j];
			}
			
		}
		System.out.println(total);
		
	}
	
	public static void Kruskal(ArrayList<Edge> list,int n)
	{
		int sum = 0;
		int e = list.size();
		int[] road = new int[n];
		for(int i = 0;i<n;i++)
			road[i] = i;
		//���м���
		int a,b;
		for(int i = 0;i<e;i++)
		{
			a = getRoot(road,list.get(i).i);
			b = getRoot(road,list.get(i).j);
			if(a!=b)
			{
				road[a] = b;
				sum+=list.get(i).w;
			}
		}
		System.out.println(sum);
	}
	//���鼯
	public static int getRoot(int[] road,int i)
	{
		while(road[i]!=i) i = road[i];
		return i;
	}
	public static void main(String[] args) {
		

		int[][] MGraph = {
				{0,5,1,2,Integer.MAX_VALUE},
				{5,0,3,Integer.MAX_VALUE,4},
				{1,3,0,6,2},
				{2,Integer.MAX_VALUE,6,0,3},
				{Integer.MAX_VALUE,4,2,3,0}};
		//Prim(MGraph, 0, 5);
		
		ArrayList<Edge> list = new ArrayList<>();
		list.add(new Edge(0, 1,5 ));
		list.add(new Edge(0,2 , 1));
		list.add(new Edge(0, 3, 2));
		//list.add(new Edge(0, 4, ));
		list.add(new Edge(1,0 ,5 ));
		list.add(new Edge(1, 2,3 ));
		//list.add(new Edge(1, 3, ));
		list.add(new Edge(1,4 , 4));
		list.add(new Edge(2, 1, 3));
		list.add(new Edge(2, 3, 6));
		list.add(new Edge(2, 4, 2));
		list.add(new Edge(2,0 ,1 ));
		list.add(new Edge(3, 0, 2));
		//list.add(new Edge(3, 1, ));
		list.add(new Edge(3,2 , 6));
		list.add(new Edge(3, 4,3 ));
		//list.add(new Edge(4, 0, ));
		list.add(new Edge(4, 1, 4));
		list.add(new Edge(4, 2, 2));
		list.add(new Edge(4,3 ,3 ));
		Collections.sort(list,new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.w-o2.w;
			}
		});
		System.out.println(list);
		Kruskal(list, 5);
	}

}

