package com.howtodoinjava.dom;

//package org.automationtesting.excelreport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

public class XL {
    private static FileOutputStream fos = null;
    private static XSSFWorkbook workbook = null;
    private static XSSFSheet sheet = null;
    private static XSSFRow row = null;
    private static XSSFCell cell = null;
    private static XSSFFont font = null;
    private static XSSFFont headerFont = null;
    private static XSSFCellStyle style = null;
    private static XSSFCellStyle headerStyle = null;
    private static String iOSsummarySheetName = "iOSSummary";
    private static String AndroidsummarySheetName = "AndroidSummary";
    private static int colCount = 0;
    // private static PropertyFileReader prop = new PropertyFileReader();

    public XL() {
    }

    public static void generateReport(String xlFileName) throws Exception {
        FileInputStream file = new FileInputStream("./ExcelReportTemplate/Report_ExcelTemplate.xlsm");

        String path = System.getProperty("user.dir") + "/test-output/";
        File xmlFile = new File(path + "testng-results.xml");

        /////////////////////////////////////////////////////////////////
        DefaultHandler handler = new DefaultHandler();
        InputStream inputStream = new FileInputStream(xmlFile);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        InputSource is = new InputSource(reader);
        is.setEncoding("UTF-8");
        ////////////////////////////////////////////////////////////////////////////

        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document doc = build.parse(is);
        doc.getDocumentElement().normalize();

        workbook = new XSSFWorkbook(file);
        font = workbook.createFont();
        headerFont = workbook.createFont();
        style = workbook.createCellStyle();
        headerStyle = workbook.createCellStyle();

        /*
         * NodeList test_results = doc.getElementsByTagName("testng-results");
         * Node test_results_node = test_results.item(0);
         * String total = ((Element)test_results_node).getAttribute("total");
         * String passed = ((Element)test_results_node).getAttribute("passed");
         * String failed = ((Element)test_results_node).getAttribute("failed");
         * String terminated = ((Element)test_results_node).getAttribute("skipped");
         */

        NodeList test_suite = doc.getElementsByTagName("suite");
        Node test_suite_node = test_suite.item(0);

        String test_suite_startTime = ((Element) test_suite_node).getAttribute("started-at");
        String test_suite_endTime = ((Element) test_suite_node).getAttribute("finished-at");
        String test_suite_duration = ((Element) test_suite_node).getAttribute("duration-ms");

        // addSheet(summarySheetName);
        if (Constants.PLATFORM.equalsIgnoreCase("iOS")) {
            getSheet(iOSsummarySheetName);

            /*
             * setCellHeaderData(summarySheetName, 0, 0, "Category", Short.valueOf((short)13));
             * setCellHeaderData(summarySheetName, 1, 0, "Count", Short.valueOf((short)13));
             *
             * setCellData(summarySheetName, 0, 1, "Passed", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 1, passed, Short.valueOf((short)9));
             *
             * setCellData(summarySheetName, 0, 2, "Failed", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 2, failed, Short.valueOf((short)9));
             *
             * setCellData(summarySheetName, 0, 3, "Terminated", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 3, terminated, Short.valueOf((short)9));
             *
             * setCellHeaderData(summarySheetName, 0, 4, "Total", Short.valueOf((short)49));
             * setCellHeaderData(summarySheetName, 1, 4, total, Short.valueOf((short)49));
             */

            setCellData(iOSsummarySheetName, 0, 1, "Start Time", Short.valueOf((short) 9));
            setCellData(iOSsummarySheetName, 1, 1, test_suite_startTime, Short.valueOf((short) 9));

            setCellData(iOSsummarySheetName, 0, 2, "End Time", Short.valueOf((short) 9));
            setCellData(iOSsummarySheetName, 1, 2, test_suite_endTime, Short.valueOf((short) 9));

            setCellData(iOSsummarySheetName, 0, 3, "Duration", Short.valueOf((short) 9));
            setCellData(iOSsummarySheetName, 1, 3, (Integer.parseInt(test_suite_duration) / 1000) / 60 + "m", Short.valueOf((short) 9));
        } else if (Constants.PLATFORM.equalsIgnoreCase("Android")) {
            getSheet(AndroidsummarySheetName);

            /*
             * setCellHeaderData(summarySheetName, 0, 0, "Category", Short.valueOf((short)13));
             * setCellHeaderData(summarySheetName, 1, 0, "Count", Short.valueOf((short)13));
             *
             * setCellData(summarySheetName, 0, 1, "Passed", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 1, passed, Short.valueOf((short)9));
             *
             * setCellData(summarySheetName, 0, 2, "Failed", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 2, failed, Short.valueOf((short)9));
             *
             * setCellData(summarySheetName, 0, 3, "Terminated", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 3, terminated, Short.valueOf((short)9));
             *
             * setCellHeaderData(summarySheetName, 0, 4, "Total", Short.valueOf((short)49));
             * setCellHeaderData(summarySheetName, 1, 4, total, Short.valueOf((short)49));
             */

            setCellData(AndroidsummarySheetName, 0, 1, "Start Time", Short.valueOf((short) 9));
            setCellData(AndroidsummarySheetName, 1, 1, test_suite_startTime, Short.valueOf((short) 9));

            setCellData(AndroidsummarySheetName, 0, 2, "End Time", Short.valueOf((short) 9));
            setCellData(AndroidsummarySheetName, 1, 2, test_suite_endTime, Short.valueOf((short) 9));

            setCellData(AndroidsummarySheetName, 0, 3, "Duration", Short.valueOf((short) 9));
            setCellData(AndroidsummarySheetName, 1, 3, (Integer.parseInt(test_suite_duration) / 1000) / 60 + "m", Short.valueOf((short) 9));
        }
        /*
         * colCount = getColumnCount(summarySheetName);
         * for (int colPosition = 0; colPosition < colCount; colPosition++)
         * {
         * sheet.autoSizeColumn((short)colPosition);
         * }
         */

        /*
         * DefaultPieDataset my_pie_chart_data = new DefaultPieDataset();
         *
         * my_pie_chart_data.setValue("Passed", Integer.parseInt(passed));
         * my_pie_chart_data.setValue("Failed", Integer.parseInt(failed));
         * my_pie_chart_data.setValue("Terminated", Integer.parseInt(terminated));
         *
         * JFreeChart myPieChart = ChartFactory.createBarChart("Mobile App -Execution Status", "TC Count", "Test Set", (CategoryDataset) my_pie_chart_data,
         * PlotOrientation.VERTICAL,true,true,false);
         *
         * PiePlot plot = (PiePlot)myPieChart.getPlot();
         * plot.setSectionPaint(1, new Color(255, 0, 0));
         * plot.setSectionPaint(0, new Color(0, 128, 0));
         * plot.setSectionPaint(2, new Color(255, 255, 0));
         *
         * int width = 500;
         * int height = 500;
         * float quality = 5.0F;
         * ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
         * ChartUtilities.writeChartAsJPEG(chart_out, quality, myPieChart, width, height);
         * int my_picture_id = workbook.addPicture(chart_out.toByteArray(), 5);
         * chart_out.close();
         * XSSFDrawing drawing = sheet.createDrawingPatriarch();
         * ClientAnchor my_anchor = new XSSFClientAnchor();
         * my_anchor.setCol1(4);
         * my_anchor.setRow1(5);
         * XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
         * my_picture.resize();
         */

        NodeList test_list = doc.getElementsByTagName("test");
        for (int i = 0; i < test_list.getLength(); i++) {
            int r = 0;
            Node test_node = test_list.item(i);
            String test_name = ((Element) test_node).getAttribute("name");

            // addSheet(test_name);
            getSheet(test_name);
            setCellHeaderData(test_name, 0, 0, "TestSet", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 1, 0, "TestCase Name", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 2, 0, "Status", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 3, 0, "Exception", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 4, 0, "Start Time", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 5, 0, "End Time", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 6, 0, "Duration", Short.valueOf((short) 13));

            NodeList class_list = ((Element) test_node).getElementsByTagName("class");
            for (int j = 0; j < class_list.getLength(); j++) {
                Node class_node = class_list.item(j);
                String class_name = ((Element) class_node).getAttribute("name");
                NodeList test_method_list = ((Element) class_node).getElementsByTagName("test-method");

                for (int k = 0; k < test_method_list.getLength(); k++) {
                    Node test_method_node = test_method_list.item(k);
                    String class_name1 = ((Element) class_node).getAttribute("class");
                    String test_method_name = ((Element) test_method_node).getAttribute("name");
                    String test_method_status = ((Element) test_method_node).getAttribute("status");
                    String test_method_startTime = ((Element) test_method_node).getAttribute("started-at");
                    String test_method_endTime = ((Element) test_method_node).getAttribute("finished-at");
                    String test_method_duration = ((Element) test_method_node).getAttribute("duration-ms");
                    String test_method_isConfig = ((Element) test_method_node).getAttribute("is-config");

                    if (test_method_isConfig == "") {
                        r++;
                    }

                    if (test_method_isConfig == "") {
                        setCellData(test_name, 0, r, class_name, Short.valueOf((short) 9));
                        setCellData(test_name, 1, r, class_name + "." + test_method_name, Short.valueOf((short) 9));
                    }
                    if ((test_method_status.equalsIgnoreCase("pass")) && (test_method_isConfig == "")) {
                        setCellData(test_name, 2, r, test_method_status, Short.valueOf((short) 11));
                        setCellData(test_name, 3, r, "", Short.valueOf((short) 9));
                    }
                    if ((test_method_status.equalsIgnoreCase("fail")) && (test_method_isConfig == "")) {
                        setCellData(test_name, 2, r, test_method_status, Short.valueOf((short) 10));

                        NodeList exp_list = ((Element) test_method_node).getElementsByTagName("exception");
                        for (int a = 0; a < exp_list.getLength(); a++) {
                            Node err_node = exp_list.item(a);
                            NodeList test_err_list = ((Element) err_node).getElementsByTagName("message");
                            for (int b = 0; b < test_err_list.getLength(); b++) {
                                Node err_msg_node = test_err_list.item(b);
                                String err_msg = ((Element) err_msg_node).getTextContent().trim();
                                setCellData(test_name, 3, r, err_msg, Short.valueOf((short) 9));
                            }
                        }
                    }
                    if ((test_method_status.equalsIgnoreCase("skip")) && (test_method_isConfig == "")) {
                        setCellData(test_name, 2, r, test_method_status, Short.valueOf((short) 13));
                        NodeList exp_list = ((Element) test_method_node).getElementsByTagName("exception");

                        for (int a = 0; a < exp_list.getLength(); a++) {
                            Node err_node = exp_list.item(a);
                            NodeList test_err_list = ((Element) err_node).getElementsByTagName("message");
                            for (int b = 0; b < test_err_list.getLength(); b++) {
                                Node err_msg_node = test_err_list.item(b);
                                String err_msg = ((Element) err_msg_node).getTextContent().trim();
                                setCellData(test_name, 3, r, err_msg, Short.valueOf((short) 9));
                            }
                        }
                    }
                    if (test_method_isConfig == "") {
                        setCellData(test_name, 4, r, test_method_startTime, Short.valueOf((short) 9));
                        setCellData(test_name, 5, r, test_method_endTime, Short.valueOf((short) 9));
                        setCellData(test_name, 6, r, (Integer.parseInt(test_method_duration) / 1000) % 60 + "s", Short.valueOf((short) 9));
                    }
                }
                colCount = getColumnCount(test_name);
                for (int colPosition = 0; colPosition < colCount; colPosition++) {
                    sheet.autoSizeColumn((short) colPosition);
                }
            }
        }

        fos = new FileOutputStream(System.getProperty("user.dir") + "/test-output/" + xlFileName);
        workbook.write(fos);
        workbook.close();
        fos.close();

        System.out.println("Excel Report Generated");
    }

    public static void generateReport(String folderLocation, String xlFileName) throws Exception {
        FileInputStream file = new FileInputStream("./ExcelReportTemplate/Report_ExcelTemplate.xlsm");
        String path = System.getProperty("user.dir") + "/test-output/";
        File xmlFile = new File(path + "testng-results.xml");

        /////////////////////////////////////////////////////////////////
        DefaultHandler handler = new DefaultHandler();
        InputStream inputStream = new FileInputStream(xmlFile);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        InputSource is = new InputSource(reader);
        is.setEncoding("UTF-8");
        ////////////////////////////////////////////////////////////////////////////
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document doc = build.parse(is);
        doc.getDocumentElement().normalize();

        workbook = new XSSFWorkbook(file);
        font = workbook.createFont();
        headerFont = workbook.createFont();
        style = workbook.createCellStyle();
        headerStyle = workbook.createCellStyle();

        /*
         * NodeList test_results = doc.getElementsByTagName("testng-results");
         * Node test_results_node = test_results.item(0);
         * String total = ((Element)test_results_node).getAttribute("total");
         * String passed = ((Element)test_results_node).getAttribute("passed");
         * String failed = ((Element)test_results_node).getAttribute("failed");
         * String terminated = ((Element)test_results_node).getAttribute("skipped");
         */

        NodeList test_suite = doc.getElementsByTagName("suite");
        Node test_suite_node = test_suite.item(0);

        String test_suite_startTime = ((Element) test_suite_node).getAttribute("started-at");
        String test_suite_endTime = ((Element) test_suite_node).getAttribute("finished-at");
        String test_suite_duration = ((Element) test_suite_node).getAttribute("duration-ms");

        // addSheet(summarySheetName);
        if (Constants.PLATFORM.equalsIgnoreCase("iOS")) {
            getSheet(iOSsummarySheetName);
            /*
             * setCellHeaderData(summarySheetName, 0, 0, "Category", Short.valueOf((short)13));
             * setCellHeaderData(summarySheetName, 1, 0, "Count", Short.valueOf((short)13));
             *
             * setCellData(summarySheetName, 0, 1, "Passed", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 1, passed, Short.valueOf((short)9));
             *
             * setCellData(summarySheetName, 0, 2, "Failed", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 2, failed, Short.valueOf((short)9));
             *
             * setCellData(summarySheetName, 0, 3, "Terminated", Short.valueOf((short)9));
             * setCellData(summarySheetName, 1, 3, terminated, Short.valueOf((short)9));
             *
             * setCellHeaderData(summarySheetName, 0, 4, "Total", Short.valueOf((short)49));
             * setCellHeaderData(summarySheetName, 1, 4, total, Short.valueOf((short)49));
             */

            setCellData(iOSsummarySheetName, 0, 1, "Start Time", Short.valueOf((short) 9));
            setCellData(iOSsummarySheetName, 1, 1, test_suite_startTime, Short.valueOf((short) 9));

            setCellData(iOSsummarySheetName, 0, 2, "End Time", Short.valueOf((short) 9));
            setCellData(iOSsummarySheetName, 1, 2, test_suite_endTime, Short.valueOf((short) 9));

            setCellData(iOSsummarySheetName, 0, 3, "Duration", Short.valueOf((short) 9));
            setCellData(iOSsummarySheetName, 1, 3, (Integer.parseInt(test_suite_duration) / 1000) / 60 + "m", Short.valueOf((short) 9));
        } else if (Constants.PLATFORM.equalsIgnoreCase("Android")) {
            getSheet(AndroidsummarySheetName);
            setCellData(AndroidsummarySheetName, 0, 1, "Start Time", Short.valueOf((short) 9));
            setCellData(AndroidsummarySheetName, 1, 1, test_suite_startTime, Short.valueOf((short) 9));

            setCellData(AndroidsummarySheetName, 0, 2, "End Time", Short.valueOf((short) 9));
            setCellData(AndroidsummarySheetName, 1, 2, test_suite_endTime, Short.valueOf((short) 9));

            setCellData(AndroidsummarySheetName, 0, 3, "Duration", Short.valueOf((short) 9));
            setCellData(AndroidsummarySheetName, 1, 3, (Integer.parseInt(test_suite_duration) / 1000) / 60 + "m", Short.valueOf((short) 9));
        }
        /*
         * colCount = getColumnCount(summarySheetName);
         * for (int colPosition = 0; colPosition < colCount; colPosition++)
         * {
         * sheet.autoSizeColumn((short)colPosition);
         * }
         */

        /*
         * DefaultPieDataset my_pie_chart_data = new DefaultPieDataset();
         *
         * my_pie_chart_data.setValue("Passed", Integer.parseInt(passed));
         * my_pie_chart_data.setValue("Failed", Integer.parseInt(failed));
         * my_pie_chart_data.setValue("Terminated", Integer.parseInt(terminated));
         *
         * JFreeChart myPieChart = ChartFactory.createPieChart("Execution Status in PIE Chart", my_pie_chart_data, true, true, false);
         *
         * PiePlot plot = (PiePlot)myPieChart.getPlot();
         * plot.setSectionPaint(1, new Color(255, 0, 0));
         * plot.setSectionPaint(0, new Color(0, 128, 0));
         * plot.setSectionPaint(2, new Color(255, 255, 0));
         *
         * int width = 500;
         * int height = 500;
         * float quality = 5.0F;
         * ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
         * ChartUtilities.writeChartAsJPEG(chart_out, quality, myPieChart, width, height);
         * int my_picture_id = workbook.addPicture(chart_out.toByteArray(), 5);
         * chart_out.close();
         * XSSFDrawing drawing = sheet.createDrawingPatriarch();
         * ClientAnchor my_anchor = new XSSFClientAnchor();
         * my_anchor.setCol1(4);
         * my_anchor.setRow1(5);
         * XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
         * my_picture.resize();
         */

        NodeList test_list = doc.getElementsByTagName("test");
        for (int i = 0; i < test_list.getLength(); i++) {
            int r = 0;
            Node test_node = test_list.item(i);
            String test_name = ((Element) test_node).getAttribute("name");

            // addSheet(test_name);
            getSheet(test_name);
            setCellHeaderData(test_name, 0, 0, "TestSet", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 1, 0, "TestCase Name", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 2, 0, "Status", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 3, 0, "Exception", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 4, 0, "Start Time", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 5, 0, "End Time", Short.valueOf((short) 13));
            setCellHeaderData(test_name, 6, 0, "Duration", Short.valueOf((short) 13));

            NodeList class_list = ((Element) test_node).getElementsByTagName("class");
            for (int j = 0; j < class_list.getLength(); j++) {
                Node class_node = class_list.item(j);
                String class_name = ((Element) class_node).getAttribute("name");

                NodeList test_method_list = ((Element) class_node).getElementsByTagName("test-method");

                for (int k = 0; k < test_method_list.getLength(); k++) {
                    Node test_method_node = test_method_list.item(k);
                    String class_name1 = ((Element) test_method_node).getAttribute("class");
                    String test_method_name = ((Element) test_method_node).getAttribute("name");
                    String test_method_status = ((Element) test_method_node).getAttribute("status");
                    String test_method_startTime = ((Element) test_method_node).getAttribute("started-at");
                    String test_method_endTime = ((Element) test_method_node).getAttribute("finished-at");
                    String test_method_duration = ((Element) test_method_node).getAttribute("duration-ms");
                    String test_method_isConfig = ((Element) test_method_node).getAttribute("is-config");

                    if (test_method_isConfig == "") {
                        r++;
                    }

                    if (test_method_isConfig == "") {
                        setCellData(test_name, 0, r, class_name, Short.valueOf((short) 9));
                        setCellData(test_name, 1, r, class_name + "." + test_method_name, Short.valueOf((short) 9));
                    }
                    if ((test_method_status.equalsIgnoreCase("pass")) && (test_method_isConfig == "")) {
                        setCellData(test_name, 2, r, test_method_status, Short.valueOf((short) 11));
                        setCellData(test_name, 3, r, "", Short.valueOf((short) 9));
                    }
                    if ((test_method_status.equalsIgnoreCase("fail")) && (test_method_isConfig == "")) {
                        setCellData(test_name, 2, r, test_method_status, Short.valueOf((short) 10));

                        NodeList exp_list = ((Element) test_method_node).getElementsByTagName("exception");
                        for (int a = 0; a < exp_list.getLength(); a++) {
                            Node err_node = exp_list.item(a);
                            NodeList test_err_list = ((Element) err_node).getElementsByTagName("message");
                            for (int b = 0; b < test_err_list.getLength(); b++) {
                                Node err_msg_node = test_err_list.item(b);
                                String err_msg = ((Element) err_msg_node).getTextContent().trim();
                                setCellData(test_name, 3, r, err_msg, Short.valueOf((short) 9));
                            }
                        }
                    }
                    if ((test_method_status.equalsIgnoreCase("skip")) && (test_method_isConfig == "")) {
                        setCellData(test_name, 2, r, test_method_status, Short.valueOf((short) 13));
                        NodeList exp_list = ((Element) test_method_node).getElementsByTagName("exception");

                        for (int a = 0; a < exp_list.getLength(); a++) {
                            Node err_node = exp_list.item(a);
                            NodeList test_err_list = ((Element) err_node).getElementsByTagName("message");
                            for (int b = 0; b < test_err_list.getLength(); b++) {
                                Node err_msg_node = test_err_list.item(b);
                                String err_msg = ((Element) err_msg_node).getTextContent().trim();
                                setCellData(test_name, 3, r, err_msg, Short.valueOf((short) 9));
                            }
                        }
                    }
                    if (test_method_isConfig == "") {
                        setCellData(test_name, 4, r, test_method_startTime, Short.valueOf((short) 9));
                        setCellData(test_name, 5, r, test_method_endTime, Short.valueOf((short) 9));
                        setCellData(test_name, 6, r, (Integer.parseInt(test_method_duration) / 1000) % 60 + "s", Short.valueOf((short) 9));
                    }
                }
                colCount = getColumnCount(test_name);
                for (int colPosition = 0; colPosition < colCount; colPosition++) {
                    sheet.autoSizeColumn((short) colPosition);
                }
            }
        }

        fos = new FileOutputStream(folderLocation + "/" + xlFileName);
        workbook.write(fos);
        workbook.close();
        fos.close();

        System.out.println("Excel Report Generated");
    }

    private static boolean setCellData(String sheetName, int colNumber, int rowNum, String value, Short index) {
        try {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            cell = row.getCell(colNumber);
            if (cell == null) {
                cell = row.createCell(colNumber);
            }
            applyCellStyle(index.shortValue());
            cell.setCellValue(value);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean setCellHeaderData(String sheetName, int colNumber, int rowNum, String value, Short index) {
        try {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            cell = row.getCell(colNumber);
            if (cell == null) {
                cell = row.createCell(colNumber);
            }
            applyCellHeaderStyle(index.shortValue());
            cell.setCellValue(value);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    private static String addSheet(String sheetname) {
        sheet = workbook.createSheet(sheetname);
        sheet.setDisplayGridlines(true);
        sheet.setPrintGridlines(true);
        return sheetname;
    }

    private static String getSheet(String sheetname) {
        sheet = workbook.getSheet(sheetname);
        sheet.setDisplayGridlines(true);
        sheet.setPrintGridlines(true);
        return sheetname;
    }

    private static void applyCellStyle(short index) {
        style = workbook.createCellStyle();
        font.setFontName("Calibri");
        font.setFontHeight(11.0D);
        style.setFont(font);
        style.setFillForegroundColor(index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        cell.setCellStyle(style);
    }

    private static void applyCellHeaderStyle(short index) {
        headerStyle = workbook.createCellStyle();
        headerFont.setFontName("Calibri");
        headerFont.setFontHeight(12.0D);
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.THICK);
        headerStyle.setBorderTop(BorderStyle.THICK);
        headerStyle.setBorderRight(BorderStyle.THICK);
        headerStyle.setBorderLeft(BorderStyle.THICK);
        cell.setCellStyle(headerStyle);
    }

    private static int getColumnCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        return colCount;
    }
}