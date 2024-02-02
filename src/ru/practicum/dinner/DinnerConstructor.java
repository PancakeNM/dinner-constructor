package ru.practicum.dinner;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>> dishesByCategories = new HashMap<>();

    void addNewDish(String dishType, String dishName){
        if (checkType(dishType)) {
            ArrayList<String> dishes = dishesByCategories.get(dishType);
            dishes.add(dishName);
            dishesByCategories.put(dishType, dishes);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByCategories.put(dishType, dishes);
        }
    }

    void generateNewCombo(int numOfCombs, ArrayList<String> types) {
        for (int i = 1; i <= numOfCombs; i++) {
            ArrayList<String> comboByCategory = new ArrayList<>();
            System.out.println("Комбо " + i);
            for (String type : types) {
                ArrayList<String> dishes = dishesByCategories.get(type);
                comboByCategory.add(dishes.get(random.nextInt(dishes.size())));
            }
            System.out.println(comboByCategory);
        }
    }
    boolean checkType(String type){
        return dishesByCategories.containsKey(type);
    }
}
