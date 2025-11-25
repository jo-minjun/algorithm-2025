package me.minjun.inflearn.string;

import java.util.Scanner;

/**
 * 설명
 *
 * <p>한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 *
 * <p>문장속의 각 단어는 공백으로 구분됩니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 * <p>출력
 *
 * <p>첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
 */
public class String3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String inputString = scanner.nextLine();

    System.out.println(findLongestWord(inputString));
  }

  public static String findLongestWord(String inputString) {
    String[] words = inputString.split(" ");
    String answer = words[0];

    for (int i = 1; i < words.length; i++){
      if (answer.length() < words[i].length()){
        answer = words[i];
      }
    }

    return answer;
  }
}
