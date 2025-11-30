package me.minjun.inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 *
 * <p>(첫 번째 수는 무조건 출력한다)
 *
 * <p>입력
 *
 * <p>첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 * <p>출력
 *
 * <p>자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 */
public class Array1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    scanner.nextLine();
    String s = scanner.nextLine();
    List<Integer> inputs =
        Arrays.stream(s.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    String answer = solution(inputs).stream().map(String::valueOf).collect(Collectors.joining(" "));
    System.out.println(answer);
  }

  public static List<Integer> solution(List<Integer> inputs) {
    int beforeValue = Integer.MIN_VALUE;
    List<Integer> answer = new ArrayList<>();

    for (int input: inputs){
      if (beforeValue < input) {
        answer.add(input);
      }
      beforeValue = input;
    }

    return answer;
  }
}
