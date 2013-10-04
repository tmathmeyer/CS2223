public class Main{
	public static void main(String[] args){
		Sort s = args[0].equals("1")?(new MergeSort()):args[0].equals("2")?(new QuickSort()):args[0].equals("3")?(new HeapSort()):(new BubbleSort());
		int[] vals = generateRandomArray(500, 450);
		Viewer v = new Viewer("Sort Viewer");

		s.setValues(vals);
		s.setViewer(v);
		s.sort();

	}

	public static int[] generateRandomArray(int length, int max){
		int[] res = new int[length];
		for(int i = 0; i < length; i++)
			res[i] = (int)(Math.random() * max);
		return res;
	}

	public static int[] generateSortedArray(int length){
		int[] res = new int[length];
		for(int i = 0; i < length; i++)
			res[i] = 200-i;
		return res;
	}
}
