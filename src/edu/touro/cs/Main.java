package edu.touro.cs;

import java.util.*;

public class Main {
	//Supports only capital letters to start
	static int[] letterFrequencies = new int[26];

	public static void main(String[] args) {
		System.out.println("Please input a string:");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();

		countLetters(input);
		buildTree();
	}

	private static void countLetters(String s) {
		char[] array = s.toCharArray();
		for(char c : array) {
			if(c >= 'A' && c <= 'Z') {
				letterFrequencies[c - 'A']++;
			}
		}
	}

	private static void buildTree() {
		PriorityQueue<HuffmanBranch> queue = new PriorityQueue<>(26, HuffmanBranch::compareTo);

		for(int i = 0; i < 26; i++) {
			if(letterFrequencies[i] > 0) {
				HuffmanBranch temp = new HuffmanBranch(letterFrequencies[i], (char) (i + 'A'),
						null, null);
				queue.add(temp);
			}
		}

		while(queue.size() > 1) {
			HuffmanBranch leftBranch = queue.poll();
			HuffmanBranch rightBranch = queue.poll();
			HuffmanBranch newBranch = new HuffmanBranch(leftBranch.frequency + rightBranch.frequency,
					'\0', leftBranch, rightBranch);
			queue.add(newBranch);
		}
	}
}
