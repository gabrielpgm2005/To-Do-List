package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {

    private String filePath;
    List<HashMap<String,String>> taskList;

    public TaskManager(String filePath) throws FileNotFoundException {
        //Criar um buffer pra ler o arquivo
        File file = new File(filePath);
        List<HashMap<String,String>> taskList = new ArrayList<>();
        try ( BufferedReader reader = new BufferedReader( new FileReader(file))) {

            String[] fields = reader.readLine().split(",");
            String line = "";

            while ((line = reader.readLine()) != null){

                String[] lineFields = line.split(",");
                HashMap<String,String> taskMap = new HashMap<>();
                int size = lineFields.length;

                for (int i = 0; i < size; i++) {
                    taskMap.put(fields[i],lineFields[i]);
                }
                taskList.add(taskMap);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Loop para cada linha, criar uma nova Task e preencher os maps dela
        //com um loop

    }

    //Ler o arquivo de Tasks
    public void readTaskList(){

    }

    //Mostrar lista completa de tasks
    public void displayAllTasks (){

    }

    //Mostrar lista por categorias
    public void displayCategoryTasks(){

    }

    //Mostrar lista por status
    public void displayStatusTasks(){

    }

    //Adicionar tarefas
    public void addTask(){

    }

    //remover tarefas
    public void removeTask(){

    }

    //atualizar arquivo
    public void updateFile(){

    }
}
