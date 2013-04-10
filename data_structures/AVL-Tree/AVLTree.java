public class AVLTree implements AVL{
	int node;
	public AVL left = new EmptyAVLTree();
	public AVL right = new EmptyAVLTree();

	public AVLTree(int i){
		this.node = i;
	}

	public int getNode(){
		return node;
	}
	public AVL add(int i){
		if (i >= this.getNode())
			this.right = this.right.add(i);
		else
			this.left = this.left.add(i);
		return this.balance();
	}
	public AVL remove(int i){
		if (this.getNode == i){
			if (this.getLeft().isEmpty() &&) return this.getRight();
			if (this.getRight().isEmpty()) return this.getLeft();
			
		}
		if (this.getNote() > i)
			this.right = this.getRight().remove(i);
		if (this.getNote() > i)
			this.left = this.getLeft().remove(i);
		return this;
	}
	public boolean isEmpty(){
		return false;
	}
	public AVL getLeft(){
		return this.left;
	}
	public AVL getRight(){
		return this.right;
	}
	public boolean areChildrenEmpty(){
		return this.getLeft().isEmpty() && this.getRight().isEmpty();
	}
	public int depth(){
		int a = this.getLeft().depth();
		int b = this.getRight().depth();
		return (a>b?a:b) + 1;
	}
	public int getBalance(){
		int a = this.getLeft().depth();
		int b = this.getRight().depth();
		return a-b;
	}
	public AVL balance(){
		int bal = this.getBalance();
		if (Math.abs(bal) < 2)return this;

		if (bal > 1){
			AVLTree newTop = (AVLTree) this.getLeft();
			this.left = newTop.getRight();
			newTop.right = this;
			return newTop;
		}
		AVLTree newTop = (AVLTree) this.getRight();
		this.right = newTop.getLeft();
		newTop.left = this;
		return newTop;
	}

	public void print(int depth){
		for(int i = 0; i < depth; i++)System.out.print("  ");
		System.out.println(this.getNode());
		this.getLeft().print(depth+1);
		this.getRight().print(depth+1);
	}
}