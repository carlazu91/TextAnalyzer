import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class Main extends TextAnalyzer {	
	public static void main(String[]args) throws Exception {
		
		//Poem is being written to a .txt file removing all characters not needed
		WriteFileContents();
		
		//Hashmap created to use CountWords() method
		Map<String, Integer> words = new HashMap<String, Integer>();
		CountWords(words);
		
		//Sorting Map keys and values from most to least
		Map<String, Integer> sortedMap = words.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue()))
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
						(entry1, entry2) -> entry2, LinkedHashMap::new));
		
		//Print Map Vertically 
		for (String key : sortedMap.keySet()) {
		    System.out.println(key + " = " + sortedMap.get(key));
		}
	}
}