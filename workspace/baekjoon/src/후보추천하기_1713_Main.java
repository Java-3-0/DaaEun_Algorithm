import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 후보추천하기_1713_Main {
	
	public class Student {
		int no, cnt;

		public Student(int no, int cnt) {
			super();
			this.no = no;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Student> reco = new ArrayList<Student>();
		for (int i = 0; i < M; i++) {
			
			if(reco.size() == N) {
				map.
			} else {
				if(reco.contains(new Student(number[i], ))) {
					map.put(numbers[i], map.get(numbers[i])+1);
				} else {
					map.put(numbers[i], 1);
				}
			}
		}
		
		
	}
}
