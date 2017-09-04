import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by andrzej on 30.08.17.
 */
public class App {

	public static void main(String[] args) {

		String hello = "hello world";

		//map function
		//changes one type to another
		//avoid side effects - like changing/modifying states of objects. map should create a new one with changed state


		//stream
		//stream of data - alternatywne dla listy, sekwencja obiektów

		Stream.of(hello)
				.map(s -> s.length()) //funkcja map zmienia stringa s na s.length. za pomocą metody anonimowej lambda
				.forEach(System.out::println);

		//mapToInt - argument wyjściowy zawsze będzie int
		OptionalDouble average = Stream.of(1, 2, 4, 7, 9)
				.mapToDouble(i -> (double) i)
				.average();


		//average always returns Double - Optional double
		System.out.println(average);


		//w mapie możemy też napisać map(String::length) - metoda referencyjna (wtedy gdy jest jeden argument)

		//flatmap function
		//spłaszcza strukturę - np. z listy list wyciąga dane do jednej listy
			List<List> listWithinList = Arrays.asList(Arrays.asList(1,2,3,4), Arrays.asList(5,6,7,8,9)); // Arrays as List metoda statyczna która tworzy listy
			List<Object> collect = listWithinList.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());


		//predykat
		//funkcja filter (here predicate)
		//zwraca true or false - np. sprawdza czy liczby są parzyste

		//int stream - from 1 to 10
		Stream<Integer> boxed = IntStream.range(1, 10).boxed();
		boxed.filter(i -> i%2 == 0).forEach(System.out::println); //predicate here

		Predicate<Integer> predicate = i-> i % 2 == 0; //predicate and lambda here


		//comparable - interfejs do porównywania dwóch obiektów jakiejś klasy (przed java 8)
		//comparator - two objects, comparable - one object. COmparator returns 1, 0, -1 if the first object is bigger, equal or smaller

		int a = 3;
		int b = 4;
		System.out.println("------------");

		Set<Integer> collect1 = Stream.of(1, 2, 3, 4, 5, 5)
				.filter(i -> i > 3)
				.collect(Collectors.toSet());

		collect1.forEach(c -> System.out.println(c));


	}

	private static void calcAverage() {

	}



}
