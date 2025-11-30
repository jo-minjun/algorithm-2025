package me.minjun.inflearn.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Array8 {

  /**
   * 설명
   *
   * <p>N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
   *
   * <p>같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
   *
   * <p>즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
   *
   * <p>입력
   *
   * <p>첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
   *
   * <p>출력
   *
   * <p>입력된 순서대로 등수를 출력한다.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    scanner.nextLine();
    List<Integer> inputs =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    String answer = solution(inputs).stream().map(String::valueOf).collect(Collectors.joining(" "));
    System.out.println(answer);
  }

  public static List<Integer> solution(List<Integer> inputs) {
    Map<Integer, Integer> scoreRankMap = new HashMap<>();

    List<Integer> orderByScore =
        inputs.stream().sorted(((o1, o2) -> o2 - o1)).collect(Collectors.toList());

    for (int i = 0; i < orderByScore.size(); i++) {
      int rank = i + 1;
      if (scoreRankMap.containsKey(orderByScore.get(i))) {
        continue;
      }
      scoreRankMap.put(orderByScore.get(i), rank);
    }

    return inputs.stream().map(scoreRankMap::get).collect(Collectors.toList());
  }
}
