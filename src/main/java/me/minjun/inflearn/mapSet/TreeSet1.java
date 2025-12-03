package me.minjun.inflearn.mapSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 *
 * <p>현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 *
 * <p>기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 *
 * <p>만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
 *
 * <p>출력
 *
 * <p>첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
 */
public class TreeSet1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int k = scanner.nextInt();
    scanner.nextLine();
    List<Integer> input =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

    System.out.println(solution(k, input));
  }

  public static int solution(int n, List<Integer> input) {
    int size = input.size();
    Set<Integer> set = new TreeSet<>();

    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        for (int k = j + 1; k < size; k++) {
          int value = input.get(i) + input.get(j) + input.get(k);
          set.add(value);
        }
      }
    }

    int index = set.size() - n;
    if (index < 0) {
      return -1;
    }
    return (new ArrayList<>(set)).get(index);
  }
}
