import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine().toCharArray();// word의 length 만큼의 숫자 조합 ㄱㄱ
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length; i++) {
			int su = map.getOrDefault(word[i], 0);
			map.put(word[i], su+1);
		}
		int div = 1;
		for (Character key : map.keySet()) {
			for (int i = 1; i <= map.get(key); i++) {
				div *= i;
			}
		}
		pick = new char[word.length];
		visited = new boolean[word.length];
		count = 0;
		pick(0);
		System.out.println(count/div);

	}

	static char[] word;
	static char[] pick;
	static boolean[] visited;
	static int count;

	public static void pick(int pidx) {
		if (pidx == word.length) {
			if (!same())
				count++;
			return;
		}
		for (int i = 0; i < word.length; i++) {
			if (visited[i])
				continue;
			pick[pidx] = word[i];
			visited[i] = true;
			pick(pidx + 1);
			visited[i] = false;
		}

	}

	public static boolean same() {
		for (int i = 1; i < pick.length - 1; i++) {
			if (pick[i] == pick[i - 1] || pick[i] == pick[i + 1])
				return true;
		}
		return false;
	}
}
