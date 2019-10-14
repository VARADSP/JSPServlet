package com.uks.varad.core.day4.assignment5;
import java.util.HashMap;
import java.util.TreeMap;

public class FrequencyChecker {
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
		System.out.println("Frequency Checker By Using HashMap");
		new FrequencyChecker().frequencyCheckerByHashMap(args);
		System.out.println("Frequency Checker By Using TreeMap");
		new FrequencyChecker().frequencyCheckerByTreeMap(args);
	}
}