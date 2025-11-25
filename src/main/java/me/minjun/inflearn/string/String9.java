package me.minjun.inflearn.string;

import java.util.Scanner;

/**
 * 설명
 *
 * <p>문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 *
 * <p>만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 *
 * <p>추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * <p>출력
 *
 * <p>첫 줄에 자연수를 출력합니다.
 */
public class String9 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next();

    System.out.println(extractNumber(input));
  }

  public static int extractNumber(String input) {
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char character = input.charAt(i);
      if (Character.isDigit(character)){
        answer.append(character);
      }
    }

    return Integer.parseInt(answer.toString());
  }
}
