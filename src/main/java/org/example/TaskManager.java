package org.example;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class TaskManager {

    String[] fields;
    List<LinkedHashMap<String,String>> taskList;

    public TaskManager(String filePath)  {
        File file = new File(filePath);
        List<LinkedHashMap<String,String>> taskList = new ArrayList<>();
        this.taskList = taskList;
        try ( BufferedReader reader = new BufferedReader( new FileReader(file))) {

            this.fields = reader.readLine().split(",");
            String line = "";

            while ((line = reader.readLine()) != null){

                String[] lineFields = line.split(",");
                LinkedHashMap<String,String> taskMap = new LinkedHashMap<>();
                int size = lineFields.length;

                for (int i = 0; i < size; i++) {
                    taskMap.put(fields[i],lineFields[i]);
                }
                taskList.add(taskMap);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTask(Scanner scanner){

        System.out.println("Nova Tarefa!");
        LinkedHashMap<String,String> taskMap = new LinkedHashMap<>();
        String resposta = "";
        int fieldSize = this.fields.length;
        int posicao = 0;

        for (int i = 0;i<fieldSize;i++){
            System.out.println("Preencha com o valor");
            System.out.print(fields[i] + " : " );
            resposta = scanner.nextLine();
            taskMap.put(fields[i],resposta);
        }

        if(this.taskList.isEmpty()){
            this.taskList.add(taskMap);
            return;
        }

        while(posicao < this.taskList.size() && Integer.parseInt(taskMap.get("Prioridade")) < Integer.parseInt(this.taskList.get(posicao).get("Prioridade"))){
            posicao++;
        }


        this.taskList.add(posicao,taskMap);

    }

    public void removeTask(Scanner scanner){

        System.out.println("Entre com o nome da tarefa a ser deletada");
        String taskToDeleteName = scanner.nextLine();

        this.taskList.removeIf(taskMap -> taskMap.get("Nome").equals(taskToDeleteName));
    }

    public void editTask(Scanner scanner){

        System.out.print("Entre com o nome da task que deseja alterar: ");
        String name = scanner.nextLine();

        for (LinkedHashMap<String,String> taskMap : this.taskList){
            if(taskMap.get("Nome").equals(name)){
                System.out.println("Tarefa Encontrada!");
                System.out.println(taskMap);
                System.out.print("Entre com o nome do campo que deseja alterar: ");
                String key = scanner.nextLine();
                System.out.print("\nEntre com o nome da chave que irá atualizar esse campo: ");
                String value = scanner.nextLine();
                taskMap.replace(key,value);
                return;
            }
        }
        System.out.println("Tarefa não encontrada!");

    }
    public void updateFile(String filepath){

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath))){

            bufferedWriter.write(String.join(",",this.fields));
            bufferedWriter.newLine();

            for(LinkedHashMap<String,String> taskMap : this.taskList){

                bufferedWriter.write(
                        String.join(",", taskMap.values())
                );

                bufferedWriter.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}
