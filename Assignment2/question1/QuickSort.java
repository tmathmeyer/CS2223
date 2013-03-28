public class QuickSort implements Sort{
	int[] values;
	Viewer v;

	public void sort(){
		v.set(values);
		this.quicksort(0,values.length-1);
	}
	public void setValues(int[] values){
		this.values = values;
	}
	public void setViewer(Viewer v){
		this.v = v;
	}

	public void quicksort(int low, int high) {
	    int i = low, j = high;
	    int pivot = values[low + (high-low)/2];
	    while (i <= j) {
	      	while (values[i] < pivot) 
	        	i++;
	      	while (values[j] > pivot) 
	        	j--;
	      	if (i <= j) {
	        	swap(i, j);
	        	v.set(values);
	        	pause();
	        	i++;
	        	j--;
	      	}
	    }
	    if (low < j)
	      	quicksort(low, j);
	    if (i < high)
	      	quicksort(i, high);
	  }



	public void swap(int x, int y){
		int temp = values[x];
		values[x] = values[y];
		values[y] = temp;
	}

	public void pause(){
		try{
	    	Thread.sleep(10);
	    } catch(Exception e) {} //this slows down the animation so you can acutally see it
	}
}