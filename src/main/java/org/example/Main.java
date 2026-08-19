package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputScanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager("/home/gabriel/Downloads/stock-analysis(1)/first-gradle-project/src/tarefas.csv");
        char input = '0';
        //Mostrar tarefas Criar uma tarefa, editar uma tarefa,remover uma tarefa,encerrar programa
        while(input != 'q'){
            System.out.println(WelcomeMessage.returnMessage());
            System.out.print("Opção: ");
            input = inputScanner.nextLine().charAt(0);
            switch (input){
                case 'm' : {
                    taskManager.displayAllTasks();
                    break;

                }
                case 'c' : {
                    taskManager.displayCategoryTasks();
                    break;
                }
                case 's' : {
                    taskManager.displayStatusTasks();
                    break;
                }
                case 'a' : {
                    taskManager.addTask();
                    break;
                }
                case 'r' : {
                    taskManager.removeTask();
                    break;
                }
                case 'q' : {
                    taskManager.updateFile();
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