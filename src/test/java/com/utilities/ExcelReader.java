package com.utilities;


	
	

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.LinkedHashMap;
	import java.util.List;
	import java.util.Map;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;



	public class ExcelReader {
		
		public List<Map<String, String>> ReadExcelFile(String sheetName)
		{
			 ReadConfig config = new ReadConfig();
			List<Map<String, String>> sheetData = null;
			try
			{
				
				FileInputStream fs = new FileInputStream(config.getExcelPath());
				try (XSSFWorkbook wb = new XSSFWorkbook(fs)) {
					XSSFSheet sheet = wb.getSheet(sheetName);
					sheetData = ReadSheet(sheet);
				}
			}
			catch(IOException ex)
			{
				Log.error(ex.getMessage());
			}
			
			return sheetData;
		}
		
		private List<Map<String, String>> ReadSheet(Sheet sheet) 
		{
			Row row;
			Cell cell;

			int rowCount = sheet.getLastRowNum();

			List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

			for (int currentRow = 1; currentRow <= rowCount; currentRow++) 
			{
				row = sheet.getRow(currentRow);
				int totalColumn = row.getLastCellNum();

				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();

				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) 
				{
					cell = row.getCell(currentColumn);
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				}
				excelRows.add(columnMapdata);
			}
			return excelRows;
		}

	

}
