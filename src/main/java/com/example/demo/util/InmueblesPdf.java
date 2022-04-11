package com.example.demo.util;

import java.awt.Color;
import java.util.List;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.example.demo.inmuebles.Inmuebles;

public class InmueblesPdf {
	
	private List<Inmuebles> listInmuebles;

	public InmueblesPdf(List<Inmuebles> listInmuebles) {
		this.listInmuebles = listInmuebles;
	}
	
	private void encabezadoTabla(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(0); 
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Inmueble ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("GRUPO", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("ALCALDIA", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("DOMICILIO", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("CODIGO", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("INICIO", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("TERMINO", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("AVANCE", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("FICHAS FIRMADAS", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("VALORES", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("PENALIZACIONES", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("FIRMA REGIMEN", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("NOTARIA", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("IND AGUA", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("IND PREDIAL", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("DEPARTAMENTOS", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("LOCALES COMERCIALES", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("OFICINAS", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("CAJONES ESTACIONAMIENTOS", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("BODEGAS", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("DACION DE PAGOS", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("UNIDADES", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("COMENTARIOS", font));
        table.addCell(cell);       
        cell.setPhrase(new Phrase("ARCHIVO", font));
        table.addCell(cell);        
    }
	
	
	private void datosTabla(PdfPTable table) {
//        for (Inmuebles inmueble : listInmuebles) {
//            table.addCell(String.valueOf(inmueble.getId()));
//            table.addCell( inmueble.getGrupo());
//            table.addCell( inmueble.getAlcaldia());
//            table.addCell( inmueble.getDomicilio_completo());
//            table.addCell( inmueble.getName());
//            table.addCell( inmueble.getInicio());
//            table.addCell( inmueble.getTermino());
//            table.addCell( inmueble.getAvance());
//            table.addCell( inmueble.getFichas_firmadas());
//            table.addCell( inmueble.getValores());
//            table.addCell( inmueble.getPenalizaciones());
//            table.addCell( inmueble.getFirma_regimen());
//            table.addCell( String.valueOf(inmueble.getNotaria()));
//            table.addCell( inmueble.getInd_agua());
//            table.addCell( inmueble.getInd_predial());
//            table.addCell( inmueble.getEstatus());
//            table.addCell( String.valueOf(inmueble.getDeptos()));
//            table.addCell( String.valueOf(inmueble.getLocales_comerciales()));
//            table.addCell( String.valueOf(inmueble.getOficinas()));
//            table.addCell( String.valueOf(inmueble.getCajones_estac()));
//            table.addCell( String.valueOf(inmueble.getBodegas()));
//            table.addCell( inmueble.getDacion_pago());
//            table.addCell( String.valueOf(inmueble.getUnidades()));
//            table.addCell( inmueble.getComentarios());
//            table.addCell( inmueble.getArchivo());
//        }
    }
	
	
	
	public void exportarPdf(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Lista de Inmuebles", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        encabezadoTabla(table);
        datosTabla(table);
         
        document.add(table);
         
        document.close();
         
    }
	

}
