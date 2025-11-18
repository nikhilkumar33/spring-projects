import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class FindHighestThreeNumber {
	public static void main(String[] args) 
	{
		List<Integer> list = Arrays.asList(80,55,48,66,95,10,22);
		
		list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(x -> System.out.println(x));
		
		
	}
}
