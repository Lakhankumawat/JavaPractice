package Math;


import java.util.*;
import java.io.*;

class PowerFn{

    public static int calculatePower(int x, int y){
        int mod = 1000000007;
        if(y == 0) return 1;
        int res=1;
        while(y>0){
            if(y%2==1){
                res = (res*x)%mod;
            }
            x = (x*x)%mod;
            y = y>>1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(2, 3));
    }
}