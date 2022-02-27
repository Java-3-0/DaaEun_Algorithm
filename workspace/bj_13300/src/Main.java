import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Student implements Comparable<Student>{
		int sex;
		int year;
		
		public Student(int sex, int year) {
			super();
			this.sex = sex;
			this.year = year;
		}

		@Override
		public int compareTo(Student o) {
			return this.year != o.year ? this.year - o.year : this.sex - o.sex;
		}
	}
	
	static int N, K, roomCnt;
	static Student[] students;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		students = new Student[N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int y = 0;
		int s = 0;
		for(Student student : students) {
			if()
		}\\
		
	}
}
