package com.example.demo.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.inmuebles.Inmuebles;

public class InmuebleExcel {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Inmuebles> listInmuebles;
	
	
	public InmuebleExcel(List<Inmuebles> listInmuebles) {
		this.listInmuebles = listInmuebles;
		workbook = new XSSFWorkbook();
	}
	
	private void escribirEncabezado() {
		sheet = workbook.createSheet("Inmuebles");
		
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		crearCeldas(row, 0, "Inmueble ID", style);
		crearCeldas(row, 1, "GRUPO", style);
		crearCeldas(row, 2, "ALCALDIA", style);
		crearCeldas(row, 3, "Calle", style);
		crearCeldas(row, 4, "Numero", style);
		crearCeldas(row, 5, "INICIO", style);
		crearCeldas(row, 6, "TERMINO", style);
		crearCeldas(row, 7, "AVANCE", style);
		crearCeldas(row, 8, "FICHAS FIRMADAS", style);
		crearCeldas(row, 9, "VALORES", style);
		crearCeldas(row, 10, "PENALIZACIONES", style);
		crearCeldas(row, 11, "FIRMA REGIMEN", style);
		crearCeldas(row, 12, "NOTARIA", style);
		crearCeldas(row, 13, "IND AGUA", style);
		crearCeldas(row, 14, "IND PREDIAL", style);
		crearCeldas(row, 15, "ESTATUS", style);
		crearCeldas(row, 16, "DEPARTAMENTOS", style);
		crearCeldas(row, 17, "LOCALES COMERCIALES", style);
		crearCeldas(row, 18, "OFICINAS", style);
		crearCeldas(row, 19, "CAJONES ESTACIONAMIENTOS", style);
		crearCeldas(row, 20, "BODEGAS", style);
		crearCeldas(row, 21, "DACION DE PAGOS", style);
		crearCeldas(row, 22, "UNIDADES", style);
		crearCeldas(row, 23, "COMENTARIOS", style);
		crearCeldas(row, 24, "ARCHIVO", style);
	}
	
	private void crearCeldas(Row row, int columna, Object obj, CellStyle style) {
		sheet.autoSizeColumn(columna);
		Cell cell = row.createCell(columna);
		if (obj instanceof Integer) {
            cell.setCellValue((Integer) obj);
        } else if (obj instanceof Boolean) {
            cell.setCellValue((Boolean) obj);
        }else {
            cell.setCellValue((String) obj);
        }
		cell.setCellStyle(style);
	}
	
	private void DatosCeldas() {
		int contadorFilas = 1;
		CellStyle style  = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		
		for (Inmuebles inmueble : listInmuebles) {
			Row row = sheet.createRow(contadorFilas);
			int columnas = 0;
			crearCeldas(row, columnas++, inmueble.getId(), style);//0
			crearCeldas(row, columnas++, inmueble.getGrupo(), style);//1
			crearCeldas(row, columnas++, inmueble.getAlcaldia(), style);//2
			crearCeldas(row, columnas++, inmueble.getCalle(), style);//3
			crearCeldas(row, columnas++, inmueble.getNumero(), style);//4
			crearCeldas(row, columnas++, inmueble.getIdprocesoobra().getInicio(), style);//5
			crearCeldas(row, columnas++, inmueble.getIdprocesoobra().getTermino(), style);//6
			crearCeldas(row, columnas++, inmueble.getIdprocesoobra().getAvance(), style);//7
			crearCeldas(row, columnas++, inmueble.getIdinfotecnica().getFichas(), style);//8
			crearCeldas(row, columnas++, inmueble.getIdinfotecnica().getValores(), style);//9
			crearCeldas(row, columnas++, inmueble.getIdprocesojuridico().getContrato(), style);//10
			crearCeldas(row, columnas++, inmueble.getIdprocesojuridico().getFecha(), style);//11
			crearCeldas(row, columnas++, inmueble.getIdprocesojuridico().getNotaria(), style);//12
			crearCeldas(row, columnas++, inmueble.getIdprocesojuridico().getAgua(), style);//13
			crearCeldas(row, columnas++, inmueble.getIdprocesojuridico().getPredial(), style);//14
			crearCeldas(row, columnas++, inmueble.getIdprocesojuridico().getEstatus(), style);//15
			crearCeldas(row, columnas++, inmueble.getIdunidades().getDptos(), style);//16
			crearCeldas(row, columnas++, inmueble.getIdunidades().getLocales(), style);//17
			crearCeldas(row, columnas++, inmueble.getIdunidades().getOficinas(), style);//18
			crearCeldas(row, columnas++, inmueble.getIdunidades().getCajones(), style);//19
			crearCeldas(row, columnas++, inmueble.getIdunidades().getBodegas(), style);//20
			crearCeldas(row, columnas++, inmueble.getIdunidades().getDacion(), style);//21
			crearCeldas(row, columnas++, inmueble.getIdunidades().getUnidades(), style);//22
			crearCeldas(row, columnas++, inmueble.getIdunidades().getComentarios(), style);//23
			crearCeldas(row, columnas++, inmueble.getArchivo(), style);//24
			contadorFilas++;
		}
	}
	
	
	public void excelExportar(HttpServletResponse response) throws IOException {
		escribirEncabezado();
		DatosCeldas();
		
		ServletOutputStream outputstream = response.getOutputStream();
		workbook.write(outputstream);
		workbook.close();
		outputstream.close();
	}
	

}
