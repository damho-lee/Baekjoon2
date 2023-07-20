import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n = 0;
    static int sum = 0;
    static int[] students;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static Map<Integer, Set<Integer>> favorite;
    static class Seat implements Comparable<Seat> {
        // x y 좌표, 주변 좋아하는 학생 수, 주변 빈칸 수
        int x, y, studentSum, emptySum;

        public Seat(int x, int y, int studentSum, int emptySum) {
            this.x = x;
            this.y = y;
            this.studentSum = studentSum;
            this.emptySum = emptySum;
        }

        // 다른 좌석과 비교
        @Override
        public int compareTo(Seat other) {
            // 인접 좋아하는 학생 수로 비교
            if (studentSum != other.studentSum) return -(studentSum - other.studentSum);

            // 인접 빈칸 수로 비교
            if (emptySum != other.emptySum) return -(emptySum - other.emptySum);

            // 행으로 비교
            if (x != other.x) return x - other.x;

            // 열로 비교
            return y - other.y;
        }
    }
    public static Seat findSeat(int student) {
        Seat seat = null;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n ;j++) {
                if(map[i][j] != -1) {
                    continue;
                }
                Seat cur = new Seat(i, j, getFav(i, j, student), getEmpty(i, j));
                if (seat == null) {
                    seat = cur;
                    continue;
                }

                // 이전 좌석과 현재 좌석 비교
                if (seat.compareTo(cur) > 0) {
                    seat = cur;
                }
            }
        }
        return seat;
    }
    public static int getFav(int x, int y, int student) {
        int cnt = 0;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n && favorite.get(student).contains(map[nx][ny])){
                cnt++;
            }
        }
        return cnt;
    }
    public static int getEmpty(int x, int y) {
        int cnt = 0;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny] == -1 ) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        students = new int[n*n];
        map = new int [n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j]  = -1;
            }
        }
        favorite = new HashMap<>();
        for(int i=0; i<n*n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;
            favorite.put(student, new HashSet<>());
            for (int j = 0; j < 4; j++) {
                favorite.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<n*n; i++) {
            Seat seat = findSeat(students[i]);
            map[seat.x][seat.y] = students[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 주변 학생 수에 따라 점수 합산
                int count = getFav(i, j, map[i][j]);
                if (count > 0) {
                    sum += (int) Math.pow(10, count - 1);
                }
            }
        }
        System.out.println(sum);
    }
}