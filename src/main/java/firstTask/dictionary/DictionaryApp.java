package firstTask.dictionary;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by andrzej on 31.08.17.
 */
public class DictionaryApp {




	public static void main(String[] args) throws IOException {
		String pathToFile = "/home/andrzej/dev/java8/src/main/resources/dictionary.txt";

		DictionaryService service = new DictionaryService();

		List<String> allRowsFromFile = service.getAllRowsFromFile(pathToFile);
//		System.out.println(allRowsFromFile.size());

		List<String> aaaa = service.getAllContains(allRowsFromFile, "dam");
		System.out.println(aaaa.size());

		List<String> list = new ArrayList<>();
		list.add("kayak");
		list.add("mama");
		list.add("something");
		list.add("aaaa");
		list.add("abba");


		List<String> allPalindromes = service.getAllPalindromes(allRowsFromFile);
		System.out.println("Palindromes number is : " + allPalindromes.size());

		List<String> allLength = service.getAllLength(allRowsFromFile, 11);
//		System.out.println(allLength.size());

		Double averageLengthOfStrings= service.getAverageLengthOfStrings(allRowsFromFile);
		NumberFormat formatter = new DecimalFormat("#0.00");

		System.out.println(formatter.format(averageLengthOfStrings));
/*
		int medianLength = service.getMedianLength(list);
		System.out.println("median :" + medianLength);

		int i = service.countWordsWithLength(list, 4);
		System.out.println("words with length " + i);*/

		float a = service.getFrequencyOfLetter(allRowsFromFile, 'a');
		System.out.println("percentage is " + a + " %");

	}
}
