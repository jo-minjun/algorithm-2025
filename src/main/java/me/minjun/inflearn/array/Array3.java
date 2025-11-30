package me.minjun.inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 *
 * <p>가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 *
 * <p>예를 들어 N=5이면
 *
 * <p>Image1.jpg
 *
 * <p>두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 *
 * <p>입력
 *
 * <p>첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
 *
 * <p>두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *
 * <p>세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *
 * <p>출력
 *
 * <p>각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 */
public class Array3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int gameCount = Integer.parseInt(scanner.nextLine());
    List<Integer> inputsA =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    List<Integer> inputsB =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    solution(gameCount, inputsA, inputsB).forEach(System.out::println);
  }

  public static List<String> solution(int gameCount, List<Integer> inputsA, List<Integer> inputsB) {
    List<String> answer = new ArrayList<>();

    for (int i = 0; i < gameCount; i++) {
      // a 가 이긴 경우
      // 1 - 3 = -2
      // 2 - 1 = 1
      // 3 - 2 = 1

      // b 가 이긴 경우
      // 1 - 2 = -1
      // 2 - 3 = -1
      // 3 - 1 = 2

      Integer a = inputsA.get(i);
      Integer b = inputsB.get(i);

      int diff = a - b;
      if (diff == 0) {
        answer.add("D");
      } else if (diff == -2 || diff == 1) {
        answer.add("A");
      } else {
        answer.add("B");
      }
    }

    return answer;
  }
}
