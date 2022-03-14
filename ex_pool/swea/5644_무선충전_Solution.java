import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/*
/ 총 테스트 케이스 개수 T=5
// 첫 번째 테스트 케이스: M=20, A=3
// 사용자A의 이동 정보
// 사용자B의 이동 정보
// AP 1의 정보 (4, 4), C1=1, P1=100
// AP 2의 정보 (7, 10), C2=3, P2=40
// AP 3의 정보 (6, 3), C3=2, P3=70
 */

public class Solution {
	
	static class ChargeZone implements Comparable<ChargeZone> {
		int apPower, apNo;

		public ChargeZone(int apPower, int apNo) {
			super();
			this.apPower = apPower;
			this.apNo = apNo;
		}

		@Override
		public int compareTo(ChargeZone o) {
			return this.apPower != o.apPower? o.apPower - this.apPower : this.apNo - o.apNo;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	static int TC, M, A;
	static Queue<Integer> Amove = new LinkedList<Integer>();
	static Queue<Integer> Bmove = new LinkedList<Integer>();
	static int[][] AP;
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				Amove.offer(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				Bmove.offer(Integer.parseInt(st.nextToken()));
			}
			
			AP = new int[A][4];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < 4; j++) {
					AP[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#"+tc+" ");
			chargePhone(1, 1, 10, 10, 0);
		}
		System.out.println(sb.toString());
		
	}
	static int n = 0;
	public static void chargePhone(int Ax, int Ay, int Bx, int By, int chargeSum) {
		
		PriorityQueue<ChargeZone> AChargeZone = new PriorityQueue<ChargeZone>();
		PriorityQueue<ChargeZone> BChargeZone = new PriorityQueue<ChargeZone>();
		
		for (int i = 0; i < A; i++) {
			int Ad = Math.abs(Ax - AP[i][0]) + Math.abs(Ay - AP[i][1]);
			int Bd = Math.abs(Bx - AP[i][0]) + Math.abs(By - AP[i][1]);
			if(Ad <= AP[i][2]) AChargeZone.offer(new ChargeZone(AP[i][3], i));
			if(Bd <= AP[i][2]) BChargeZone.offer(new ChargeZone(AP[i][3], i));
		}
		if (!AChargeZone.isEmpty() && !BChargeZone.isEmpty()) {
			if (AChargeZone.peek().apPower != BChargeZone.peek().apPower) {
				chargeSum += AChargeZone.poll().apPower + BChargeZone.poll().apPower;
			} else {
				if (AChargeZone.peek().apNo != BChargeZone.peek().apNo) {
					chargeSum += AChargeZone.poll().apPower + BChargeZone.poll().apPower;
				} else {
					int k = AChargeZone.poll().apPower;
					BChargeZone.poll();
					if(AChargeZone.isEmpty() && BChargeZone.isEmpty()) {
						chargeSum += k;
					} else if(!AChargeZone.isEmpty() && BChargeZone.isEmpty()) {
						chargeSum += k + AChargeZone.poll().apPower;
					} else if(AChargeZone.isEmpty() && !BChargeZone.isEmpty()) {
						chargeSum += k + BChargeZone.poll().apPower;
					} else {
						if(AChargeZone.peek().apPower >= BChargeZone.peek().apPower) {
							chargeSum += k + AChargeZone.poll().apPower;
						} else {
							chargeSum += k + BChargeZone.poll().apPower;
						}
					}
				}
			}
		} else if (!AChargeZone.isEmpty() && BChargeZone.isEmpty()) {
			chargeSum += AChargeZone.poll().apPower;
		} else if (AChargeZone.isEmpty() && !BChargeZone.isEmpty()) {
			chargeSum += BChargeZone.poll().apPower;
		}
		
//		System.out.println("T : " + (n++) + ", 합 :" + chargeSum);
		
		if(Amove.isEmpty()) {
			sb.append(chargeSum + "\n");
			return;
		}
		
		int Apoll = Amove.poll();
		int Bpoll = Bmove.poll();
		
		Ax += dc[Apoll];
		Ay += dr[Apoll];
		Bx += dc[Bpoll];
		By += dr[Bpoll];
		chargePhone(Ax, Ay, Bx, By, chargeSum);
	}
}