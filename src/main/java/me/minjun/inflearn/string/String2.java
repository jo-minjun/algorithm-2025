package me.minjun.inflearn.string;

import java.util.Locale;
import java.util.Scanner;

/**
 * 설명
 *
 * <p>대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 * <p>입력
 *
 * <p>첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * <p>문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * <p>출력
 *
 * <p>첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 */
public class String2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String inputString = scanner.next();

    System.out.println(findChar(inputString));
  }

  public static String findChar(String inputString) {
    StringBuilder answer = new StringBuilder();

    for (char c : inputString.toCharArray()) {
      if (Character.isLowerCase(c)) {
        answer.append(Character.toUpperCase(c));
      } else {
        answer.append(Character.toLowerCase(c));
      }
    }

    return answer.toString();
  }
}
