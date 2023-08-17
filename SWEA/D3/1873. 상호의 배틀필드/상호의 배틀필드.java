import java.io.*;
import java.util.*;

public class Solution {

	static int h, w, n; // 맵의 높이, 맵의 너비, 명령어 개수
	static char[][] map; // 게임판
	static char[] command; // 명령어
	static Tank tank;

	static void play(int i) {
		//n개의 명령 수행이 끝나면 게임 종료
		if (i == n) 
			return;
		
		//명령어가 UDLR 중 하나라면 전차 이동
		if (command[i] == 'U') 
			moveTank(tank.x - 1, tank.y, 'U', '^');
		else if (command[i] == 'D') 
			moveTank(tank.x + 1, tank.y, 'D', 'v');
		else if (command[i] == 'L') 
			moveTank(tank.x, tank.y - 1, 'L', '<');
		else if (command[i] == 'R') 
			moveTank(tank.x, tank.y + 1, 'R', '>');
		//명령어가 S면 전차의 방향에 따라 포탄 발사
		else if (command[i] == 'S') 
			switch (tank.dir) {
				case 'U':
					for (int r = tank.x - 1; r >= 0; r--) {
						if (!shoot(r, tank.y))
							break;
					}
					break;
				case 'D':
					for (int r = tank.x + 1; r < h; r++) {
						if (!shoot(r, tank.y))
							break;
					}
					break;
				case 'L':
					for (int c = tank.y - 1; c >= 0; c--) {
						if (!shoot(tank.x, c))
							break;
					}
					break;
				case 'R':
					for (int c = tank.y + 1; c < w; c++) {
						if (!shoot(tank.x, c))
							break;
					}
					break;
			}// switch end

		play(i + 1); // 다음 명령어 수행
	}

	//포탄 발사 게임판을 변경하는 함수
	static boolean shoot(int x, int y) {
		if (map[x][y] == '.' || map[x][y] == '-') // 평지나 물이면 다음 확인
			return true;
		else if (map[x][y] == '*') { // 벽돌 벽 -> 벽을 평지로 바꾸고 포탄 소멸
			map[x][y] = '.';
			return false;
		} else if (map[x][y] == '#') { // 강철 벽 -> 포탄 소멸
			return false;
		}
		return true;
	}

	//전차를 이동하고 게임판 위 전차 모양을 갱신하는 함수
	static void moveTank(int x, int y, char d, char shape) {
		tank.dir = d;	//전차 방향 갱신
		if (checkIndex(x, y) && map[x][y] == '.') {
			map[tank.x][tank.y] = '.'; // 전차가 이동하면 이전위치는 평지로 변경
			// 전차의 좌표 갱신
			tank.x = x;
			tank.y = y;
		}
		map[tank.x][tank.y] = shape; // 게임판 위 전차 모양 갱신
	}

	// 전차가 게임판 위에 있는지 검사하는 함수
	static boolean checkIndex(int x, int y) {
		if (0 <= x && x < h && 0 <= y && y < w)
			return true;
		return false;
	}

	static class Tank {
		int x; // 전차의 x좌표
		int y; // 전차의 y좌표
		char dir; // 전차의 방향
		public Tank(int x, int y, char dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken()); // 맵의 높이
			w = Integer.parseInt(st.nextToken()); // 맵의 너비

			map = new char[h][w]; // 게임판
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				// 전차의 좌표와 방향 찾기
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '^')
						tank = new Tank(i, j, 'U');
					else if (map[i][j] == 'v')
						tank = new Tank(i, j, 'D');
					else if (map[i][j] == '<')
						tank = new Tank(i, j, 'L');
					else if (map[i][j] == '>')
						tank = new Tank(i, j, 'R');
				}
			}

			n = Integer.parseInt(br.readLine()); // 명령어 개수
			command = br.readLine().toCharArray(); // 명령어

			play(0);	//게임 시작

			// 출력
			sb.append("#").append(t).append(" ");
			for (char[] c : map) {
				sb.append(c).append("\n");
			}

		}
		System.out.println(sb.toString());
	}
}
