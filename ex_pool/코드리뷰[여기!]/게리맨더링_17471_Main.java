import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13532 kb
// 104 ms
public class 게리맨더링_17471_Main {
	
	static int n, populatSum, minGap = Integer.MAX_VALUE;
	static int[] population;
	static ArrayList<Integer>[] adjList;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		population = new int[n];
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			populatSum += population[i];
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		isSelected = new boolean[n];
		isSelected[0] = true;	// true 선거구 선택
		subset(1, 1);
		System.out.println(minGap != Integer.MAX_VALUE ? minGap : -1);
	}
	
	public static void subset(int idx, int trueCnt) {
		if(trueCnt == n) return;
		if(idx == n) {
			int falseCnt = n-trueCnt;
			int[] trueGroup = new int[trueCnt];
			int[] falseGroup = new int[falseCnt];
			int t = 0, f = 0, num = 0;
			for (boolean b : isSelected) {
				if(b) trueGroup[t++] = num++;
				else falseGroup[f++] = num++;
			}
			if(isPossible(trueCnt, falseCnt, trueGroup, falseGroup)) {
				Calc(populatSum);
			}
			return;
		}
		isSelected[idx] = true;
		subset(idx+1, trueCnt+1);
		isSelected[idx] = false;
		subset(idx+1, trueCnt);
	}
	
	public static boolean isPossible(int trueCnt, int falseCnt, int[] trueGroup, int[] falseGroup) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] isChecked = new boolean[n];
		queue.add(trueGroup[0]);
		isChecked[trueGroup[0]] = true;
		
		int TGcnt = 0;
		while(!queue.isEmpty()) {
			int start = queue.poll();
			TGcnt++;
			for(Integer end : adjList[start]) {
				for (int i = 0; i < trueCnt; i++) {
					if(!isChecked[end] && end == trueGroup[i]) {
						isChecked[end] = true;
						queue.add(end);
					}
				}
			}
		}
		if(TGcnt != trueCnt) return false;
		
		queue.add(falseGroup[0]);
		isChecked[falseGroup[0]] = true;
		
		int FGcnt = 0;
		while(!queue.isEmpty()) {
			int start = queue.poll();
			FGcnt++;
			for(Integer end : adjList[start]) {
				for (int i = 0; i < falseCnt; i++) {
					if(!isChecked[end] && end == falseGroup[i]) {
						isChecked[end] = true;
						queue.add(end);
					}
				}
			}
		}
		if(FGcnt != falseCnt) return false;
		return true;
	}
	
	public static void Calc(int sum) {
		for (int i = 0; i < n; i++) {
			if(isSelected[i]) sum -= population[i];
		}
		minGap = Math.min(minGap, Math.abs(populatSum-sum*2));
	}
}
