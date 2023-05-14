import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 1 : 카멜, 2 : 스네이크, 3 : 파스칼
        int N = Integer.parseInt(st.nextToken());
        String input = st.nextToken();

        switch (N){
            case 1: // 카멜
                String s2 = "";
                for (int i=0; i<input.length(); i++){
                    if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z'){
                        s2 += "_" + String.valueOf(input.charAt(i)).toLowerCase();
                    } else{
                        s2 += String.valueOf(input.charAt(i));
                    }
                }
                String s3 = String.valueOf(input.charAt(0)).toUpperCase() + input.substring(1);
                sb.append(input).append("\n").append(s2).append("\n").append(s3);
                break;
            case 2:
                String s1 = "";
                boolean upper = false;
                for (int i=0; i<input.length(); i++){
                    if (input.charAt(i) == '_'){
                        upper = true;
                    }else{
                        if (upper){
                            s1 += String.valueOf(input.charAt(i)).toUpperCase();
                            upper = false;
                        } else s1 += String.valueOf(input.charAt(i));
                    }
                }

                sb.append(s1).append("\n").append(input).append("\n").append(String.valueOf(s1.charAt(0)).toUpperCase() + s1.substring(1));
                break;
            default:
                String new_s2 = "";
                for (int i=0; i<input.length(); i++){
                    if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z'){
                        if (i==0)
                            new_s2 += String.valueOf(input.charAt(i)).toLowerCase();
                        else new_s2 += "_" + String.valueOf(input.charAt(i)).toLowerCase();
                    } else{
                        new_s2 += String.valueOf(input.charAt(i));
                    }
                }
                sb.append(String.valueOf(input.charAt(0)).toLowerCase() + input.substring(1)).append("\n").append(new_s2).append("\n").append(input);
                break;
        }

        System.out.println(sb);
    }

}
