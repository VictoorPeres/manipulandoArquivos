package br.com.avancard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    public static void main(String[] args) throws IOException {

/*-----------Criando objetos do tipo pessoa-----------*/
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

        /* -----------Criando uma lista de pessoas. Esses dados também podem vir do banco de dados-------- */
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

            /*Instanciando a clasese FILE*/
                File arquivo = new File("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\arquivo.txt");
        if(!arquivo.exists()){ //Condição para o documento ser criado
            arquivo.createNewFile(); //Criando o arquivo com o método createNewFile
        }
        FileWriter escrever = new FileWriter(arquivo); //instanciando a classe FileWriter para escrever no arquivo

        /* ForEach para percorrer a lista pessoas e escrever o resultado no arquivo*/
        for (Pessoa p : pessoas) {
           escrever.write( p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
        }

        escrever.flush(); //O método flush garante que todos os dados serão gravados no arquivo
        escrever.close(); //Fecha o arquivo
    }
}
