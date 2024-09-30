import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int start;
        int end;
        int[] visited = new int[100001];
        int[] parent = new int[100001];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            start = Integer.parseInt(inputs[0]);
            end = Integer.parseInt(inputs[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        bfs(start, end, visited, parent);

        StringBuffer stringBuffer = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int reverse = end;
        while (reverse != start) {
            stack.push(reverse);
            reverse = parent[reverse];
        }
        stack.push(start);

        stringBuffer.append(visited[end] - 1);
        stringBuffer.append("\n");
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop() + " ");
        }

        System.out.println(stringBuffer);
    }

    private static void bfs(int start, int end, int[] visited, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (isValid(current + 1) && visited[current + 1] == 0) {
                visited[current + 1] = visited[current] + 1;
                parent[current + 1] = current;
                queue.add(current + 1);
            }
            if (isValid(current - 1) && visited[current - 1] == 0) {
                visited[current - 1] = visited[current] + 1;
                parent[current - 1] = current;
                queue.add(current - 1);
            }
            if (isValid(current * 2) && visited[current * 2] == 0) {
                visited[current * 2] = visited[current] + 1;
                parent[current * 2] = current;
                queue.add(current * 2);
            }

            if (visited[end] != 0) {
                break;
            }
        }
    }

    private static boolean isValid(int point) {
        return point >= 0 && point <= 100000;
    }
}