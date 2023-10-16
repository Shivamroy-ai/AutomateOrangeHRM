package org.example.ddt;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataDrivenTesting {

  public static void main(String[] args) {
    try {
      String [][]readExcel=readExcel();

        System.out.println(readExcel.length);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static String[][] readExcel() throws IOException {
      FileInputStream file = new FileInputStream(new File("src\\main\\java\\org\\example\\testdata\\OrangHRMTestDataFile.xlsx"));
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      Map<String, String> list = new HashMap<>();

      DataFormatter dataFormatter = new DataFormatter();
         int sheetNo=workbook.getSheetIndex("Login");
      int totalrow = workbook.getSheetAt(sheetNo).getLastRowNum()+1;
      int totalrowcell = workbook.getSheetAt(sheetNo).getRow(0).getLastCellNum();

      System.out.println("Row Length = " + totalrow + "\n" + "Cell length = " + totalrowcell);
      String[][] loginData = new String[totalrow][totalrowcell];

      for (Sheet sheet : workbook) {
          if (sheet.getSheetName().equalsIgnoreCase("Login")) {

              int i = 0;
              for (Row row : sheet) {
                  int j = 0;
                  for (Cell cell : row) {
                      String cellValue = dataFormatter.formatCellValue(cell);
                      loginData[i][j] = cellValue;
                      j++;
                  }
                  i++;
              }
          }
      }

      return loginData;
  }
}
