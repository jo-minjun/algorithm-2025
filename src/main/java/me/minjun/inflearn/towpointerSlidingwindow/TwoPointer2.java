package me.minjun.inflearn.towpointerSlidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 *
 * <p>만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 *
 * <p>12 1511 20 2510 20 19 13 15
 *
 * <p>연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 *
 * <p>여러분이 현수를 도와주세요.
 *
 * <p>입력
 *
 * <p>첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 *
 * <p>두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * <p>출력
 *
 * <p>첫 줄에 최대 매출액을 출력합니다.
 */
public class TwoPointer2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    List<Integer> nArray =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    int m = Integer.parseInt(scanner.nextLine());
    List<Integer> mArray =
        Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    String answer =
        solution(nArray, mArray).stream().map(String::valueOf).collect(Collectors.joining(" "));
    System.out.println(answer);
  }

  public static List<Integer> solution(List<Integer> nArray, List<Integer> mArray) {
    List<Integer> answer = new ArrayList<>();

    List<Integer> sortedNArray = nArray.stream().sorted().collect(Collectors.toList());
    List<Integer> sortedMArray = mArray.stream().sorted().collect(Collectors.toList());

    int nPointer = 0;
    int mPointer = 0;

    while (sortedNArray.size() > nPointer && sortedMArray.size() > mPointer) {
      Integer nValue = sortedNArray.get(nPointer);
      Integer mValue = sortedMArray.get(mPointer);

      if (nValue.equals(mValue)) {
        answer.add(nValue);

        nPointer++;
        mPointer++;
        continue;
      }

      if (nValue > mValue) {
        mPointer++;
      } else {
        nPointer++;
      }
    }

    return answer;
  }
}
