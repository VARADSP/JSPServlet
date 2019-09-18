package day4.assignment5;
/*
 * @author Varad Parlikar Day4 Assignment5
 */
import java.util.HashMap;
import java.util.TreeMap;
/**
 * Class FrequencyChecker which contains methods to check and count frequencies of words in a string array by using hash map and tree map.
 * @author: Varad Parlikar Created Date: 2019/06/21
 */

public class FrequencyChecker {
	/**
     * method frequencyCheckerByTreeMap counts frequency of words by using Tree Map
     * @String[] array of strings
     * return type : void
     */
	public void frequencyCheckerByTreeMap(String[] input){
		TreeMap<String,Integer> wordList = new TreeMap<>();
		for(String w:input){
			if(wordList.containsKey(w)){
				Integer frequency = wordList.get(w);
				wordList.put(w, ++frequency);
			}
			else{ wordList.put(w, new Integer(1)); }
		}
	wordList.entrySet().forEach(entry->{ System.out.println(entry.getKey() + " " + entry.getValue()); });
	}
	/**
     * method frequencyCheckerByTreeMap counts frequency of words by using Hash Map
     * @String[] array of strings to check the frequency of words
     * return type : void
     */
	public void frequencyCheckerByHashMap(String[] input){
		HashMap<String,Integer> wordList = new HashMap<>();
		for(String w:input){
			if(wordList.containsKey(w)){
				Integer frequency = wordList.get(w);
				wordList.put(w, ++frequency);
			}
			else{ wordList.put(w, new Integer(1)); }
		}
	wordList.entrySet().forEach(entry->{ System.out.println(entry.getKey() + " " + entry.getValue()); });
	}
	public static void main(String[] args) {

		try{
			args[0].isEmpty();
			System.out.println("Frequency Checker By Using HashMap");
			new FrequencyChecker().frequencyCheckerByHashMap(args);
			System.out.println("Frequency Checker By Using TreeMap");
			new FrequencyChecker().frequencyCheckerByTreeMap(args);
		}
		catch(Exception e){
			System.out.println("Please Enter value from command line");
		}
	}
}