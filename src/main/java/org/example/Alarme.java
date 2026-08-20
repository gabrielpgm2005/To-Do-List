package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Alarme {

    public static void setarAlarme (TaskManager taskManager, Scanner scanner){

        String check = "";
        for(LinkedHashMap<String,String> taskMap : taskManager.taskList){
            if(Boolean.parseBoolean(taskMap.get("Alarme"))){

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

                String taskTime = taskMap.get("Data");

                taskTime = taskTime + " " + taskMap.get("Horario");

                LocalDateTime horario = LocalDateTime.parse(taskTime,dateTimeFormatter);

                LocalDateTime agora = LocalDateTime.now();

                long delay = Duration.between(agora, horario).toMillis();

                if (delay >= 0 && delay <= 12 * 60 * 60 * 1000L) {
                    System.out.println("ALARME PRÓXIMO!");
                    System.out.println("Tarefa: " + taskMap.get("Nome"));
                    System.out.println("Data: " + taskMap.get("Data"));
                    System.out.println("Horário: " + taskMap.get("Horario"));

                    long horas = delay / (60 * 60 * 1000);
                    long minutos = (delay / (60 * 1000)) % 60;

                    System.out.println("Tempo restante: " + horas + "h " + minutos + "min");
                    System.out.println();
                }

                ScheduledExecutorService executor =
                        Executors.newScheduledThreadPool(1);

                TarefaAlarme tarefa = new TarefaAlarme(taskMap);

                executor.schedule(
                        tarefa,
                        delay,
                        TimeUnit.MILLISECONDS
                );
                System.out.print("Digite q se quiser parar de exibir alarmes: ");
            }
        }
    }
}
