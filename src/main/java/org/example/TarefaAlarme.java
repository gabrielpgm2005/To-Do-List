package org.example;

import java.util.LinkedHashMap;

public class TarefaAlarme implements Runnable{

    public TarefaAlarme(LinkedHashMap<String, String> task) {
        this.task = task;
    }

    LinkedHashMap<String,String> task;
    @Override
    public void run() {
        switch (this.task.get("Prioridade")){
            case "1" :
            case "2":
            {
                System.out.println("Tarefa de prioridade baixa marcada para agora!");
                break;
            }
            case "3":
            {
                System.out.println("[ATENÇÃO] Tarefa de prioridade moderada marcada para agora!");
                break;
            }
            case "4":
            case "5":
            {
                System.out.println("[URGENTE] TAREFA DE ALTA PRIORIDADE MARCADA PARA AGORA");
                break;
            }
        }
        System.out.println("Nome da tarefa: "+this.task.get("Nome"));
        System.out.println("Informações completas: "+ this.task);
    }
}
