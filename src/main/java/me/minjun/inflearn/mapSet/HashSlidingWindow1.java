package me.minjun.inflearn.mapSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 *
 * <p>각 구간별로 구하라고 했습니다.
 *
 * <p>만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 *
 * <p>20 12 20 10 23 17 10
 *
 * <p>각 연속 4일간의 구간의 매출종류는
 *
 * <p>첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 *
 * <p>두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 *
 * <p>세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 *
 * <p>네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 *
 * <p>N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 *
 * <p>매출액의 종류를 출력하는 프로그램을 작성하세요.
 *
 * <p>입력
 *
 * <p>첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 *
 * <p>두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * <p>출력
 *
 * <p>첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
 */
public class HashSlidingWindow1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int k = scanner.nextInt();
    scanner.nextLine();
    List<Integer> input =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

    System.out.println(solution(k, input).stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  public static List<Integer> solution(int window, List<Integer> input) {
    List<Integer> answer = new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < window; i++) {
      map.put(input.get(i), map.getOrDefault(input.get(i), 0) + 1);
    }
    answer.add(map.size());

    for (int i = window; i < input.size(); i++) {
      int startIndex = i - window;
      Integer startValue = input.get(startIndex);

      map.put(startValue, map.get(startValue) - 1);
      if (map.get(startValue) <= 0) {
        map.remove(startValue);
      }

      Integer currentValue = input.get(i);
      map.put(currentValue, map.getOrDefault(currentValue, 0) + 1);

      answer.add(map.size());
    }

    return answer;
  }
}
