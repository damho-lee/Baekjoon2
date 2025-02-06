import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input="";
        while((input= br.readLine()) != null){
            st=new StringTokenizer(input);
            int total=0;
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int[] num;
            for(int i=start; i<=end; i++){
                String a=String.valueOf(i);
                num=new int[10];
                for(int j=0; j<a.length(); j++){
                    num[a.charAt(j)-'0']++;
                    if(num[a.charAt(j)-'0']>1){
                        break;
                    }
                    else if(j==a.length()-1){
                        total++;
                    }
                }
            }
            bw.write(total+"\n");
            bw.flush();
        }
    }
}