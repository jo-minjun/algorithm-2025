package me.minjun.inflearn.mapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 설명
 *
 * <p>S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 *
 * <p>아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 *
 * <p>S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 * <p>출력
 *
 * <p>S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 */
public class HashSlidingWindow2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input1 = scanner.nextLine();
    String input2 = scanner.nextLine();

    System.out.println(solution(input1, input2));
  }

  public static int solution(String input1, String input2) {
    int answer = 0;
    int window = input2.length();

    Map<Character, Integer> map = countChar(input2);
    for (int i = 0; i < input1.length() - window + 1; i++) {
      int endIndex = i + window;

      String substring = input1.substring(i, endIndex);
      Map<Character, Integer> map1 = countChar(substring);

      if (map.equals(map1)){
        answer++;
      }
    }

    return answer;
  }

  private static Map<Character, Integer> countChar(String input1) {
    Map<Character, Integer> map = new HashMap<>();

    for (char c : input1.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    return map;
  }
}
