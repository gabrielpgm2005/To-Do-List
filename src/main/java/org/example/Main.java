package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputScanner = new Scanner(System.in);
        String filepath = "/home/gabriel/Downloads/stock-analysis(1)/first-gradle-project/src/tarefas.csv";
        TaskManager taskManager = new TaskManager(filepath);
        char input = '0';
        //Mostrar tarefas Criar uma tarefa, editar uma tarefa,remover uma tarefa,encerrar programa
        while(input != 'q'){
            System.out.println(WelcomeMessage.returnMessage());
            System.out.print("Opção: ");
            input = inputScanner.nextLine().charAt(0);
            switch (input){
                case 'm' : {
                    Displayer.displayAllTasks(taskManager,inputScanner);
                    break;

                }
                case 'c' : {
                    Displayer.displayPerField(taskManager,inputScanner);
                    break;
                }
                case 'a' : {
                    taskManager.addTask(inputScanner);
                    break;
                }
                case 'r' : {
                    taskManager.removeTask(inputScanner);
                    break;
                }
                case 'q' : {
                    taskManager.updateFile(filepath);
                    break;
                }
                default: {
                    System.out.println("Digite uma opção válida!");
                }

            }
        }
        inputScanner.close();
    }
}