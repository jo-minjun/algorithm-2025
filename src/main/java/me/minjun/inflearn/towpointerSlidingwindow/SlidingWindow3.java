package me.minjun.inflearn.towpointerSlidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만
 * 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 *
 * <p>만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 *
 * <p>1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * <p>여러분이 만들 수 있는 1이 연속된 연속부분수열은
 *
 * <p>Image1.jpg
 *
 * <p>이며 그 길이는 8입니다.
 *
 * <p>입력
 *
 * <p>첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 *
 * <p>두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 *
 * <p>출력
 *
 * <p>첫 줄에 최대 길이를 출력하세요.
 */
public class SlidingWindow3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int chance = scanner.nextInt();
    scanner.nextLine();

    List<Integer> array =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    System.out.println(solution(chance, array));
  }

  public static int solution(int chance, List<Integer> array) {
    int answer = 0;
    int leftChance = chance;
    int firstIndex = 0;

    for (int i = 0; i < array.size(); i++) {
      if (array.get(i).equals(0)) {
        leftChance--;
      }

      while (leftChance < 0) {
        if (array.get(firstIndex).equals(0)) {
          leftChance++;
        }
        firstIndex++;
      }

      answer = Math.max(i - firstIndex + 1, answer);
    }

    return answer;
  }
}
