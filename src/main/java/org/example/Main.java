package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        String filepath = "src/tarefas.csv";
        TaskManager taskManager = new TaskManager(filepath);
        Scanner inputScanner = new Scanner(System.in);
        Alarme.setarAlarme(taskManager,inputScanner);
        String input = "";
            while (!input.equals("q")) {
                System.out.println(WelcomeMessage.returnMessage());
                System.out.print("Opção: ");
                input = inputScanner.nextLine();
                switch (input) {
                    case "m": {
                        Displayer.displayAllTasks(taskManager, inputScanner);
                        break;
                    }
                    case "c": {
                        Displayer.displayPerField(taskManager, inputScanner);
                        break;
                    }
                    case "a": {
                        taskManager.addTask(inputScanner);
                        break;
                    }
                    case "r": {
                        taskManager.removeTask(inputScanner);
                        break;
                    }
                    case "q": {
                        taskManager.updateFile(filepath);
                        break;
                    }
                    case "n": {
                        Displayer.displayStatusCount(taskManager);
                        break;
                    }
                    case "e":
                    {
                        taskManager.editTask(inputScanner);
                        break;
                    }
                    default: {
                        System.out.println("Digite uma opção válida!");
                    }

                }
            }
        }
    }
