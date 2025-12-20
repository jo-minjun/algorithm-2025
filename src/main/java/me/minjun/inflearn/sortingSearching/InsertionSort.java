package me.minjun.inflearn.sortingSearching;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 *
 * <p>정렬하는 방법은 삽입정렬입니다.
 *
 * <p>입력
 *
 * <p>첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 *
 * <p>두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
 *
 * <p>출력
 *
 * <p>오름차순으로 정렬된 수열을 출력합니다.
 */
public class InsertionSort {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    scanner.nextLine();
    List<Integer> input =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

    System.out.println(
        solution(n, input).stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  public static List<Integer> solution(int n, List<Integer> input) {
    for (int i = 1; i < n; i++) {
      int tmp = input.get(i);
      int j;
      for (j = i - 1; j >= 0; j--) {
        if (input.get(j) > tmp) {
          input.set(j + 1, input.get(j));
        } else {
          break;
        }
      }
      input.set(j + 1, tmp);
    }

    return input;
  }
}
