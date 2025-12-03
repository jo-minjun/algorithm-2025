package me.minjun.inflearn.towpointerSlidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>N개의 수로 이루어진 수열이 주어집니다.
 *
 * <p>이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 *
 * <p>만약 N=8, M=6이고 수열이 다음과 같다면
 *
 * <p>1 2 1 3 1 1 1 2
 *
 * <p>합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 *
 * <p>입력
 *
 * <p>첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
 *
 * <p>수열의 원소값은 1,000을 넘지 않는 자연수이다.
 *
 * <p>출력
 *
 * <p>첫째 줄에 경우의 수를 출력한다.
 */
public class SlidingWindow2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int target = scanner.nextInt();
    scanner.nextLine();

    List<Integer> array =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    System.out.println(solution(target, array));
  }

  public static int solution(int target, List<Integer> array) {
    int answer = 0;
    int sum = 0;
    int firstIndex = 0;
    for (int i = 0; i < array.size(); i++) {
      if (sum == target) {
        answer++;
      }

      sum += array.get(i);
      while (sum > target && firstIndex < array.size()) {
        sum -= array.get(firstIndex);
        firstIndex++;
      }
    }

    if (sum == target) {
      answer++;
    }

    return answer;
  }
}
