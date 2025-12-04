package me.minjun.inflearn.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 설명
 *
 * <p>괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 *
 * <p>(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * <p>입력
 *
 * <p>첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 *
 * <p>출력
 *
 * <p>첫 번째 줄에 YES, NO를 출력한다.
 */
public class Stack1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    System.out.println(solution(input));
  }

  public static String solution(String input) {
    Stack<Character> stack = new Stack<>();

    for (char c : input.toCharArray()) {
      if (c == '(') {
        stack.add(c);
      } else if (c == ')' && !stack.isEmpty()) {
        stack.pop();
      } else {
        return "NO";
      }
    }

    if (stack.isEmpty()) {
      return "YES";
    }

    return "NO";
  }
}
