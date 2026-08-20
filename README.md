# To-Do List

O arquivo principal do programa, `Main`, está localizado em `src/main/java/org/example/Main.java`.

É possível executar o programa diretamente pelo terminal, a partir da pasta raiz do projeto, utilizando o comando:

```bash
./gradlew run
```

## Gerenciamento das tarefas

As tarefas são gerenciadas por meio de uma lista de `LinkedHashMaps`. Essa estrutura permite armazenar os diferentes atributos de cada tarefa e facilita a alteração desses dados conforme o estado da tarefa é modificado. Uma lista é utilizada para armazenar o conjunto completo de tarefas.

Após o encerramento do programa **exclusivamente pelo menu, utilizando a opção `q`**, todas as tarefas são armazenadas em um arquivo `.csv`. Quando o programa é iniciado novamente, as tarefas são carregadas a partir desse arquivo.

O mesmo arquivo `.csv` também é utilizado para verificar se uma tarefa possui um alarme. Quando uma tarefa possui um alarme, as informações de data e horário armazenadas no arquivo são utilizadas para construir o momento em que o alarme deverá ser acionado.

## Configuração dos alarmes

Para que uma tarefa funcione corretamente como um alarme, alguns campos devem seguir formatos específicos no momento de sua criação:

* **Data:** deve ser informada no formato `dd/MM/yy`;
* **Horário:** deve ser informado no formato `HH:mm`;
* **Alarme:** deve ser preenchido obrigatoriamente com `true` ou `false`.

O arquivo `.csv` já acompanha algumas tarefas de exemplo que demonstram como os dados devem ser preenchidos. Recomenda-se verificar essas tarefas antes de criar as suas próprias e, posteriormente, apagá-las para utilizar apenas as tarefas desejadas.
