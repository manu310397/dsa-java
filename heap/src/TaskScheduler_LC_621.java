import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TaskScheduler_LC_621 {
    public static void main(String[] args) {
        char[] tasks = {'A', 'C', 'A', 'B', 'D', 'B'};
        int n = 2;

        Collections.sort(new ArrayList<>());

        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[256];
        Map<Integer, Integer> lastPlacedPos = new HashMap<>();
        int len = tasks.length;

        for (int i = 0; i < len; i++) {
            int task = tasks[i] - 'A';
            freq[task]++;

            if (!lastPlacedPos.containsKey(task)) {
                lastPlacedPos.put(task, -1);
            }
        }

        int time = 0;
        int placedTaks = 0;
        for (Map.Entry<Integer, Integer> entry : lastPlacedPos.entrySet()) {
            lastPlacedPos.put(entry.getKey(), time);
            time++;
            placedTaks++;
        }


        while (placedTaks < len) {
            boolean isTaskScheduled = false;
            for (Map.Entry<Integer, Integer> entry : lastPlacedPos.entrySet()) {
                if (placedTaks < len) {

                    int task = entry.getKey();
                    int lastPos = entry.getValue();

                    if (Math.abs(time - lastPos) > n) {
                        lastPlacedPos.put(task, time);
                        time++;
                        placedTaks++;
                        isTaskScheduled = true;
                    }
                }
            }

            if (!isTaskScheduled) {
                time++;
            }

        }

        return time;
    }
}
