package me.minjun.inflearn.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
 *
 * <p>선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 *
 * <p>입력
 *
 * <p>첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 *
 * <p>출력
 *
 * <p>선생님이 볼 수 있는 최대학생수를 출력한다.
 */
public class Array2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    scanner.nextLine();
    List<Integer> inputs =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    System.out.println(solution(inputs));
  }

  public static int solution(List<Integer> inputs) {
    int criteria = inputs.get(0);
    int count = 1;
    for (int i = 1; i < inputs.size(); i++) {
      if (criteria < inputs.get(i)) {
        count++;
        criteria = inputs.get(i);
      }
    }

    return count;
  }
}
