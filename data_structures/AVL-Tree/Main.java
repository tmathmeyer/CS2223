public class Main{
	public static void main(String[] args){
		AVL v = new EmptyAVLTree();
		for(int i = 0; i < 200; i++)v = v.add(i);

		v.print(0);
	}
}