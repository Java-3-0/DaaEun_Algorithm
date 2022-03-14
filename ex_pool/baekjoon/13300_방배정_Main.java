import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BJ 13300.방 배정
// 12048 kb
// 96 ms
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
		public int compareTo(Student o) { // 학년 오름차순, 성별 오름차순(여자먼저)
			return this.year != o.year ? this.year - o.year : this.sex - o.sex;
		}
	}
	
	static int roomCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 학생 수
		int K = Integer.parseInt(st.nextToken());	// 최대 인원 수
		
		Student[] students = new Student[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(students);
//		for(Student student : students) {
//			System.out.print("[" + student.sex + " " + student.year + "]");
//		}
//		System.out.println();
		int y = 0;
		int s = 0;
		int cnt = 0;
		for(Student student : students) {
			if(y != student.year) {
				y = student.year;
				s = student.sex;
				roomCnt++;	// 방문닫고, 새로운 방문 열기
//				System.out.println("[" + roomCnt + "]" + student.sex + " " + student.year + "를 방에 집어넣어요");
				cnt = 1;
			} else {
				if (s == student.sex) {
					if(cnt == K) {
//						System.out.println("[" + roomCnt + "]이 가득 찼어요");
						roomCnt++;	// 방문닫고, 새로운 방문 열기
						cnt = 0;
					}
//					System.out.println("[" + roomCnt + "]" + student.sex + " " + student.year + "를 방에 집어넣어요");
					cnt++;
				} else {
					s = student.sex;
					roomCnt++;	// 방문닫고, 새로운 방문 열기
//					System.out.println("[" + roomCnt + "]" + student.sex + " " + student.year + "를 새로운 방으로 넣어요");
					cnt = 1;	// 새방에 학생 집어넣기
				}
			}
		} //for end
		
		System.out.println(roomCnt);
	}
}
