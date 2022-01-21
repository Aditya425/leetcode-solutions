class Solution {
    public int rearrangeSticks(int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = (int) (Math.pow(10, 9) + 7);
        return (dfs(n, k, map) % mod);
    }
    
    static int dfs(int n, int k, HashMap<Integer, Integer> map) {
        if (n == 0 || k == 0) {
            return 0;
        }
        
        if (n == k) {
            return 1;
        }
        
        if (map.get(n) != null) {
            return map.get(n);
        }
        
        int new_k = dfs(n - 1, k - 1, map) + ((n - 1) * dfs(n - 1, k, map));
        map.put(n, new_k);
        return map.get(n);
    }
}