package br.com.avancard;

import java.io.FileInputStream;
import java.util.Scanner;

public class LerArquivoTxt {

    public static void main(String[] args) throws Exception {

        /* Associando o arquivo a classe FileInputStream */
        FileInputStream entradaArquivo = new FileInputStream("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\arquivo.txt");

        /* Instanciando a classe Scaneer e informando o arquivo via parametro da classe */
        Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

        while (lerArquivo.hasNext()) { //Condição para ler o arquivo
            String linha = lerArquivo.nextLine(); //Armazenando as linhas do arquivo na variavel linha

            if(linha != null && !linha.isEmpty()){ //Condição para excluir linhas em branco do arquivo.txt

                /*System.out.println(linha); //Imprimindo as linhas
                String[] palavras = linha.split(";");
                System.out.println("DADOS DA PESSOA");
                for(String palavra : palavras){
                    System.out.println(palavra);
                }
                System.out.println(" ");*/

            Pessoa pessoa = new Pessoa(); //Criando um objeto tipo Pessoa
            String[] palavras = linha.split(";");// Dividindo o arquivo.txt pelo ; e armazenando em um array
            for (int i = 0; i < palavras.length; i++) { //Percorrendo o array
                /* Setando os dados lidos no objeto criado */
                pessoa.setNome(palavras[0]);
                pessoa.setEmail(palavras[1]);
                pessoa.setIdade(Integer.parseInt(palavras[2]));
            }
            /* Imprimindo no console */
                System.out.println("###################################");
                System.out.println("Nome: " + pessoa.getNome() + "\nEmail: " + pessoa.getEmail() + "\nIdade: " + pessoa.getIdade());
            }


        }
    }
}
