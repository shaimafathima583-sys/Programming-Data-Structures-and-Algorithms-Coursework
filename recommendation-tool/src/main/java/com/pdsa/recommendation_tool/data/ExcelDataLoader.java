package com.pdsa.recommendation_tool.data;

import com.pdsa.recommendation_tool.model.Location;

import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelDataLoader {

    public List<Location> loadLocations(String fileName) {

        List<Location> locations =
                new ArrayList<>();

        try {

            ClassPathResource resource =
                    new ClassPathResource(
                            "data/" + fileName
                    );

            InputStream inputStream =
                    resource.getInputStream();

            Workbook workbook =
                    WorkbookFactory.create(
                            inputStream
                    );

            Sheet sheet =
                    workbook.getSheetAt(0);

            for (int i = 1;
                 i <= sheet.getLastRowNum();
                 i++) {

                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                String name =
                        getString(row.getCell(0));

                String district =
                        getString(row.getCell(1));

                String province =
                        getString(row.getCell(2));

                int population =
                        (int) getDouble(row.getCell(3));

                double purchasingPower =
                        getDouble(row.getCell(4));

                double competition =
                        getDouble(row.getCell(5));

                double facilities =
                        getDouble(row.getCell(6));

                double roadAccess =
                        getDouble(row.getCell(7));

                double customerDensity =
                        getDouble(row.getCell(8));

                int numBusinesses =
                        (int) getDouble(row.getCell(9));

                double avgIncome =
                        getDouble(row.getCell(10));

                double latitude =
                        getDouble(row.getCell(11));

                double longitude =
                        getDouble(row.getCell(12));

                Location location =
                        new Location(
                                name,
                                district,
                                province,
                                population,
                                purchasingPower,
                                competition,
                                facilities,
                                roadAccess,
                                customerDensity,
                                numBusinesses,
                                avgIncome,
                                latitude,
                                longitude
                        );

                locations.add(location);
            }

            workbook.close();
            inputStream.close();

        } catch (Exception e) {

            System.out.println(
                    "Error loading Excel file: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }

        return locations;
    }

    private String getString(Cell cell) {

        if (cell == null) {
            return "";
        }

        return cell.toString().trim();
    }

    private double getDouble(Cell cell) {

        if (cell == null) {
            return 0.0;
        }

        if (cell.getCellType() ==
                CellType.NUMERIC) {

            return cell.getNumericCellValue();
        }

        try {

            return Double.parseDouble(
                    cell.toString().trim()
            );

        } catch (NumberFormatException e) {

            return 0.0;
        }
    }
}