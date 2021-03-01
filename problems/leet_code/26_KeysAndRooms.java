/* Keys And Rooms
 *
 * There are N rooms you start in room 0. Each room has a distinct number in 1,
 * 2, 3, ......, N-1. And each room may have some key to access the next room.
 *
 * Formally, each room has a lit of keys rooms[i], and each key room rooms[i][j]
 * is an inteter in [1 to N-1] where N = rooms.length. A key rooms[i][j] = v
 * opens the room with number v
 * 
 * You can walk back and forth between rooms freely
 *
 * Return true only if you can enter all rooms
 *
 * Input: [[1], [2], [3], []]
 */

import java.util.*;

class Solution {
    public boolean canVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(0);

        for (ArrayList<Integer> l : rooms) {
            for (int k : l)
                visited.add(k);
        }
        return visited.size() == rooms.size();
    }

    public static void main(String args[]) {
        int [][] vals = {{1}, {2}, {3}, {}};

        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int[] i : vals) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j : i)
                row.add(j);
            l.add(row);
        }

        Solution sol = new Solution();
        System.out.println(sol.canVisitAllRooms(l));
    }
}

