package org.example;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Displayer {

    public static void displayAllTasks (TaskManager taskManager,Scanner scanner){
        char opt = 'a';

        for (LinkedHashMap<String, String> stringStringLinkedHashMap : taskManager.taskList) {

            System.out.println(stringStringLinkedHashMap);
            System.out.print("Entre com qualquer letra para avançar (q para sair)");
            opt = scanner.nextLine().charAt(0);
            System.out.println("\n===============================================\n");
            if (opt == 'q') return;
        }
    }

    public static void displayPerField(TaskManager taskManager,Scanner scanner){

        System.out.print("Entre com o campo que deseja filtrar: ");
        String fieldToFilter = scanner.nextLine();
        System.out.print("Entre com o valor desse campo a ser filtrado: ");
        String valueToFilter = scanner.nextLine();

        List<LinkedHashMap<String,String>> result = taskManager.taskList.stream()
                .filter(
                        (map) -> map.get(fieldToFilter).equals(valueToFilter))
                .collect(Collectors.toList());

        int size = result.size();

        if(size == 0){
            System.out.println("Nenhum elemento encontrado");
        }
        for (int i = 0; i < size; i++) {
            System.out.println(result.get(i));
        }
    }
}
