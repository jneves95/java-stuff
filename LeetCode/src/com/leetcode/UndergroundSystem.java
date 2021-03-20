package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    class Customer {
        String stationName;
        int time;

        Customer(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    class StationPair {
        double averageTime;
        int trips;

        StationPair(int time) {
            averageTime = (double) time;
            trips = 1;
        }

        double getAverageTime() {
            return averageTime;
        }

        void addTrip(int time) {
            double temp = averageTime * trips + time;
            averageTime = temp / ++trips;
        }
    }

    Map<Integer, Customer> customersInTransit;
    Map<String, StationPair> stationPairs;

    UndergroundSystem() {
        customersInTransit = new HashMap<>();
        stationPairs = new HashMap<>();
    }

    void checkIn(int id, String stationName, int time) {
        if (customersInTransit.containsKey(id)) return;

        customersInTransit.put(id, new Customer(stationName, time));
    }

    void checkOut(int id, String stationName, int time) {
        if (!customersInTransit.containsKey(id)) return;

        Customer c = customersInTransit.get(id);
        String pairName = c.stationName + ":" + stationName;
        int duration = time - c.time;

        if (stationPairs.containsKey(pairName)) {
            stationPairs.get(pairName).addTrip(duration);
        }
        else {
            stationPairs.put(pairName, new StationPair(duration));
        }

        customersInTransit.remove(id);
    }

    double getAverageTime(String startStation, String endStation) {
        String pairName = startStation + ":" + endStation;

        if (!stationPairs.containsKey(pairName)) return -1;
        else return stationPairs.get(pairName).getAverageTime();
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));;          // return 12.00000
    }
}
