package costs;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Services {
    public int getCostServices(String key){
        int result = 0;
        HashMap<String,Integer> list = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader("src/main/resources/cost_additional_services.txt"))) {
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
