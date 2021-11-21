package project;

import java.util.Scanner;

public class MST {
    
    public static void mst(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][3];
        for(int i = 0; i < m; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        sc.close();
        int[] root = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            root[i] = i;
        }
        
        sort(arr, 0, m-1);
        kruskal(arr, root, n, m);
    }
    
    
    private static void kruskal(int[][] arr, int[] root, int n, int m) {
        int sum = 0;
        int num = 0;
        int i=0;
        while(num < n-1) {
            int a = getRoot(root, arr[i][0]);
            int b = getRoot(root, arr[i][1]);
            if(a != b) {
                sum += arr[i][2];
                union(root, a, b);
                num++;
                i++;
            }
            else i++;
        }
        
        System.out.println(sum);
    }
    
    private static void union(int[] root, int a, int b) {
        if(a<b) {
            root[b] = a;
        }
        else root[a] = b;
    }
    
    private static int getRoot(int[] root, int a) {
        if(root[a] == a) return a;
        else {
            root[a] = getRoot(root, root[a]);
            return root[a];
        }
    }
    
    
    private static void sort(int[][] arr, int first, int last) {
        if(first >= last) return;
        
        int mid = quick(arr, first, last);
        sort(arr, first, mid-1);
        sort(arr, mid, last);
    }
    
    private static int quick(int[][] arr, int first, int last) {
        int pivot = arr[(first+last)/2][2];
        while(first <= last) {
            while(arr[first][2] < pivot) first++;
            while(arr[last][2] > pivot) last--;
            if(first <= last){
                swap(arr, first, last);
                first++;
                last--;
            }
            
        }
        return first;
    }
    private static void swap(int[][] arr, int a, int b) {
        int[] tmp = new int[3];
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    /*
    private static void sort(int[][] arr) {
        
        for(int size = 1; size < arr.length; size += size) {
            for(int i = 0; i < arr.length - size; i += (2 * size)) {
                int first = i;
                int mid = i + size - 1;
                int end = i + (2 * size) - 1;
                int last;
                if (end <= arr.length - 1) last = end;
                else last = arr.length - 1;
                merge(arr, first, mid, last);
            }
        }
        
    }
    
    private static void merge(int[][] arr, int first, int mid, int last) {
        int left = first;
        int right = mid + 1;
        int index = first;
        int[][] temp = new int[arr.length][arr[0].length];
        
        
        while(left <= mid && right <= last) {
            if(arr[left][2] <= arr[right][2]) {
                temp[index][0] = arr[left][0];
                temp[index][1] = arr[left][1];
                temp[index++][2] = arr[left++][2];
            }
            else {
                temp[index][0] = arr[right][0];
                temp[index][1] = arr[right][1];
                temp[index++][2] = arr[right++][2];
            }
            
        }
        
        if(right > last) {
            while(left <= mid) {
                temp[index][0] = arr[left][0];
                temp[index][1] = arr[left][1];
                temp[index++][2] = arr[left++][2];
            }
        }
        else {
            while(right <= last) {
                temp[index][0] = arr[right][0];
                temp[index][1] = arr[right][1];
                temp[index++][2] = arr[right++][2];
            }
        }
        
        for(int i = first; i <= last; i++) {
            arr[i][0] = temp[i][0];
            arr[i][1] = temp[i][1];
            arr[i][2] = temp[i][2];
        }
        
    }*/
}
