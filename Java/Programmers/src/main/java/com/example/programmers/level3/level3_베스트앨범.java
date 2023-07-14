package com.example.programmers.level3;

import java.util.*;

public class level3_베스트앨범 {
    static class Solution {
        class Song implements Comparable<Song> {
            int idx;
            int plays;

            @Override
            public int compareTo(Song o) {
                return o.plays - this.plays;
            }

            public Song(int idx, int plays) {
                this.idx = idx;
                this.plays = plays;
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            /**
             *      우선 순위 : 1.장르 총 재생 횟수 / 2.장르 내에 많이 재생 회수 / 3.같으면 고유번호 낮은거
             *      1. 장르별 노래 저장 : genresMap<String,List<Song>> 저장
             *      2. 장르별 노래 총 횟수 저장 : playCounts<String,Integer>
             *      3. Song 객체 생성 하여 Comparable 이용하여 내림차순 정렬
             *      4. playCounts value값 내림차순 정렬
             *      5. 오름차순 된 장르별로 최대 2개씩 answer에 추가
             */
            HashMap<String, ArrayList<Song>> genresMap = new HashMap<>();
            HashMap<String, Integer> playCounts = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                ArrayList<Song> tmp = genresMap.getOrDefault(genres[i], new ArrayList<>());
                tmp.add(new Song(i, plays[i]));
                genresMap.put(genres[i], tmp);
                playCounts.put(genres[i], playCounts.getOrDefault(genres[i], 0) + plays[i]);
            }

            List<String> keySet = new ArrayList<>(playCounts.keySet());
            keySet.sort((o1, o2) -> playCounts.get(o2).compareTo(playCounts.get(o1)));

            ArrayList<Integer> answer = new ArrayList<>();
            for (String genre : keySet) {
                List<Song> songs = genresMap.get(genre);
                Collections.sort(songs);

                int cnt = 0;
                while (!songs.isEmpty() && cnt < 2) {
                    int idx = songs.remove(0).idx;
                    answer.add(idx);
                    cnt++;
                }
            }

            return answer.stream()
                    .mapToInt(x -> x)
                    .toArray();
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Solution solution = new Solution();
        int[] result = solution.solution(genres, plays);

        for (int t : result) {
            System.out.print(t);
        }
    }
}
