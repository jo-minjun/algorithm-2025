package me.minjun.inflearn.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 설명
 *
 * <p>자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 *
 * <p>만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * <p>입력
 *
 * <p>첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * <p>출력
 */
public class Array5 {

  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();

    System.out.println(solution(n));
  }

  public static int solution(int n) {
    List<Boolean> sieve = new ArrayList<>();
    // 에라토스테네스의 체 초기화
    sieve.add(false);
    sieve.add(false);
    for (int i = 2; i <= n; i++) {
      sieve.add(true);
    }

    int answer = 0;
    for (int i = 2; i <= n; i++) {
      if (sieve.get(i)) {
        answer += 1;
        for (int j = i * 2; j <= n; j = j + i) {
          sieve.set(j, false);
        }
      }
    }
    return answer;
  }
}
