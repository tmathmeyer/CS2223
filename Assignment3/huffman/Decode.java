import java.util.HashMap;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Decode{
	HashMap<String, String> huffmanHash;
	ArrayList<String> originalMessage = new ArrayList<String>();

	@SuppressWarnings("unchecked")
	public void importHash() throws Exception{
		ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("huff.hash"));
		huffmanHash = (HashMap<String, String>) objIn.readObject();
		objIn.close();
	}

	public void reverseHuffmanHash(){
		HashMap<String, String> newHuffHash = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : huffmanHash.entrySet())
		    newHuffHash.put(entry.getValue(), entry.getKey());
		this.huffmanHash = newHuffHash;
	}


	public void readFile(String fileName) throws Exception{
		FileReader inputStream = new FileReader(fileName);
		char cur = 'a';
		String currentString = "";
		while (cur != (char)-1){
			int i = inputStream.read();
			cur = (char)i;
			if (i!=-1){
				currentString += cur;
				String readVal = huffmanHash.get(currentString);
				if (readVal != null){
					this.originalMessage.add(readVal);
					currentString = "";
				}
			}
		}
	}


	public void writeToFile(String fileName) throws Exception{
		File file = new File(fileName);
		if (!file.exists())file.createNewFile();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for(String s : originalMessage)
			bw.write(s);
		bw.close();
	}






	public Decode(String fileFrom, String fileTo) throws Exception{
		System.out.println("Attempting to decompress");
		System.out.println("importing huffman hashmap from file");
		this.importHash();
		System.out.println("successfully imported huffman hashmap from file");
		System.out.println("reversing huffman hashmap for use in decompression");
		this.reverseHuffmanHash();
		System.out.println("reading from compressed file");
		this.readFile(fileFrom);
		System.out.println("operation successful");
		System.out.println("attempting to decompress and write to file");
		this.writeToFile(fileTo);
		System.out.println("finished");

	}
}