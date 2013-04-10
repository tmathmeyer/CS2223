import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Encode{

	HashMap<String, Integer> fileInformation = new HashMap<String, Integer>();
	MinNodeHeap huffmanHeap;
	HashMap<String, String> huffmanHash;
	ArrayList<String> fileAsChars;




	public void mapToHeap(HashMap<String, Integer> map){
		Node[] result = new Node[map.size()];
		int i = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet())
		    result[i++] = new KeyNode(entry.getKey(), entry.getValue());
		huffmanHeap = new MinNodeHeap(result);
	}

	public void readFile(String fileName) throws Exception{
		FileReader inputStream = new FileReader(fileName);
		fileAsChars = new ArrayList<String>();
		char cur = 'a';
		while (cur != (char)-1){
			int i = inputStream.read();
			cur = (char)i;
			if (i!=-1){
				Integer j = fileInformation.get(cur+"");
				fileAsChars.add(cur+"");
				if (j==null) j=0;
				fileInformation.put(cur+"", j+1);
			}
		}
	}

	public void writeToFile(String fileName) throws Exception{
		File file = new File(fileName);
		if (!file.exists())file.createNewFile();
		String toByte = "";
		for(String s : fileAsChars)
			toByte += this.huffmanHash.get(s);
		OutputStream out = new FileOutputStream(fileName);
		out.write(fromBinary(toByte));
		out.close();
	}




	private byte[] fromBinary(String s){
	    int sLen = s.length();
	    byte[] toReturn = new byte[(sLen + Byte.SIZE - 1) / Byte.SIZE];
	    char c;
	    for( int i = 0; i < sLen; i++ )
	        if( (c = s.charAt(i)) == '1' )
	            toReturn[i / Byte.SIZE] = (byte) (toReturn[i / Byte.SIZE] | (0x80 >>> (i % Byte.SIZE)));
	        else if ( c != '0' )
	            throw new IllegalArgumentException();
	    return toReturn;
	}

	public void writeHuffmanHash() throws Exception{
		//File f = new File("huff.hash");
		//if (!f.exists()) f.createNewFile();
		FileOutputStream fos = new FileOutputStream("huff.hash");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this.huffmanHash);
		oos.close();
	}


	public Encode(String fileFrom, String fileTo) throws Exception{
		this.readFile(fileFrom);
		System.out.println("file reading successful");
		this.mapToHeap(fileInformation);
		System.out.println("created the heap for merging");
		huffmanHash = huffmanHeap.getMasterNode().huffmanHash("");
		System.out.println("successfully merged the heap and created the final hash");
		System.out.println("Attempting to write to file");
		this.writeToFile(fileTo);
		System.out.println("Encoding Successful");
		System.out.println("Saving the huffmanHash to file");
		this.writeHuffmanHash();
		System.out.println("Huffman Hash saved to \"huff.hash\"");
	}
}












class MinNodeHeap{
	private Node[] heap;
	private int quarantine;

	public MinNodeHeap(Node[] vals){
		this.heap = vals;
		quarantine = heap.length;
		this.heapify();
	}

	public void mergeNodes(){
		Node a = this.removeMinNode();
		Node b = this.removeMinNode();
		Node merge = new UpperNode(a,b);
		this.addNode(merge);
	}

	public Node removeMinNode(){
		Node min = heap[0];
		quarantine--;
		swap(0, quarantine);
		heapify();
		return min;
	}

	public void addNode(Node n){
		if (quarantine >= heap.length)return;
		heap[quarantine] = n;
		quarantine++;
		heapify();
	}

	public Node getMasterNode(){
		while(quarantine > 1)
			mergeNodes();
		return heap[0];
	}


	private void heapify(){
		for(int lhi = 0; lhi < quarantine-1; lhi++){
			int add = lhi + 1;
			int parent = lhi/2;
			while(heap[parent].getFrequency() > heap[add].getFrequency()){
				swap(parent, add);
				add = parent; 
				parent = (parent-1)/2;
			}
		}
	}

	private void swap(int px, int py){
		Node temp = heap[px];
		heap[px] = heap[py];
		heap[py] = temp;
	}
}



class KeyNode implements Node{
	private int frequency;
	private String value;
	public KeyNode(String value, int frequency){this.value=value;this.frequency=frequency;}
	public int getFrequency(){return this.frequency;}
	public String getValue(){return this.value;}
	public boolean isKey(){return true;}
	public HashMap<String, String> huffmanHash(String prevals){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(this.getValue(), prevals);
		return map;
	}


	public void print(int i){
		for(int j=0;j<i;j++)System.out.print(" ");
		System.out.println(this.getFrequency()+":"+this.getValue());
	}
}

class UpperNode implements Node{
	private int frequency;
	private Node left,right;
	public UpperNode(Node left, Node right){this.left=left;this.right=right;}
	public int getFrequency(){return this.getLeft().getFrequency()+this.getRight().getFrequency();}
	public String getValue(){return null;}
	public boolean isKey(){return false;}
	public Node getLeft(){return this.left;}
	public Node getRight(){return this.right;}
	public HashMap<String, String> huffmanHash(String prevals){
		HashMap<String, String> map = this.getLeft().huffmanHash(prevals+"0");
		map.putAll(this.getRight().huffmanHash(prevals+"1"));
		return map;
	}


	public void print(int i){
		for(int j=0;j<i;j++)System.out.print(" ");
		System.out.println(this.getFrequency());
		left.print(i+1);
		right.print(i+1);
	}
}

interface Node{
	public int getFrequency();
	public String getValue();
	public boolean isKey();
	public void print(int i);
	public HashMap<String, String> huffmanHash(String prevals);
}