import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 1408.24
// kb
// ms
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 현재시간
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int currentHH = Integer.parseInt(st.nextToken());
		int currentMM = Integer.parseInt(st.nextToken());
		int currentSS = Integer.parseInt(st.nextToken());
		// 도현이가 임무를 시작한 시간
		st = new StringTokenizer(br.readLine(), ":");
		int dohyeonHH = Integer.parseInt(st.nextToken());
		int dohyeonMM = Integer.parseInt(st.nextToken());
		int dohyeonSS = Integer.parseInt(st.nextToken());
		
		int currentTime = currentHH*3600 + currentMM*60 + currentSS;
		int dohyeonTime = dohyeonHH*3600 + dohyeonMM*60 + dohyeonSS;
		
//		if(currentTime == 0) currentTime = 24%3600;
//		if(dohyeonTime == 0) dohyeonTime = 24%3600;
		
		int remainTime = 0;
		if(currentTime < dohyeonTime) {
			remainTime = dohyeonTime - currentTime;
		} else {
			remainTime = 24*3600 - (currentTime - dohyeonTime);
		}
		System.out.printf("%02d:%02d:%02d", remainTime/3600, (remainTime%3600)/60, (remainTime%3600)%60 );
	}
}
