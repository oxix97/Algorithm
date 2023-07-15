package com.example.programmers.level2;

import java.util.*;

public class level2_다리를지나는트럭 {
    class Solution {
        /**
         * @param bridge_length 다리 길이 == 트럭이 최대 올라올 수 있는 개수
         *                      즉, 트럭 한개당 1의 다리 길이를 가진다고 할 수 있다.
         *                      다리에 올라가는 조건 : bridge_length - trucks.count >= 0 && weight - trucks.weight >= 0
         * @param weight        다리가 견딜 수 있는 무게
         * @param truck_weights 트럭이 가진 무게
         * @return answer 트럭이 다리를 모두 건넌 최단 시간
         * <p>
         * 1.
         */

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Truck> bridge = new LinkedList<>();
            int answer = 0;
            int arrived = 0;
            int now = 0;
            while (arrived != truck_weights.length) {
                //1. 다리에 오를 수 있는지 확인 후 결정
                if (truck_weights.length > now && weight - truck_weights[now] >= 0) {
                    bridge.add(new Truck(truck_weights[now], 0));
                    weight -= truck_weights[now];
                    now++;
                }

                //2. 시간+1
                bridge.forEach(it -> it.time += 1);

                //3. 트럭이 내려야 하는지 확인 후 결정
                for (Truck truck : bridge) {
                    if (truck.time == bridge_length) {
                        Truck arrived_truck = bridge.poll();
                        weight += arrived_truck.weight;
                        ++arrived;
                        break;
                    }
                }

                ++answer;
            }
            System.out.println(answer + 1);
            return answer;
        }

        class Truck {
            int weight;
            int time;

            public Truck(int weight, int time) {
                this.weight = weight;
                this.time = time;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().solution(2, 10, new int[]{7, 4, 5, 6});
        new Solution().solution(100, 100, new int[]{10});
        new Solution().solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    }
}
