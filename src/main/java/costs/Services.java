package costs;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Services {
    public int getCostServices(String key){
        int result = 0;
        HashMap<String,Integer> list = new HashMap<>();
        try (InputStream in = getClass().getResourceAsStream("/cost_additional_services.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in));
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNext()) {
                String[] values = scanner.nextLine().split("=");
                list.put(values[0], Integer.parseInt(values[1]));
            }
        } catch (IOException e) { e.getMessage(); }

        for(Map.Entry<String, Integer> entry : list.entrySet()){
            if (entry.getKey().equals(key)){
                result = entry.getValue();
            }
        }

        return result;
    }
}
