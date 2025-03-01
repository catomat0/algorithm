class Solution {
    public int maxProfit(int[] prices) {

        // 첫 시점부터 시작 minPrice -> prices 의 첫번째 원소, 이익은 0보다 큼
        int maxProfit = 0, minPrice = prices[0];
        for (int price : prices) { // 순회하며 가장 작은 저점을 찾고, 저점을 유지한 상태로 가장 큰 이익을 저장
            
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}