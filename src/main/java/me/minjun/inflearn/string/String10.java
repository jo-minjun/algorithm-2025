package me.minjun.inflearn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * <p>입력
 *
 * <p>첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 *
 * <p>문자열의 길이는 100을 넘지 않는다.
 *
 * <p>출력
 *
 * <p>첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 */
public class String10 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next();
    char target = scanner.next().charAt(0);

    String result =
        calcDistance(input, target).stream().map(String::valueOf).collect(Collectors.joining(" "));
    System.out.println(result);
  }

  // O(n^2) 해법
  //  public static List<Integer> calcDistance(String inputString, char target) {
  //    List<Integer> answer = new ArrayList<>();
  //
  //    for (int i = 0; i < inputString.length(); i++) {
  //      char inputChar = inputString.charAt(i);
  //      if (inputChar == target) {
  //        answer.add(0);
  //      } else {
  //        String subString = inputString.substring(i);
  //        int after = subString.indexOf(target) == -1 ? Integer.MAX_VALUE :
  // subString.indexOf(target);
  //        int before = answer.isEmpty() ? Integer.MAX_VALUE : answer.get(answer.size() - 1) + 1;
  //
  //        answer.add(Math.min(before, after));
  //      }
  //    }
  //
  //    return answer;
  //  }

  // O(n) 해법
  public static List<Integer> calcDistance(String inputString, char target) {
    int length = inputString.length();

    List<Integer> answer = new ArrayList<>(length);

    for (int i = 0; i < length; i++) {
      answer.add(length + 1);
    }

    int distance = length + 1;
    for (int i = 0; i < length; i++) {
      char ch = inputString.charAt(i);
      if (ch == target) {
        distance = 0;
      } else {
        distance++;
      }
      answer.set(i, distance);
    }

    distance = length + 1;
    for (int i = length - 1; i >= 0; i--) {
      char ch = inputString.charAt(i);
      if (ch == target) {
        distance = 0;
      } else {
        distance++;
      }
      answer.set(i, Math.min(answer.get(i), distance));
    }

    return answer;
  }

}
