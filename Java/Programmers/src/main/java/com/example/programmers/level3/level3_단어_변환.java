package com.example.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class level3_단어_변환 {
    static boolean[] visited;

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", words));
    }

    public static int solution(String begin, String target, String[] words) {
        //1. begin에서 한개만 다른 단어 찾기
        //1-1) BFS 활용하여 한개만 다르면 큐에 삽입
        //2. 해당 단어로 변경 후 1번 과정 반복과 횟수 증가
        Queue<Word> q = new LinkedList<>();
        visited = new boolean[words.length];
        q.add(new Word(begin, 0));

        while (!q.isEmpty()) {
            Word now = q.poll();
            if (now.word.equals(target)) return now.cnt;

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                int count = 0;

                for (int j = 0; j < words[i].length(); j++) {
                    if (now.word.charAt(j) == words[i].charAt(j)) ++count;
                }

                if (count >= target.length() - 1) {
                    q.add(new Word(words[i], now.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }

    static class Word {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}
