package questions;
import java.util.*;
public class WordFrequencyCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 3 Strings : ");
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String str3 = sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        String[] words1 = str1.split(" ");
        String[] words2 = str2.split(" ");
        String[] words3 = str3.split(" ");
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : words3) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("Unique words: " + map.size());
	}

}
