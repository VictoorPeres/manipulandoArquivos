package br.com.avancard;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePOI2 {

    public static void main(String[] args) throws IOException {

        FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\arquivo_excel.xls"));

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (linhaIterator.hasNext()) {
            Row linha = linhaIterator.next();

            Iterator<Cell> celulas = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while (celulas.hasNext()) {
                Cell cell = celulas.next();

                switch (cell.getColumnIndex()){
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                    case 2:
                        pessoa.setIdade(5);
                        break;
                }

            }
            pessoas.add(pessoa);
        }

        entrada.close();
        System.out.println(pessoas.toString());
    }
}
