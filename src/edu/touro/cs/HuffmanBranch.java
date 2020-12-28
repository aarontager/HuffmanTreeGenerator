package edu.touro.cs;

public class HuffmanBranch implements Comparable<HuffmanBranch> {
	int frequency;
	char letter;
	HuffmanBranch leftBranch, rightBranch;

	public HuffmanBranch(int frequency, char letter, HuffmanBranch leftBranch, HuffmanBranch rightBranch) {
		this.frequency = frequency;
		this.letter = letter;
		this.leftBranch = leftBranch;
		this.rightBranch = rightBranch;
	}

	@Override
	public int compareTo(HuffmanBranch huffmanBranch) {
		return this.frequency - huffmanBranch.frequency;
	}

	public String toString() {
		return "Frequency: " + frequency + ",\nLetter: " + letter;
	}
}
