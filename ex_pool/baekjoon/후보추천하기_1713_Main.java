import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 12032 kb
// 108 ms
public class 후보추천하기_1713_Main {
	
	public static class Student implements Comparable<Student> {
		int no, cnt, time;

		public Student(int no, int cnt, int time) {
			super();
			this.no = no;
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(Student o) {
			// 3. 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 
			// 그 자리에 새롭게 추천받은 학생의 사진을 게시한다. 이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 
			// 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
			// => cnt 오름차순, time 오름차순
			return this.cnt!=o.cnt ? this.cnt-o.cnt : this.time-o.time;
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
		
		// 1. 학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
		List<Student> reco = new ArrayList<Student>();
		boolean isExisted;
		for (int i = 0; i < M; i++) {
			isExisted = false;
			for (int j = 0; j < reco.size(); j++) {
				// 4. 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
				if(reco.get(j).no == numbers[i]) {
					isExisted = true;
					reco.get(j).cnt++;
//					reco.get(j).time = i; // 시간 업데이트 X
					break;
				}
			}
			// 2. 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
			if(!isExisted) {
				// 비어있는 사진틀이 없는 경우
				if(reco.size() == N) {
					// 3. 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 
					// 그 자리에 새롭게 추천받은 학생의 사진을 게시한다. 이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 
					// 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
					 Collections.sort(reco);
					 reco.remove(0);
				}
				// 2. 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
				reco.add(new Student(numbers[i], 1, i));
			}
		}//for i end
		
		//no 오름차순 정렬을 위한 다른 방법 있을까요?
//		List<Integer> answer = new ArrayList<Integer>();
//		for (int i = 0; i < reco.size(); i++) {
//			answer.add(reco.get(i).no);
//		}
//		Collections.sort(answer);
		
		//해결방안 1
//		Collections.sort(reco, (o1, o2) -> (o1.no - o2.no));
		
		//해결방안 2
		Collections.sort(reco, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.no - o2.no;
			}
		});
		
		
		for (Student stu : reco) {
			sb.append(stu.no).append(" ");
		}
		System.out.println(sb.toString());
	}
}
