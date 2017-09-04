package firstTask.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by andrzej on 31.08.17.
 */
public class DictionaryService {

	private List<String> stringsFromFile;

	public DictionaryService() {
		stringsFromFile = new ArrayList<>();
	}


	public List<String> getAllRowsFromFile(String pathToFile) throws IOException {

		BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(pathToFile));

		stringsFromFile = bufferedReader.lines()
				.collect(Collectors.toList());

		return stringsFromFile;

	}


	public List<String> getAllContains(List<String> words, String substring) {

		List<String> collect = words.stream()
				.filter(i -> i.contains(substring))
				.collect(Collectors.toList());

		return collect;
	}

	public List<String> getAllPalindromes(List<String> words) {

		List<String> collect = words.stream()
				.filter(i -> i.equalsIgnoreCase(reverseStringToPalindrome(i)))
				.collect(Collectors.toList());

		return collect;

	}

	public List<String> getAllLength(List<String> words, int lengthString) {

		List<String> collect = words.stream()
				.filter(i -> (i.length() == lengthString))
				.collect(Collectors.toList());

		return collect;

	}

	public Double getAverageLengthOfStrings(List<String> words) {
		return words.stream()
				.mapToDouble(String::length)
				.average()
				.getAsDouble();
	}

	public int getMedianLength(List<String> words) {

		List<String> list2 = words.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());

		int size = list2.size();

		if (size % 2 == 0) {

			int s = list2.get(size / 2).length();
			int s1 = list2.get(size / 2 + 1).length();

			return (s + s1) / 2;

		} else {

			return list2.get(size / 2).length();
		}

	}

	public int countWordsWithLength(List<String> words, int lengthString) {
		int collect = words.stream()
				.filter(x -> x.length() == lengthString)
				.collect(Collectors.toList())
				.size();

		return collect;
	}


	public float getFrequencyOfLetter(List<String> words, char letter) {
		long counter = 0;

		for (String word : words) {
			char[] chars = word.toCharArray();
			for (char aChar : chars) {
				if (aChar == letter) {
					counter++;
				}
			}
		}

		long counterAllletters = 0;
		for (String word : words) {
			int length = word.toCharArray().length;
			counterAllletters += length;
		}

		//TODO second for loop is not necessary - input second counter to first iterator

		System.out.println("letter " + letter + " " + counter + ".\n" + " All letters in List " + counterAllletters );

		float percentage = (counter * 100.0f) / counterAllletters;



		return percentage;
	}


	private String reverseStringToPalindrome(String toCompare) {
		StringBuilder builder = new StringBuilder(toCompare);

		return builder.reverse().toString();
	}

}
