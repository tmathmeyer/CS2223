public class Tests {
	public static int[] func_linsort(int[] data){
		int newArr[] = new int[1000];
		int output[] = new int[100];
		for(int i = 1; i < 100; i++)
			newArr[data[i]]++;
		int total = 0;
		for(int i = 1; i < 1000; i++){
			int oldCount = newArr[i];
			data[total] = i;
			total = total + oldCount;
		}
		return data;
	}
	
	public static void main(String[] args){
		int[] d = new int[100];
		for(int i = 0; i < 100; i++)d[i] = (int) (Math.random()*1000);
		d = func_linsort(d);
		for(Integer i : d)System.out.print(i+" ");
	}
}
