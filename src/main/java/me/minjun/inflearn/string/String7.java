package me.minjun.inflearn.string;

import java.util.Scanner;

/**
 * 설명
 *
 * <p>앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 *
 * <p>문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *
 * <p>단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * <p>출력
 *
 * <p>첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 */
public class String7 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next();

    System.out.println(isPalindrome(input));
  }

  public static String isPalindrome(String input) {
    int left = 0;
    int right = input.length() - 1;

    char[] inputCharArray = input.toLowerCase().toCharArray();
    while (left < right){
      if (inputCharArray[left] != inputCharArray[right]){
        return "NO";
      }
      left++;
      right--;
    }

    return "YES";
  }
}
