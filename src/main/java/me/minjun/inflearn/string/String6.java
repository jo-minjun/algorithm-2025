package me.minjun.inflearn.string;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 *
 * <p>중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 * <p>출력
 *
 * <p>첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 */
public class String6 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next();

    System.out.println(removeDuplicated(input));
  }

  public static String removeDuplicated(String input) {
    Set<Character> appearedSet = new LinkedHashSet<>();
    char[] inputChars = input.toCharArray();

    for (char character : inputChars) {
      if (appearedSet.contains(character)){
        continue;
      }

      appearedSet.add(character);
    }

    return appearedSet.stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
