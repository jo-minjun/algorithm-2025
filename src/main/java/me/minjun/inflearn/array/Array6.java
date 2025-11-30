package me.minjun.inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Array6 {

  /**
   * 설명
   *
   * <p>N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
   *
   * <p>예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
   *
   * <p>첫 자리부터의 연속된 0은 무시한다.
   *
   * <p>입력
   *
   * <p>첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
   *
   * <p>각 자연수의 크기는 100,000를 넘지 않는다.
   *
   * <p>출력
   *
   * <p>첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    scanner.nextLine();
    List<String> inputs = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

    String answer = solution(inputs).stream().map(String::valueOf).collect(Collectors.joining(" "));
    System.out.println(answer);
  }

  public static List<Integer> solution(List<String> inputs) {
    List<Integer> reversed =
        inputs.stream()
            .map(input -> new StringBuilder(input).reverse().toString())
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    int limit = Collections.max(reversed);

    List<Boolean> sieve = new ArrayList<>();
    sieve.add(false);
    sieve.add(false);
    for (int i = 2; i <= limit; i++) {
      sieve.add(true);
    }

    Set<Integer> sieveSet = new HashSet<>();
    for (int i = 2; i <= limit; i++) {
      if (sieve.get(i)) {
        sieveSet.add(i);
        for (int j = i * 2; j <= limit; j = j + i) {
          sieve.set(j, false);
        }
      }
    }

    return reversed.stream().filter(sieveSet::contains).collect(Collectors.toList());
  }
}
