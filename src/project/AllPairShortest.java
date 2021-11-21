package project;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;


public class AllPairShortest {
    
    public static void pairShortest(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] graph = new int[num][num];
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
            
        }
        
        for(int k = 0; k < num; k++) {
            for(int a = 0; a < num; a++) {
                for(int b = 0; b < num; b++) {
                    if((a == k) || (b == k)) continue;
                    graph[a][b] = Math.min(graph[a][b], (graph[a][k] + graph[k][b]));
                }
            }
        }
        
        
        for(int n=0; n < num; n++) {
            for(int m=0; m < num; m++){
                System.out.print(graph[n][m] + " ");
            }
            System.out.println();
        }

    }
}
