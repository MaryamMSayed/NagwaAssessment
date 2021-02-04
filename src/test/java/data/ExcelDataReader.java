package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataReader {
    static FileInputStream fis = null;

    public FileInputStream getFileInputStream() {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/Search_query_sheet.xlsx";
        File srcFile = new File(filePath);
        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Someting Wrong with test data File : " + e.getMessage());
            System.exit(0);
        }
        return fis;
    }

    public Object[][] getExcelFileTestData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        //Read data including Last Row data
        int totalNumberOfRows = 1;
        //int totalNumberOfRows= (sheet.getLastRowNum()+1);
        int totalNumberOfColumns = 1;
        String[][] arrayOfExcelData = new String[totalNumberOfRows][totalNumberOfColumns];
        for (int i = 0; i < totalNumberOfRows; i++) {
            for (int j = 0; j < totalNumberOfColumns; j++) {
                XSSFRow rowData = sheet.getRow(i);
                arrayOfExcelData[i][j] = rowData.getCell(j).toString();

            }

        }

        wb.close();
        return arrayOfExcelData;


    }
}
