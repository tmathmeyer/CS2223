public class BubbleSort implements Sort{
	int[] values;
	Viewer v;

	public void sort(){
		v.set(values);
		this.bubbleSort();
	}
	public void setValues(int[] values){
		this.values = values;
	}
	public void setViewer(Viewer v){
		this.v = v;
	}
	public void pause(){
		try{
	    	Thread.sleep(0);
	    } catch(Exception e) {} //this slows down the animation so you can acutally see it
	}


	public void bubbleSort(){
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < values.length - j; i++) {                                       
				if (values[i] > values[i + 1]) {                          
					swap(i, i+1);
					swapped = true;
					v.set(values);
					pause();
				}
			}                
		}
	}

	public void swap(int px, int py){
		int temp = values[px];
		values[px] = values[py];
		values[py] = temp;
	}
}