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
                         "c -> Listar atividades por categorias\n" +
                         "s -> Listar atividades por status\n" +
                         "a -> Adicionar tarefa\n" +
                         "r -> Remover tarefa\n" +
                         "====================================\n";
        return Message;
    }
}
