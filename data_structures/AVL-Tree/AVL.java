public interface AVL{
	public int getNode();
	public AVL add(int i);
	public AVL remove(int i);
	public boolean isEmpty();
	public AVL getLeft();
	public AVL getRight();
	public boolean areChildrenEmpty();
	public int depth();
	public int getBalance();
	public AVL balance();

	public void print(int depth);
}