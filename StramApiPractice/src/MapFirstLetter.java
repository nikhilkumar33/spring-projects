import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFirstLetter {

	public static void main(String[] args) 
	{
		//Given a list of strings, return a map of first letter → list of words starting with it.
		
		//using normal java
		List<String> list= Arrays.asList("Dipa","Aswita","Dipankar","Aswini","Dipika","Soumya","Soumya Shree","Soumyadeep","Nikhil","Nikita");
//		
//		Map<Character, List<String>> map = new HashMap<>();
//		
//		for(String word: list) 
//		{
//			if(!map.containsKey(word.charAt(0)))
//			{
//				map.put(word.charAt(0),new ArrayList<>());
//			}
//			map.get(word.charAt(0)).add(word);
//		}
//		System.out.println(map);
		
		//using stream api
		
		Map<Character, List<String>> finalRes = list.stream().collect(Collectors.groupingBy(n-> n.charAt(0)));
		
		System.out.println(finalRes);
	}

}
