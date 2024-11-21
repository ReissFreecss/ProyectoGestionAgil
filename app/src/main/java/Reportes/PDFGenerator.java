package Reportes;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileOutputStream;

public class PDFGenerator {
    public static void generarReporte(ReporteData data, String plantillaPath, String outputPath) throws Exception {
         // Abre la plantilla PDF y configura la salida
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(plantillaPath), new PdfWriter(new FileOutputStream(outputPath)));
        Document document = new Document(pdfDoc);

        // Inserta los datos en el PDF
        // Ejemplo: Añade párrafos con los datos del reporte
        document.add(new Paragraph("Nombre completo: " + data.getNombreCompleto()));
        document.add(new Paragraph("Edad: " + data.getEdad()));
        document.add(new Paragraph("Fecha de consulta: " + data.getFechaConsulta()));
        document.add(new Paragraph("Motivo de consulta: " + data.getMotivoConsulta()));
        document.add(new Paragraph("Peso: " + data.getPeso() + " kg"));
        document.add(new Paragraph("IMC: " + data.getImc()));
        document.add(new Paragraph("Masa muscular: " + data.getMasaMuscular() + " kg"));
        document.add(new Paragraph("Porcentaje de grasa corporal: " + data.getPorcentajeGrasaCorporal() + " %"));
        document.add(new Paragraph("Circunferencia de cintura: " + data.getCircunferenciaCintura() + " cm"));
        document.add(new Paragraph("Enfermedades diagnosticadas: " + data.getEnfermedadDiagnosticada()));
        document.add(new Paragraph("Alergias o intolerancias alimentarias: " + data.getAlergiaIntoleranciaAlimentos()));
        document.add(new Paragraph("Comida: " + data.getComida()));
        document.add(new Paragraph("Horario: " + data.getHorario()));
        document.add(new Paragraph("Porciones: " + data.getPorciones()));
        document.add(new Paragraph("Ingredientes: " + data.getIngredientes()));
        document.add(new Paragraph("Suplemento: " + data.getSuplemento()));
        document.add(new Paragraph("Dosis del suplemento: " + data.getDosisSuplemento()));

        // Cierra el documento
        document.close();
    }
}
