package me.minjun.inflearn.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Array4 {

  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();

    String answer = solution(n).stream().map(String::valueOf).collect(Collectors.joining(" "));
    System.out.println(answer);
  }

  public static List<Integer> solution(int n) {
    List<Integer> answer = new ArrayList<>();
    answer.add(1);
    answer.add(1);
    answer.add(2);

    for (int i = 3; i < n; i++) {
      answer.add(answer.get(i - 2) + answer.get(i - 1));
    }

    return answer;
  }
}
