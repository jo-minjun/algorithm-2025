package me.minjun.inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 *
 * <p>각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 *
 * <p>격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 *
 * <p>만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 *
 * <p>Image1.jpg
 *
 * <p>입력
 *
 * <p>첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 *
 * <p>두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * <p>출력
 *
 * <p>봉우리의 개수를 출력하세요.
 */
public class Array10 {

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
    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Integer target = inputs.get(i).get(j);

        int up = 0;
        if (i - 1 >= 0) {
          up = inputs.get(i - 1).get(j);
        }

        int down = 0;
        if (i + 1 < n) {
          down = inputs.get(i + 1).get(j);
        }

        int left = 0;
        if (j - 1 >= 0) {
          left = inputs.get(i).get(j - 1);
        }

        int right = 0;
        if (j + 1 < n) {
          right = inputs.get(i).get(j + 1);
        }

        if (target > up && target > down && target > left && target > right) {
          answer++;
        }
      }
    }

    return answer;
  }
}
