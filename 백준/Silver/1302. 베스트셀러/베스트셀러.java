import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();

        String result = "";
        int cnt = 0;

        for (int i=0; i<N; i++){
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 1) + 1);
        }

        for (String key : map.keySet()){
            if (map.get(key) > cnt){
                result = key;
                cnt = map.get(key);
            }
        }

        System.out.println(result);
    }
}
