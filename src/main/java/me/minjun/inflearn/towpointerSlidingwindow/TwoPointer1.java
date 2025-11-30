package me.minjun.inflearn.towpointerSlidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * <p>입력
 *
 * <p>첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 *
 * <p>두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 *
 * <p>세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 *
 * <p>네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 *
 * <p>각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * <p>출력
 *
 * <p>오름차순으로 정렬된 배열을 출력합니다.
 */
public class TwoPointer1 {

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
    int n = nArray.size();
    int m = mArray.size();

    List<Integer> answer = new ArrayList<>(n + m);

    int i = 0;
    int j = 0;

    while (i < n && j < m) {
      int nValue = nArray.get(i);
      int mValue = mArray.get(j);

      if (nValue <= mValue) {
        answer.add(nValue);
        i++;
      } else {
        answer.add(mValue);
        j++;
      }
    }

    while (i < n) {
      answer.add(nArray.get(i++));
    }

    while (j < m) {
      answer.add(mArray.get(j++));
    }

    return answer;
  }
}
