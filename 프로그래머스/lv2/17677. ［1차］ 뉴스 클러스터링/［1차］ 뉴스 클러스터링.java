import java.util.*;

class Solution {
    // 문자가 알파벳인지 체크하는 함수
	public static boolean checkAlphabet(char c) {
		if (c == ' ')
			return false;
		else if (c < 'A' || c > 'Z')
			return false;
		return true;
	}

	public static int solution(String str1, String str2) {
		int answer = 0;
		HashMap<String, Integer> hm1 = new HashMap<>();
		HashMap<String, Integer> hm2 = new HashMap<>();

        //연산이 쉽도록 대문자로 변경
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		// str1 다중집합으로 변경
		for (int i = 0; i < str1.length() - 1; i++) {
			if (checkAlphabet(str1.charAt(i)) & checkAlphabet(str1.charAt(i + 1)))
				hm1.put(str1.substring(i, i + 2), hm1.getOrDefault(str1.substring(i, i + 2), 0) + 1);
			else
				continue;
		}
		// str2 다중집합으로 변경
		for (int i = 0; i < str2.length() - 1; i++) {
			if (checkAlphabet(str2.charAt(i)) & checkAlphabet(str2.charAt(i + 1)))
				hm2.put(str2.substring(i, i + 2), hm2.getOrDefault(str2.substring(i, i + 2), 0) + 1);
			else
				continue;
		}
	
        //교집합, 합집합에서 다중집합원소의 개수를 구할 때 사용
		int hmValue1 =0 ;
		int hmValue2 =0 ;
		
		// 교집합 구하기
		Set<String> intersection = new HashSet<>(hm1.keySet());
		intersection.retainAll(hm2.keySet());
		double intersectionSize = intersection.size();
		//다중집합 개수 구하기
        for (String s : intersection) {
			hmValue1 = hm1.get(s);
			hmValue2 = hm2.get(s);
            if (hmValue1 > 1 && hmValue2 > 1)
				intersectionSize += Math.min(hmValue1, hmValue2) - 1;
		}

		// 합집합 구하기
		Set<String> union = new HashSet<>(hm1.keySet());
		union.addAll(hm2.keySet());
		double unionSize = union.size();
        //다중집합 개수 구하기 - 원소가 hm1, hm2 집합에 있을 때에만 개수를 가져옴	
		for (String s : union) {
			if(hm1.containsKey(s))
				hmValue1 = hm1.get(s);
			else
				hmValue1 = 0;
			if(hm2.containsKey(s))
				hmValue2 = hm2.get(s);
			else
				hmValue2 = 0;
			unionSize += Math.max(hmValue1, hmValue2) - 1;
		}

		// int로 형변환
		answer = (int) (65536 * (intersectionSize / unionSize));
		//교집합, 합집합이 모두 공집합일 경우
        if(intersectionSize== 0 && unionSize == 0)
			answer = 65536;

		return answer;
    }
}