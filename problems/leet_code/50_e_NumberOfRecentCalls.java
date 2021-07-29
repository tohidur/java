/* Number of Recent calls
 *
 * Write a class RecentCounter to count recent requests.
 *
 * It has only one method `ping(int t)`, where t responds some time in
 * milliseconds.
 *
 * Return the number of pings that have been made from 3000 ms ago until now.
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 *
 * it is guaranteed that every call to ping used a strictly larger value t than
 * before.
 *
 *
 * 1. Each call to ping will have 1 <= t <= 10*9
 *
 * Input:
 *      inputs = ["RecentCounter", "ping", "ping", "ping", "ping"]
 *      inputs = [[], [1], [100], [3001], [3002]]
 *
 *      Output: [null, 1, 2, 3, 3]
 *
 */

import java.util.LinkedList;
import java.util.Queue;


class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}


class Solution {
    public static void main(String[] args) {
        int inputs[] = {1, 100, 3001, 3002};
        RecentCounter obj = new RecentCounter();
        for (int i : inputs) {
            int param_1 = obj.ping(i);
            System.out.println(param_1);
        }
    }
}
