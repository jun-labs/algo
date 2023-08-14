package programmers.다리를_지나는_트럭;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution.solution(bridge_length, weight, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTruckWeight = 0;
        Stack<Truck> stack = new Stack<>();
        for (int index = truck_weights.length - 1; index >= 0; index--) {
            stack.push(new Truck(0, truck_weights[index]));
        }

        List<Truck> trucksOnRoad = new ArrayList<>();
        int time = 0;
        while (!stack.isEmpty() || !trucksOnRoad.isEmpty()) {
            time++;
            List<Truck> trucksCrossedBridge = new ArrayList<>();
            for (Truck truck : trucksOnRoad) {
                truck.time += 1;
                if (truck.time >= bridge_length) {
                    trucksCrossedBridge.add(truck);
                    totalTruckWeight -= truck.weight;
                }
            }
            trucksOnRoad.removeAll(trucksCrossedBridge);

            if (!stack.isEmpty() && totalTruckWeight + stack.peek().weight <= weight) {
                Truck newTruck = stack.pop();
                trucksOnRoad.add(newTruck);
                totalTruckWeight += newTruck.weight;
            }
        }
        return time;
    }

    static class Truck {

        int time;
        int weight;

        public Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }
}
