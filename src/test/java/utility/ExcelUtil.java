package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtil {
	private String path = "";
    private String sheetName = "";
    private int sheetNum = 0 ;
    XSSFWorkbook wb;
    public ExcelUtil(String path, String sheetName) {

        this.path = path;
        this.sheetName = sheetName;
        init(new File(path));

    }
    public ExcelUtil(String path, int sheetNum) {
        this.path = path;
        this.sheetNum = sheetNum;
        init(new File(path));
    }
    public void init(File file) {
        try {

            wb = new XSSFWorkbook(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private XSSFSheet getSheet() throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XSSFSheet sheet;
        if (sheetName.equals("UC014")) {
            sheet = new XSSFWorkbook(fis).getSheetAt(sheetNum);
        } else {
            sheet = new XSSFWorkbook(fis).getSheet(sheetName);
        }
        return sheet;
    }
    public List<Map<String, String>> getExcelAsMap() throws IOException {
        XSSFSheet sheet = getSheet();
        List<Map<String, String>> completeSheetData = new ArrayList<Map<String, String>>();
        List<String> columnHeader = new ArrayList<String>();
        Row row = sheet.getRow(0);
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            columnHeader.add(cellIterator.next().getStringCellValue());
        }
        int rowCount = sheet.getLastRowNum();

        int columnCount = row.getLastCellNum();

        for (int i = 1; i <= rowCount; i++) {
            Map<String, String> singleRowData = new HashMap<String, String>();
            XSSFRow row1 = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                XSSFCell cell = row1.getCell(j);

              singleRowData.put(columnHeader.get(j), String.valueOf(cell));
            //    singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));


            }

            completeSheetData.add(singleRowData);
        }
        return completeSheetData;
    }

    public String getSheetName(int index) throws IOException {
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        String sheet = workbook.getSheetName(index);
        return sheet;
    }

    public int getSheetCount() throws IOException {
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        int sheetCount = workbook.getNumberOfSheets();
        return sheetCount;
    }

    public int totolColumnCount() throws IOException {
        XSSFSheet sheet = getSheet();
        Row row = sheet.getRow(0);
        int lastColumnNum = row.getLastCellNum();
        return lastColumnNum;
    }

    public String getCellValueAsString(XSSFCell cell) {
        String cellValue = null;
        switch (cell.getCellType()) {
            default:
                cellValue = "DEFAULT";
        }
        return cellValue;
    }

    public int getRowsCount(String path, String sheetName)
    {
        init(new File(path));
        XSSFSheet sheet;
        sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()+1;
        return rowCount;
        //return 0;


    }
<<<<<<< HEAD
    
}
=======
 
  

	
}
>>>>>>> Haseena_Team2
