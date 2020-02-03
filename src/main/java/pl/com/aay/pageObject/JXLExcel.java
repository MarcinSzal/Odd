package pl.com.aay.pageObject;

import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

import java.io.FileInputStream;
import java.util.*;

public class JXLExcel {

    private String path = "C:\\Users\\zs\\Desktop\\Module2\\src\\test\\resources\\pl\\com\\aay\\test_data";

    public JXLExcel() {
    }

    public void dest() throws Exception {
        FileInputStream fi = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook();
        Sheet ws = wb.createSheet();

        for (int row = 1; row < ws.getLastRowNum(); row++) {
            int data = ws.getActiveCell().getColumn();


        }
    }
}
