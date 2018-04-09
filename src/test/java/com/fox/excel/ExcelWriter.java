package com.fox.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;


public class ExcelWriter {
    Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
    Sheet sheet = workbook.createSheet("Show");
    private File filePath;
    private int rownum = 0;

    public ArrayList<String> ReadFromExcelSheet() throws IOException {
        ArrayList<String> titles = new ArrayList<>();

        if(filePath.exists()){
            FileInputStream file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); //Skip the header
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    String value = cell.getStringCellValue();
                    titles.add(value);

                }
            }
            file.close();
        }
        return titles;
    }
    public void WriteToExcelSheet(ArrayList<String> shows){

        createHeader("Show");

        for(String show : shows){
            Row row  = sheet.createRow(rownum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(show);
        }

        try {
            String loc = Paths.get(".").toAbsolutePath().normalize().toString();
            filePath = new File(loc, "\\src\\test\\Output\\Fox_shows.xlsx");
            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Font createHeaderFont(){
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        return headerFont;
    }

    private void createHeader(String header){
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(createHeaderFont());

        // Create a Header
        Row headerRow = sheet.createRow(rownum++);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue(header);
        headerCell.setCellStyle(headerCellStyle);

    }
}
