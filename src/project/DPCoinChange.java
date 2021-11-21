package project;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class DPCoinChange {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), ", ");
        int num = st.countTokens();
        int money = Integer.parseInt(br.readLine());
        int[] coin = new int[num+1];
        for(int i = 1; i < num+1; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(coinChange(coin, money, num));
        
        //test case
        
    
    }
    
    private static int coinChange(int[] coin, int money, int num) {
        int[] c = new int[money+1];
        c[0] = 0;
        for(int a=1; a < c.length; a++) {
            c[a] = 200000;  //초기화
        }
        
        for(int i =1; i <= money; i++) {
            for(int ii=1; ii <= num; ii++) {
                if((coin[ii] <= i) && (c[i - coin[ii]] + 1 < c[i])) {
                    c[i] = c[i - coin[ii]] + 1;
                }
            }
        }
        
        
        return c[money];
    }

}