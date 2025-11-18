import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionEvenOrOdd {
	public static void main(String[] args) 
	{
		List<Integer> list = Arrays.asList(15,10,12,18,19,32,55,3);
		
		Map<Boolean, List<Integer>> partionedList = list.stream().collect(Collectors.partitioningBy(n -> n%2==0));
		
		System.out.println(partionedList);
	}
}
