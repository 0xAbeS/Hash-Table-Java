package hash;

import java.util.*;
import java.io.*;

public class HashTable {

	ArrayList<Point>[] table;
	int size;
	int count = 0;
	int elements = 0;

	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.size = size;
		table = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			table[i] = new ArrayList<Point>();
		}
	}

	private int getHash(String key) {
		int hashCode = key.hashCode();
		int arrayIndex = Math.abs(hashCode) % size;
		return arrayIndex;

	}

	public void put(String key, String value) {
		int indx = getHash(key);
		table[indx].add(new Point(key, value));
		count++;
	}

	public String get(String key) {
		int indx = getHash(key);
		for (int i = 0; i < table[indx].size(); i++) {
			if (table[indx].get(i).getKey().equals(key)) {
				return table[indx].get(i).getVal();
			}
		}
		return "DNE";
	}

	public boolean remove(String key) {
		int indx = getHash(key);
		for (int i = 0; i < table[indx].size(); i++) {
			if (table[indx].get(i).getKey().equals(key)) {
				table[indx].remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Iterator keys() {

		Iterator<String> it = new Iterator<String>() {

			private int indxH = 0;
			private int indxV = 0;
			boolean processed = false;
			
			
			@Override
			public boolean hasNext() {
				
				
				if (indxH == 0 && indxV == 0 && table[0].size() != 0  && processed != true) {
					return true;
				}
				boolean next = false;
				processed = false;
				while(indxH < table.length && next != true) {
					if(indxV + 1 < table[indxH].size()) {
						indxV +=1;
						return true;
					} else {
						indxH += 1;
						indxV = 0;
						if (indxH < table.length && table[indxH].size()!=0) {
							return true;
						}
					}
					
				}
				
//				while (indxH < table.length && next != true) {
//					if(table[indxH].size() == 0 || processed == true && indxV + 1 > table[indxH].size()) {
//						System.out.println("IndxHorizontal: " + indxH + " || IndxVertical: " + indxV + " || Processed: " + processed);
//						indxV = 0;
//						indxH += 1;
//						processed = false;
//						next = true;
//					} else {
//						System.out.println("IndxHorizontal: " + indxH + " || IndxVertical: " + indxV + " || Processed: " + processed);
//						if(processed == true) {
//								indxV += 1;
//								processed = false;
//								next = true;
//						} 
//					}
//				}
				return next;
				}
			
			
			@Override
			public String next() {
				if(!processed && indxH < table.length) {
					processed = true;
					System.out.println("IndxHorizontal: " + indxH + " || HorizontalLength: " + table.length + " || IndxVertical: " + indxV + " || Vertical Length: " + table[indxH].size() + " || Value: " + table[indxH].get(indxV).getVal());
					return table[indxH].get(indxV).getVal();
				} else {
					return "";
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		return it;

	}
	//
	// public void print(){
	// }
	/**
	 * Loads this HashTable from a file named "Lookup.dat".
	 */
	public void load() {
		FileReader fileReader;
		BufferedReader bufferedReader = null;

		// Open the file for reading
		try {
			File f = new File(System.getProperty("user.home"), "Lookup.dat");
			fileReader = new FileReader(f);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.err.println("Cannot find input file \"Lookup.dat\"");
		}

		// Read the file contents and save in the HashTable
		try {
			while (true) {
				String key = bufferedReader.readLine();
				if (key == null)
					return;
				String value = bufferedReader.readLine();
				if (value == null) {
					System.out.println("Error in input file");
					System.exit(1);
				}
				String blankLine = bufferedReader.readLine();
				if (!"".equals(blankLine)) {
					System.out.println("Error in input file");
					System.exit(1);
				}
				put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}

		// Close the file when we're done
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}

	/**
	 * Saves this HashTable onto a file named "Lookup.dat".
	 */
	public void save() {
		FileOutputStream stream;
		PrintWriter printWriter = null;
		Iterator iterator;

		// Open the file for writing
		try {
			File f = new File(System.getProperty("user.home"), "Lookup.dat");
			stream = new FileOutputStream(f);
			printWriter = new PrintWriter(stream);
		} catch (Exception e) {
			System.err.println("Cannot use output file \"Lookup.dat\"");
		}

		// Write the contents of this HashTable to the file
		iterator = keys();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			printWriter.println(key);
			String value = (String) get(key);
			value = removeNewlines(value);
			printWriter.println(value);
			printWriter.println();
		}

		// Close the file when we're done
		printWriter.close();
	}

	/**
	 * Replaces all line separator characters (which vary from one platform to the
	 * next) with spaces.
	 *
	 * @param value The input string, possibly containing line separators.
	 * @return The input string with line separators replaced by spaces.
	 */
	private String removeNewlines(String value) {
		return value.replaceAll("\r|\n", " ");
	}
}