package me.minjun.inflearn.string;

import java.util.Locale;
import java.util.Scanner;

/**
 * 설명
 *
 * <p>한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 *
 * <p>대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
 *
 * <p>문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * <p>출력
 *
 * <p>첫 줄에 해당 문자의 개수를 출력한다.
 */
public class String1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String inputString = scanner.next();
    String target = scanner.next();

    System.out.println(findChar(inputString, target));
  }

  public static int findChar(String inputString, String target) {
    char targetChar = target.toLowerCase(Locale.ROOT).toCharArray()[0];
    int answer = 0;

    for (char inputChar : inputString.toLowerCase(Locale.ROOT).toCharArray()){
      if (inputChar == targetChar){
        answer++;
      }
    }

    return answer;
  }
}
