package programmers.다리를_지나는_트럭;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    private final Queue<Truck> waitingTrucks = new LinkedList<>();
    private final List<Truck> trucksOnRoad = new ArrayList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int totalWeightOnRoadTrucks = 0;
        for (Integer truckWeight : truck_weights) {
            waitingTrucks.add(new Truck(0, truckWeight));
        }

        while (!waitingTrucks.isEmpty() || !trucksOnRoad.isEmpty()) {
            time++;
            List<Truck> trucksCrossedBridge = new ArrayList<>();
            for (Truck onRoadTruck : trucksOnRoad) {
                onRoadTruck.time += 1;
                if (onRoadTruck.time >= bridge_length) {
                    trucksCrossedBridge.add(onRoadTruck);
                    totalWeightOnRoadTrucks -= onRoadTruck.weight;
                }
            }
            trucksOnRoad.removeAll(trucksCrossedBridge);

            if (canCrossBridge(weight, totalWeightOnRoadTrucks)) {
                Truck truck = waitingTrucks.poll();
                totalWeightOnRoadTrucks += truck.weight;
                trucksOnRoad.add(truck);
            }
        }
        return time;
    }

    private boolean canCrossBridge(int weight, int totalTruckWeight) {
        return !waitingTrucks.isEmpty() && totalTruckWeight + waitingTrucks.peek().weight <= weight;
    }

    static class Truck {

        int time;
        int weight;

        public Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Truck)) {
                return false;
            }
            Truck truck = (Truck) o;
            return time == truck.time && weight == truck.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(time, weight);
        }
    }
}
