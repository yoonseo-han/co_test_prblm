import java.util.*;

public class Main {
    public static void main(String[] strs) {
        Scanner sc = new Scanner(System.in);

        String[] firstInput = sc.nextLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int L = Integer.parseInt(firstInput[1]);

        int[][] positionStore = new int[N][2];
        for(int i = 0; i < N; i++) {
            String[] curInput = sc.nextLine().split(" ");
            positionStore[i][0] = Integer.parseInt(curInput[0]);
            positionStore[i][1] = Integer.parseInt(curInput[1]);
        }
        Arrays.sort(positionStore, (int[] o1, int[] o2) -> Integer.compare(o1[0], o2[0]));

        int count = 0;
        int curPos = 0;

        for (int i = 0; i < N; i++) {
            //Move plank to start of each water
            if (curPos < positionStore[i][0]) {
                curPos = positionStore[i][0];
            }
            //Add new plank if within water: Repeat till go out of current water
            while (curPos < positionStore[i][1]) {
                count++;
                curPos += L;
            }
        }
        
        System.out.println(count);
    }
}
