import java.util.*;

class Solution {
	public  String[] solution(String[]  players, String[] callings) {
        String[] answer = new String[players.length]; 
		
		HashMap<String, Integer> nameKey = new HashMap<>();
		HashMap<Integer, String> rankKey = new HashMap<>();
				 
		for (int i = 0; i < players.length; i++) {
			nameKey.put(players[i], i);
			rankKey.put(i, players[i]);
		}
				 
		for (int i = 0; i < callings.length; i++) { 
			int beforeRank = nameKey.get(callings[i]);
			String beforePlayer = rankKey.get(beforeRank-1);
			
			nameKey.put(callings[i], beforeRank-1);
			nameKey.put(beforePlayer, beforeRank);
			
			rankKey.put(beforeRank, beforePlayer);
			rankKey.put(beforeRank-1, callings[i]);
//			System.out.println(callings[i] + beforeRank + beforePlayer);
		}
		
//		System.out.println(nameKey);
//		System.out.println(rankKey);
		
		List<Integer> rank = new ArrayList<>(rankKey.keySet());
		Collections.sort(rank);

		for (int i = 0; i < rank.size(); i++) {
			answer[i] = rankKey.get(rank.get(i));
		}
//		for (String st : answer) {
//			System.out.println(st);
//		}
		
		return answer;
    }
}