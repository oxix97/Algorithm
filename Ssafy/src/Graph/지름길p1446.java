package Graph;

import Util.UtilClass;

import java.util.*;

public class 지름길p1446 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int END;

    public static class Road implements Comparable<Road> {
        public int target;
        public int distance;

        public Road(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }

        @Override
        public int compareTo(Road road) {
            return this.distance - road.distance;
        }
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        END = sc.nextInt();
        int init = 0;
        HashMap<Integer, ArrayList<Road>> map = new HashMap<>();
        HashMap<Integer, Integer> distances = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();

            //지름길이 아닌경우 안넣음
            if (end - start < distance) continue;
            if (end > start) continue;

            Road road = new Road(end, distance);
            //이미 존재하는 지름길이면 넣어줌
            if (map.containsKey(start)) {
                map.get(start).add(road);
            } else {
                map.put(start, new ArrayList<>(Arrays.asList(road)));
            }
        }

        //minValue를 구하는 것이므로 MAX를 넣어 초기화한다.
        for (int key : map.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }

        //시작점
        distances.put(0, 0);

        PriorityQueue<Road> q = new PriorityQueue<>();
        q.add(new Road(distances.get(0), 0));

        while (q.size() > 0) {
            Road r = q.poll();

            //현재 큐에 들어가 있는 타켓, 거리
            int currentTarget = r.target;
            int currentDistance = r.distance;

            //현재 있는 타겟에 대한 거리 보다 더 큰 경우 반복할 이유가 없어 다시 돌아간다.
            if (distances.get(currentTarget) < currentDistance) continue;

            //기존에 있는 지름길보다 빠르기 때문에 새로 배열을 만들어 준다.
            ArrayList<Road> roadList = map.get(currentTarget);

            System.out.println(r.target + ", " + r.distance);
            //해당 값 안에 있는 것들을 꺼낸다.
            if (init == END) {
                break;
            }

            for (int i = 0; i < roadList.size(); i++) {
                Road newRoad = roadList.get(i);
                int newTarget = newRoad.target;
                int newDistance = newRoad.distance;
                int distance = currentDistance + newDistance;

                //지금 설정한 경로가 이전에 target까지의 경로보다 최적의 경우 변경시키며, 변경사항을 큐에 집어넣는다.
                if (distance < distances.get(newTarget)) {
                    distances.put(newTarget, distance);
                    q.add(new Road(newTarget, distance));
                }
            }
        }

    }
}
