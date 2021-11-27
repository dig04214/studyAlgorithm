package project;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Kanpsack {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int[][] stuff = new int[num][2];
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());  //value
            stuff[i][1] = Integer.parseInt(st.nextToken());  //weight
        }
        
        System.out.println(kanpSack(num, maxWeight, stuff));
        
        //test case
        
    
    }
    
    private static int kanpSack(int num, int maxWeight, int[][] stuff) {
        int[][] K = new int[num+1][maxWeight+1];
        
        for(int i=0; i <= num; i++) {
            K[i][0] = 0;
        }
        for(int i=0; i <= maxWeight; i++) {
            K[0][i] = 0;
        }
        
        for(int n=1; n <= num; n++) {
            for(int w=1; w <= maxWeight; w++) {
                if(stuff[n-1][1] > w) K[n][w] = K[n-1][w];
                else K[n][w] = Math.max(K[n-1][w], (K[n-1][w-stuff[n-1][1]]+stuff[n-1][0]));
            }
        }
        
        
        return K[num][maxWeight];
    }

}