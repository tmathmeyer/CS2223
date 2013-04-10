public class EmptyAVLTree implements AVL{
	public int getNode(){
		return 0;
	}
	public AVL add(int i){
		return new AVLTree(i);
	}
	public AVL remove(int i){
		return this;
	}

	public boolean isEmpty(){
		return true;
	}
	public AVL getLeft(){
		return this;
	}
	public AVL getRight(){
		return this;
	}
	public boolean areChildrenEmpty(){
		return true;
	}
	public int depth(){
		return 0;
	}
	public int getBalance(){
		return 0;
	}
	public AVL balance(){
		return this;
	}
	public void print(int depth){

	}
}