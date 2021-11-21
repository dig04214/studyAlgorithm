package project;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class job_schedule {
    
    public static void schedule(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] task = new int[num][2];
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            task[i][0] = Integer.parseInt(st.nextToken());
            task[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(task, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0]) return arr1[1] - arr2[1];
                else return arr1[0] - arr2[0];
            }
        });
        
        System.out.println(machine(task, num));
        
        
    }
    
    private static int machine(int[][] task, int num) {
        
        PriorityQueue<Integer> mac = new PriorityQueue<>();
        mac.add(task[0][1]);
        for(int i=1; i < num; i++) {
            if(mac.peek() <= task[i][0]) mac.poll();
            mac.add(task[i][1]);
        }
        
        return mac.size();
    }
}
