package me.minjun.inflearn.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 설명
 *
 * <p>입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 * <p>입력
 *
 * <p>첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * <p>출력
 *
 * <p>남은 문자만 출력한다.
 */
public class Stack2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    System.out.println(solution(input));
  }

  public static String solution(String input) {
    StringBuilder answer = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (char c : input.toCharArray()) {
      if  (c != '(' && c != ')' && stack.isEmpty()) {
        answer.append(c);
        continue;
      }

      if (c == '(') {
        stack.add(c);
      } else if (c == ')') {
        stack.pop();
      }
    }

    return answer.toString();
  }
}
