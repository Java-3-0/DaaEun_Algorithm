import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 2527.직사각형
// kb
// ms
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(x1 < x2) {
				if(x2 < p1) {
					if (y1 < y2) {
						if (y2 < q1) {
							System.out.println("a");
						} else if (y2 == q1) {
							System.out.println("b");
						} else {
							System.out.println("d");
						}
					} else if (y1 == y2) {
						System.out.println("a");
					} else {
						if (y1 < q2) {
							System.out.println("a");
						} else if (y1 == q2) {
							System.out.println("b");
						} else {
							System.out.println("d");
						}
					}
				} else if(x2 == p1) {
					if(y1 < y2) {
						if(y2 < q1) {
							System.out.println("b");
						} else if(y2 == q1) {
							System.out.println("c");
						} else {
							System.out.println("d");
						}
					}else if(y1 == y2) {
						System.out.println("b");
					}else{
						if(y1 < q2) {
							System.out.println("b");
						} else if(y1 == q2) {
							System.out.println("c");
						} else {
							System.out.println("d");
						}
					}
				} else {
					System.out.println("d");
				}
			}else if(x1 == x2) {
				System.out.println("a");
			}else {
				if(x1 < p2) {
					if (y2 < y1) {
						if (y1 < q2) {
							System.out.println("a");
						} else if (y1 == q2) {
							System.out.println("b");
						} else {
							System.out.println("d");
						}
					} else if (y2 == y1) {
						System.out.println("a");
					} else {
						if (y2 < q1) {
							System.out.println("a");
						} else if (y2 == q1) {
							System.out.println("b");
						} else {
							System.out.println("d");
						}
					}
				} else if(x1 == p2) {
					if(y2 < y1) {
						if(y1 < q2) {
							System.out.println("b");
						} else if(y1 == q2) {
							System.out.println("c");
						} else {
							System.out.println("d");
						}
					}else if(y2 == y1) {
						System.out.println("b");
					}else{
						if(y2 < q1) {
							System.out.println("b");
						} else if(y2 == q1) {
							System.out.println("c");
						} else {
							System.out.println("d");
						}
					}
				} else {
					System.out.println("d");
				}
			}
		}
	}
}
