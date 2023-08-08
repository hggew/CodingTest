import java.util.*;

class Solution {
	public  String[] solution(String[]  players, String[] callings) {
        String[] answer = new String[players.length];

		// key-선수이름, value-순위 : 추월 전 순위를 가져올 때 사용
		HashMap<String, Integer> nameKey = new HashMap<>();
		// key-순위, value-선수이름 : 추월 전 내 앞 선수 이름을 가져올 때 사용
        // 랭크를 오름차순으로 정렬하지 않기 위해 TreeMap 사용
		Map<Integer, String> rankKey = new TreeMap<>();

		for (int i = 0; i < players.length; i++) {
			nameKey.put(players[i], i);
			rankKey.put(i, players[i]);
		}

		// callings의 원소를 하나씩 보면서 순위 갱신
		for (int i = 0; i < callings.length; i++) {
			// 추월전 순위, 추월 전 앞선수이름을 가져옴
			int beforeRank = nameKey.get(callings[i]);
			String beforePlayer = rankKey.get(beforeRank - 1);

			// 순위 갱신
			nameKey.put(callings[i], beforeRank - 1);
			nameKey.put(beforePlayer, beforeRank);

			rankKey.put(beforeRank, beforePlayer);
			rankKey.put(beforeRank - 1, callings[i]);
		}

		//rankKey 해시맵의 value를 answer로 저장
		answer = rankKey.values().toArray(new String [players.length]);
		 

		return answer;
    }
}