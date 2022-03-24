package Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	public static void writeExcel() {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "Gabbar", "Singh"});
        data.put("5", new Object[] {4, "Jetha", "Lal"});

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
                XSSFRow row = sheet.createRow(rownum++);
                Object [] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr)
                {
                        XSSFCell cell = row.createCell(cellnum++);
                        if(obj instanceof String)
                                cell.setCellValue((String)obj);
                        else if(obj instanceof Integer)
                                cell.setCellValue((Integer)obj);
                }
        }
        try
        {
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream(new File("src\\test\\java\\Pages\\file01.xlsx"));
                workbook.write(out); 

                out.close();
                System.out.println("writeTestDataFile.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
                e.printStackTrace();
        }
}
	public static void main(String[] args) {
		writeExcel();
	}
}