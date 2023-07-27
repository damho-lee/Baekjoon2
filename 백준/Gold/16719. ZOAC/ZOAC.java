import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String result = "";
    static char[] ch;
    static char[] ch_min;
    static char[] ch_tmp;
    static HashMap<Integer, Character> hm;
    static boolean flag = false;
    static String cal(int key) {
        String tmp = "";
        ch_tmp = new char[ch.length];
        for(int i=0; i<ch.length; i++) {
            ch_tmp[i] = ch[i];
        }
        ch_tmp[key] = hm.get(key);
        for(int i=0; i<ch.length; i++) {
            if(ch_tmp[i] >= 'A' && ch_tmp[i] <= 'Z') {
                tmp += ch_tmp[i];
            }
        }
        return tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ch = new char[str.length()];
        ch_min = new char[str.length()];
        hm = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            hm.put(i, str.charAt(i));
        }
        Character min = Collections.min(hm.values());
        int idx = 0;
        for(int i=0; i<hm.size(); i++) {
            if(hm.get(i) == min){
                idx = i;
                break;
            }
        }
        hm.remove(idx);
        String before = "";
        String after = "";
        ch[idx] = min;
        result += min;
        System.out.println(result);
        while(!hm.isEmpty()) {
            Object[] keySet = hm.keySet().toArray();
            int key_idx = (Integer)keySet[0];
            before = result;
            for(int i=0; i<keySet.length; i++) {
                after = cal((Integer)keySet[i]);
                if(before.compareTo(after) > 0 || after.length() > before.length()) {
                    for(int j=0; j<ch.length; j++) {
                        ch_min[j] = ch_tmp[j];
                    }
                    key_idx = (Integer)keySet[i];
                    before = after;
                    //flag = true;
                }
            }
            for(int i=0; i<ch_min.length; i++) {
                ch[i] = ch_min[i];
            }
            //flag = false;
            result = before;
            System.out.println(result);
            hm.remove(key_idx);
        }
    }
}