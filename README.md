# To-Do-List

O arquivo main do programa se chama Main e está em src/main/java/org/example/Main.java

É possivel rodar o programa direto do terminal na pasta inicial usando o comando:
```
./gradlew run
```
A solução para gerenciar tasks foi feita usando uma lista de LinkedHashMaps, permitindo fácil alteração entre as alterações que uma task pode ter e uma lista para armazenar todo conjunto de tasks.

Após o encerramento do programa *exclusivamente pelo menu pressionando a q* um arquivo csv toma conta de guardar todas as Tasks, e quando o programa for iniciado novamente as Tasks serão lidas desse arquivo.

A partir desse mesmo arquivo .csv tambem é analisado se uma tarefa terá alarme ou não, e caso tenha as própias informações no arquivo controem o tempo que será usado para o Alarme.

Nesse sentido vale destacar que sempre ao adicionar uma tarefa, para que ela funcione como alarme o campo de dia deve ser preenchido no formato : __dd/MM/yy__ e as horas no formato __hh:mm__ , além do status de Alarme que deve ser colocado sempre como __true__ ou __false__

O arquivo .csv já vem com algumas tasks de exemplo de como devem ser usadas, veja elas e as apague para por as suas.