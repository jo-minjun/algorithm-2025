package me.minjun.inflearn.sortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * <p>캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
 *
 * <p>필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
 *
 * <p>철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
 *
 * <p>LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
 *
 * <p>캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
 *
 * <p>Image1.jpg
 *
 * <p>캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
 *
 * <p>캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
 *
 * <p>입력
 *
 * <p>첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
 *
 * <p>두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.
 *
 * <p>출력
 *
 * <p>마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
 */
public class Searching1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cacheSize = scanner.nextInt();
    int jobSize = scanner.nextInt();
    scanner.nextLine();

    List<Integer> jobs =
        Arrays.asList(scanner.nextLine().split(" ")).stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());

    List<Integer> result = solution(cacheSize, jobs);
    System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  private static List<Integer> solution(int cacheSize, List<Integer> jobs) {
    Deque<Integer> cache = new LinkedList<>();

    for (int job : jobs) {
      if (cache.size() < cacheSize) {
        cache.addFirst(job);
        continue;
      }

      if (cache.contains(job)) {
        cache.remove(job);
        cache.addFirst(job);
      } else {
        cache.removeLast();
        cache.addFirst(job);
      }
    }

    return new ArrayList<>(cache);
  }
}
