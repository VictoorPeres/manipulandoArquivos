package br.com.avancard;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.Iterator;

public class ApachePOIEditando {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\arquivo_excel.xls"); //Arquivo instanciado
        FileInputStream entrada = new FileInputStream(file);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);

        Iterator<Row> linhaIterator = planilha.iterator();

        while (linhaIterator.hasNext()) {//Enquanto tiver linhas, o código é executado
            Row linha = linhaIterator.next();//Dados das pessoas na linha

            int numeroCelulas = linha.getPhysicalNumberOfCells(); //Quantidade de células

            Cell cell = linha.createCell(numeroCelulas); //Cria a nova celula na linha
            cell.setCellValue("5.487,20");
        }
        entrada.close();

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("Planilha atualizada");
    }
}
