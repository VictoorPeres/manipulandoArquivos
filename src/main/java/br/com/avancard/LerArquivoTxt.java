package br.com.avancard;

import java.io.FileInputStream;
import java.util.Scanner;

public class LerArquivoTxt {

    public static void main(String[] args) throws Exception {

        FileInputStream entradaArquivo = new FileInputStream("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\arquivo.txt");

        Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();

            if(linha != null && !linha.isEmpty()){
                System.out.println(linha);
            }
        }
    }
}
