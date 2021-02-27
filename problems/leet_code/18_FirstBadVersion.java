class VersionControl {
    boolean isBadVersion(int version) {
        return (version >= 4) ? true : false;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int s = 0;

        while (left <= right) {
            s += 1;
            int mid = left + (right - left) / 2;
            if (this.isBadVersion(mid) && !this.isBadVersion(mid -1)) {
                System.out.println(s);
                return mid;
            } else if (this.isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.firstBadVersion(5));
    }
}

