import java.util.*; 
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int l, p, v;
		int useDay = 0;  //캠핑장 사용일
		int caseNum = 0;	 // case 번호
		
		while(true) {
			useDay = 0;
			caseNum++;
			l = sc.nextInt();
			p = sc.nextInt();
			v = sc.nextInt();
			
			if(l == 0) {
				break;
			}
			sc.nextLine();
			
			useDay += (v/p)*l;	//연속된 p일 중 캠핑장 사용일 계산
			if(v%p <= l) {		
				useDay += v%p;
			}else {
				useDay += l;
			}
			
			System.out.printf("Case %d: %d%n", caseNum, useDay);
			
		}
    }
}
 