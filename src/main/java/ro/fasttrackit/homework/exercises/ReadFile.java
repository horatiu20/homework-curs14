package ro.fasttrackit.homework.exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) throws Exception {
		List<Quote> quotes = readQuotes();
		System.out.println(quotes);
		readFullFile();
	}

	private static void readFullFile() throws Exception {
		System.out.println("----Read full file----");
		Scanner fileScanner = new Scanner(new File("src/main/resources/quotes.txt"));
		while (fileScanner.hasNext()) {
			String line = fileScanner.nextLine();
			System.out.println(line);
		}
	}

	public static List<Quote> readQuotes() throws Exception {
		System.out.println("----AUTHOR ~ QUOTE----");
		List<Quote> quotes = new ArrayList<>();
		BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/quotes.txt"));
		String line;
		while ((line = fileReader.readLine()) != null) {
			quotes.add(quoteInfo(line));
		}
		return quotes;
	}

	private static Quote quoteInfo(String quoteInfo) {
		String[] quoteData = quoteInfo.split("~");
		boolean favourite = false;
		String author = quoteData[0];
		String quote = quoteData[1];

		Scanner scanner = new Scanner(quoteData[0]);
		int id = 0;
		while (scanner.hasNextLine()) {
			scanner.nextLine();
			id++;
		}
		scanner.close();

		if (quoteData[0].contains("Lao Tzu")) {
			favourite = true;
		}
		return new Quote(id, author, quote, favourite);
	}
}
