package br.com.avancard;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePOI {

    public static void main(String[] args) throws IOException {

        /* Instanciando o arquivo */
        File file = new File("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\arquivo_excel.xls");

        if(!file.exists()){ //checando se o arquivo existe
            file.createNewFile();//Se o arquivo não existir, eu crio.
        }

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

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); //Metodo usado para escrever na planilha
        HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas"); //Método para criar a planilha

        int numeroLinha = 0;

        for(Pessoa p : pessoas){
            Row linha = linhasPessoa.createRow(numeroLinha++);//Criando linha na planilha

            /* Criando as células da planilha e informando os valores das células */
            int celula = 0;
            Cell celNome = linha.createCell(celula++);
            celNome.setCellValue(p.getNome());

            Cell celEmail = linha.createCell(celula++);
            celEmail.setCellValue(p.getEmail());

            Cell celIdade = linha.createCell(celula++);
            celIdade.setCellValue(p.getIdade());
        } //Fim da montagem da planilha.

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);/* Escreve planilha em arquivo */

        saida.flush();
        saida.close();

        System.out.println("Planilha foi criada com sucesso");

    }
}
