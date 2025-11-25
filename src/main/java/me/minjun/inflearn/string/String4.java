package me.minjun.inflearn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 설명
 *
 * <p>N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 * <p>입력
 *
 * <p>첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * <p>두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 * <p>출력
 *
 * <p>N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 */
public class String4 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> inputs = new ArrayList<>();
    int inputSize = scanner.nextInt();
    for (int i = 0; i < inputSize; i++) {
      inputs.add(scanner.next());
    }

    reverseString(inputs).forEach(System.out::println);
  }

  public static List<String> reverseString(List<String> inputs) {
    List<String> answer = new ArrayList<>();

    for (String input : inputs) {
      StringBuilder result = new StringBuilder();
      char[] inputCharArray = input.toCharArray();
      for (int i = inputCharArray.length - 1; i >= 0; i--) {
        char character = inputCharArray[i];
        result.append(character);
      }

      answer.add(result.toString());
    }

    return answer;
  }
}
