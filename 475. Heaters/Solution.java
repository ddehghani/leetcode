import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, 
        heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(findRadius(houses,heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0, lastHeater = -1, nextHeater = 0;
        for (int house : houses) {
            while (nextHeater < heaters.length && house >= heaters[nextHeater])
                lastHeater = nextHeater++;
            int distance = Math.min(
                lastHeater == -1 ? Integer.MAX_VALUE: Math.abs(house - heaters[lastHeater]),
                nextHeater == heaters.length ? Integer.MAX_VALUE: Math.abs(heaters[nextHeater] - house));
            radius = Math.max(radius, distance);
        }
        return radius;
    }
}
