package project;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        int[][] stuff = new int[num][2];
        for(int i = 1; i < num; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println();
        
        //test case
        
    
    }

}
