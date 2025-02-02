package Algorithms;

import java.util.ArrayList;

public class RabinKarp {
    public static ArrayList<Integer> search(String pat, String txt) {
        int prime = 101;
        int m = pat.length();
        int n = txt.length();
        int Pat[] = new int[m];
        int Text[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < m)
                Pat[i] = (int) pat.charAt(i) - 'a' + 1;
            Text[i] = (int) txt.charAt(i) - 'a' + 1;
        }
        int h = 1, pnum = 0, tnum = 0;
        for (int k = 0; k < m; k++) {
            pnum = (pnum * 10 + Pat[k]) % prime;
            tnum = (tnum * 10 + Text[k]) % prime;
            if (k < m - 1)
                h = (h * 10) % prime;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, k = 0, j = 0;
        while (i <= n - m) {
            if (pnum == tnum) {
                k = 0;
                j = i;
                while (k < m && pat.charAt(k) == txt.charAt(j)) {
                    k++;
                    j++;
                }
                if (k == m) {
                    res.add(i);
                }
            }
            if (i < n - m) {
                tnum = (10 * (tnum - Text[i] * h) + Text[i + m]) % prime;
                if (tnum < 0) {
                    tnum += prime;
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String txt = "aabcaabcacb";
        String pat = "abc";

        for (int i : search(pat, txt)) {
            System.out.println("Pattern found at index " + i);
        }

    }
}
