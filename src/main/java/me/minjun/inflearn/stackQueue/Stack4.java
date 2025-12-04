package me.minjun.inflearn.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 설명
 *
 * <p>후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 *
 * <p>만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 *
 * <p>식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 *
 * <p>출력
 *
 * <p>연산한 결과를 출력합니다.
 */
public class Stack4 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    System.out.println(solution(input));
  }

  public static int solution(String input) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '+') {
        int value1 = stack.pop();
        int value2 = stack.pop();
        stack.add(value1 + value2);
      } else if(c == '-'){
        int value1 = stack.pop();
        int value2 = stack.pop();
        stack.add(value2 - value1);
      } else if(c == '*'){
        int value1 = stack.pop();
        int value2 = stack.pop();
        stack.add(value2 * value1);
      } else if (c == '/'){
        int value1 = stack.pop();
        int value2 = stack.pop();
        stack.add(value2 / value1);
      } else {
        stack.add(Character.getNumericValue(c));
      }
    }

    return stack.pop();
  }
}
