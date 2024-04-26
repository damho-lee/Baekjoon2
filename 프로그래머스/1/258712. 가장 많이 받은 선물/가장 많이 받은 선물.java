import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Map<String, Integer>> totalMap = new HashMap<>();
        for (String friend : friends) {
            totalMap.put(friend, new HashMap<>());
        }

        Map<String, Integer> giveMap = new HashMap<>();
        Map<String, Integer> getMap = new HashMap<>();

        for (String gift : gifts) {
            String[] inputs = gift.split(" ");
            String giver = inputs[0];
            String recipient = inputs[1];
            Map<String, Integer> map = totalMap.get(giver);
            map.compute(recipient, (key, count) -> count == null ? 1 : count + 1);
            giveMap.compute(giver, (key, count) -> count == null ? 1 : count + 1);
            getMap.compute(recipient, (key, count) -> count == null ? 1 : count + 1);
        }

        for (int i = 0; i < friends.length; i++) {
            int numberOfGift = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }
                String friend1 = friends[i];
                String friend2 = friends[j];
                int give = totalMap.get(friend1).getOrDefault(friend2, 0);
                int get = totalMap.get(friend2).getOrDefault(friend1, 0);
                if (give > get) {
                    numberOfGift++;
                } else if (give == get) {
                    int friend1sGiftPoint = giveMap.getOrDefault(friend1, 0) - getMap.getOrDefault(friend1, 0);
                    int friend2sGiftPoint = giveMap.getOrDefault(friend2, 0) - getMap.getOrDefault(friend2, 0);
                    if (friend1sGiftPoint > friend2sGiftPoint) {
                        numberOfGift++;
                    }
                }
            }
            answer = Math.max(answer, numberOfGift);
        }

        return answer;
    }
}