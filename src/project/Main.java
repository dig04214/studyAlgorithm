package project;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] graph = new int[num+1][num+1];
        for(int n = 1; n <= num; n++) {
            for(int m = 1; m <= num; m++){
                if(n == m) continue;
                graph[n][m] = 1000000;
            }
        }
        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[x][y] = w;
        }
        
        
        for(int k = 1; k <= num; k++) {
            for(int a = 1; a <= num; a++) {
                for(int b = 1; b <= num; b++) {
                    if((a == k) || (b == k)) continue;
                    graph[a][b] = Math.min(graph[a][b], (graph[a][k] + graph[k][b]));
                    //test
                    System.out.println("check: "+ a + " " + b + " " + graph[a][b]);
                }
            }
        }
        
        
        for(int n = 1; n <= num; n++) {
            for(int m = 1; m <= num; m++){
                System.out.print(graph[n][m]);
                if(m < num) System.out.print(" ");
            }
            System.out.println();
        }

    }

}
