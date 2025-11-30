package me.minjun.inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 *
 * <p>Image1.jpg
 *
 * <p>N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 *
 * <p>두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * <p>출력
 *
 * <p>최대합을 출력합니다.
 */
public class Array9 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    List<List<Integer>> inputs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      inputs.add(
          Arrays.stream(scanner.nextLine().split(" "))
              .map(Integer::parseInt)
              .collect(Collectors.toList()));
    }

    System.out.println(solution(n, inputs));
  }

  public static int solution(int n, List<List<Integer>> inputs) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      List<Integer> input = inputs.get(i);
      max = Math.max(max, input.stream().mapToInt(Integer::intValue).sum());

      int sum = 0;
      for (int j = 0; j < n; j++) {
        sum += inputs.get(j).get(i);
      }
      max = Math.max(max, sum);
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += inputs.get(i).get(i);
    }
    max = Math.max(max, sum);

    sum = 0;
    for (int i = 0; i < n; i++) {
      int j = n - i - 1;
      sum += inputs.get(j).get(i);
    }
    max = Math.max(max, sum);

    return max;
  }
}
