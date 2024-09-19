package br.com.avancard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setNome("Pessoa 1");
        pessoa1.setIdade(30);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setNome("Pessoa 2");
        pessoa2.setIdade(22);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setNome("Pessoa 3");
        pessoa3.setIdade(32);

        /* Pode vir do banco de dados ou de qualquer fonte dedados */
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

                File arquivo = new File("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\arquivo.txt");
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
        FileWriter escrever = new FileWriter(arquivo);

        for (int i = 0; i < 10; i++){
            escrever.write("Texto da linha " + (i+1) + "\n");
        }

        for (Pessoa p : pessoas) {
           escrever.write("Nome: " + p.getNome() + " \nIdade: " + p.getIdade() + "\n");
        }

        escrever.flush();
        escrever.close();
    }
}
