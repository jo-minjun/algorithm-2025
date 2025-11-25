package me.minjun.inflearn.string;

import java.util.Scanner;

/**
 * 설명
 *
 * <p>알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 *
 * <p>문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 *
 * <p>단 반복횟수가 1인 경우 생략합니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * <p>출력
 *
 * <p>첫 줄에 압축된 문자열을 출력한다.
 */
public class String11 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next();

    System.out.println(compress(input));
  }

  public static String compress(String input) {
    StringBuilder answer = new StringBuilder();

    int count = 1;
    char beforeChar = input.charAt(0);
    for (int i = 1; i < input.length(); i++) {
      if (beforeChar == input.charAt(i)) {
        count++;
      } else {
        answer.append(beforeChar);
        if (count > 1) {
          answer.append(count);
        }

        count = 1;
        beforeChar = input.charAt(i);
      }
    }
    answer.append(beforeChar);
    if (count > 1) {
      answer.append(count);
    }

    return answer.toString();
  }
}
