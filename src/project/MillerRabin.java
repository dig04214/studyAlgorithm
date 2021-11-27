package project;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class MillerRabin {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        
        
        System.out.println(primialityTest(num));
        
        //test case
        //System.out.println(mod(2, 3717, 14869));
    
    }
    
    private static int primialityTest(int num) {
        int a = 0, d = 0, s = 0;
        int[] tester = {2, 3, 7, 31, 61, 73};
        int n = num -1;
        boolean result = true;    //true: not prime number, false: prime number
        int ans;
        while(n % 2 == 0) {
            s++;
            n = n / 2;
        }
        d = n;
        //System.out.println("d: " + d + ", s: " + s); //test
        
        for(int i=0; i < 6; i++) {
            if(result == false) break;
            a = tester[i];
            long n1 = mod(a, d, num);
            //System.out.println("i: " + i); //test
            //System.out.println("a mod: " + n1); //test
            if(n1 == 1) {
                result = false;
                
            }
            else result = true;
            
            for(int r=0; r < s; r++) {
                //System.out.println("r: " + r); //test
                int n2 = (int)Math.pow(2, r) * d;
                long n3 = mod(a, n2, num);
                //System.out.println("n2: " + n2); //test
                //System.out.println("r mod: " + n3); //test
                if(n3 == (num-1)) {
                    result = result && false;
                    //System.out.println("result: " + result); //test
                    break;
                }
                else if(n3 == -1) {
                    result = result && false;
                    //System.out.println("result: " + result); //test
                    break;
                }
                else {
                    result = result && true;
                    //System.out.println("result: " + result); //test
                }
            }

        }
        
        if(result) ans = 0;
        else ans = 1;
        return ans;
    }
    
    private static long mod(int a, int d, int n) {
        //System.out.println("mod start, a: " + a + " d: " + d + " n: " + n); //test
        String number = Integer.toBinaryString(d);
        char[] nums = number.toCharArray();
        //System.out.println(d + " binary: " + number); //test
        long[] modular = new long[nums.length];
        int end = nums.length-1;
        long ans = 1;
        modular[end] = a % n;
        if(nums[end] == '1') ans *= modular[end];
        
        for(int i = end-1; i >= 0; i--) {
            modular[i] = ((modular[i+1] % n) * (modular[i+1] % n)) % n;
            if(nums[i] == '1') ans = (ans * (modular[i] % n)) % n;
            
            //System.out.println("nums " + i + ": " + nums[i]); //test
            //System.out.println("modular " + i + ": " + modular[i]); //test
            //System.out.println("ans: " + ans); //test
        }
        //System.out.println("mod end"); //test
        return ans;
    }
    

}
