package org.example;

public class WelcomeMessage {
    public static String returnMessage(){
        String Message = "====================================\n" +
                         "BEM VINDO AO INCRIVEL TO-DO LIST\n" +
                         "\n" +
                         "\n" +
                         "Digite a opcão que deseja!\n" +
                         "q -> Fechar programa\n" +
                         "m -> Mostrar lista completa de tarefas\n" +
                         "c -> Listar atividades por um campo especifico\n" +
                         "a -> Adicionar tarefa\n" +
                         "e -> editar uma tarefa\n" +
                         "r -> Remover tarefa\n" +
                         "n -> Lista o número de tarefas por status\n" +
                         "====================================\n";
        return Message;
    }
}
