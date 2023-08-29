import java.io.*;
import java.util.*;

public class Main {

	static int r, c, m, sizeSum, maxShark;
	static int[][] map;
	static Shark[] shark;

	// 상어 이동시키기
	static void moveAllShark() {
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (map[i][j] != 0) {
					move(map[i][j], shark[map[i][j]].s);
					map[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < shark.length; i++) {
			if (shark[i] == null || !shark[i].status)
				continue;

			int nr = shark[i].r;
			int nc = shark[i].c;
			if (map[nr][nc] < shark[i].z) {
				if (map[nr][nc] != 0)
					shark[map[nr][nc]].status = false;
				map[nr][nc] = shark[i].z;
			} else {
				shark[i].status = false;
			}
		}

	}// moveAllShark end

	/**
	 * @param num    상어 번호
	 * @param remain 남아있는 이동영역 수
	 */
	static void move(int num, int remain) {
		// 위로 이동
		if (shark[num].d == 1) {
			remain = remain % ((r - 1) * 2);
			if (shark[num].r - remain <= 1) {
				remain = remain - (shark[num].r - 1);
				shark[num].r = 1;
				shark[num].d = 2;
				move(num, remain);
			} else {
				shark[num].r = shark[num].r - remain;
			}
		}
		// 아래로 이동
		else if (shark[num].d == 2) {
			remain = remain % ((r - 1) * 2);
			if (shark[num].r + remain >= r) {
				remain = remain - (r - shark[num].r);
				shark[num].r = r;
				shark[num].d = 1;
				move(num, remain);
			} else {
				shark[num].r = shark[num].r + remain;
			}
		}
		// 오른쪽으로 이동
		else if (shark[num].d == 3) {
			remain = remain % ((c - 1) * 2);
			if (shark[num].c + remain >= c) {
				remain = remain - (c - shark[num].c);
				shark[num].c = c;
				shark[num].d = 4;
				move(num, remain);
			} else {
				shark[num].c = shark[num].c + remain;
			}
		}
		// 왼쪽으로 이동
		else if (shark[num].d == 4) {
			remain = remain % ((c - 1) * 2);
			if (shark[num].c - remain <= 1) {
				remain = remain - (shark[num].c - 1);
				shark[num].c = 1;
				shark[num].d = 3;
				move(num, remain);
			} else {
				shark[num].c = shark[num].c - remain;
			}
		}
	} // move end

	// 낚시하기
	static void fishing(int kingC) {
		for (int i = 0; i <= r; i++) {
			if (map[i][kingC] != 0) {
				sizeSum += map[i][kingC];
				shark[map[i][kingC]].status = false;
				map[i][kingC] = 0;
				break;
			}
		}
	}

	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		boolean status;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.status = true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if(m==0) {
			System.out.println(0);
			return;
		}

		// 상어 정보 입력
		shark = new Shark[10001];
		maxShark = 0;
		map = new int[r + 1][c + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sharkR = Integer.parseInt(st.nextToken()); // 행좌표
			int sharkC = Integer.parseInt(st.nextToken()); // 열좌표
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 이동방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			maxShark = maxShark < z ? z : maxShark;
			shark[z] = new Shark(sharkR, sharkC, s, d, z);
			map[sharkR][sharkC] = z;
		}

		shark = Arrays.copyOf(shark, maxShark + 1);

		sizeSum = 0;
		for (int i = 1; i <= c; i++) {
			fishing(i);// 낚시
			moveAllShark(); // 상어들 이동
		}

		System.out.println(sizeSum);
	}
}