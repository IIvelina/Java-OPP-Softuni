package foodShortage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotations = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyerMap = new HashMap<>();

        for (int i = 1; i <= rotations; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");

            String name = null;

            int age = 0;
            if (inputData.length > 3) {
                name = inputData[0];
                age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                String birthDate = inputData[3];
                Citizen buyer = new Citizen(name, age, id, birthDate);
                buyerMap.put(name, buyer);
            } else {
                name = inputData[0];
                age = Integer.parseInt(inputData[1]);
                String group = inputData[2];
                Rebel buyerRebel = new Rebel(name, age, group);
                buyerMap.put(name, buyerRebel);
            }

        }

        String searchName = scanner.nextLine();

        while (!"End".equals(searchName)) {

            if (buyerMap.containsKey(searchName)) {
                buyerMap.get(searchName).buyFood();
            }

            searchName = scanner.nextLine();
        }

        System.out.println(buyerMap.values()
                .stream()
                .mapToInt(Buyer::getFood).sum());
    }
}
