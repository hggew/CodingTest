import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	//학생의 정보를 담은 클래스 
	public static class Student {
		String name;
		int korean;
		int english;
		int math;

		public Student(String name, int korean, int english, int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		//학생클래스를 저장할 리스트 
		List<Student> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			list.add(new Student(name, korean, english, math));

		}

		//정렬
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) { // 내림차순

				if (o1.korean == o2.korean) {
					if (o1.english == o2.english) {
						if (o1.math == o2.math) {
							// 국어, 영어, 수학이 같다면 이름 사전순
							return o1.name.compareTo(o2.name);
						}
						// 국어,영어가 같다면 수학 내림차순
						return Integer.compare(o1.math, o2.math) * -1;
					}
					// 국어가 같다면 영어 오름차순
					return o1.english - o2.english;
				}

				// x>y:양수 x<y:음수 x==y:0
				// 국어점수 내림차순
				return Integer.compare(o1.korean, o2.korean) * -1; 
			}
		});


		for (Student s : list) {
			System.out.println(s.name);
		}

	}

}
