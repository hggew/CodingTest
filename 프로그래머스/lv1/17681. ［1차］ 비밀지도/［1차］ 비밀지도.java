class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        //전체지도를 저장할 배열. n만큼 할당
		String[] answer = new String[n];

		//arr1과 arr2를 돌며 같은 인덱스를 가진 원소를 | 연산
		//각 원소를 이진수로 변환하여 이진수의 각 요소가 1일 경우 1로 저장 -> 반환값은 십진수
		//십진수로 들어온 값을 다시 이진수 문자열로 변환 -> Integer.toBinaryString 사용
		//최종 지도는 0과1로 이루어져 있음 -> 0은 공백 1은 #으로 대치
		for (int i = 0; i < n; i++) { 
			String row = Integer.toBinaryString(arr1[i] | arr2[i]);
			answer[i] = row.replaceAll("1", "#").replaceAll("0"," ");
            
			// 최종지도에서 길이가 n보다 작다면 맨앞이 0이고 생략된 것이므로 공백 추가
			while (answer[i].length() != n) {
				answer[i] = " " + answer[i];
			}			
		} 
		  
		return answer;
    }
}