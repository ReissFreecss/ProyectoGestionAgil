package Reportes;

import Entidades.EntidadDatosInterpretacion;
import Entidades.EntidadDietas;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.util.List;

public class PDFGenerator {

    public static void generarReporte(ReporteData data, List<EntidadDietas> dietas, List<EntidadDatosInterpretacion> datosInterpretacion, String plantillaPath, String outputPath) throws Exception {
        // Abre la plantilla PDF y configura la salida
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(plantillaPath), new PdfWriter(outputPath));

        // Inserta los datos generales del paciente
        insertTextInPosition(pdfDoc, data.getNombreCompleto(), 275, 635, 4);
        insertTextInPosition(pdfDoc, "" + data.getFechaConsulta(), 450, 660, 4);
        insertTextInPosition(pdfDoc, "" + data.getEdad(), 255, 610, 4);
        insertTextInPosition(pdfDoc, "" + data.getEstatura(), 255, 590, 4);
        insertTextInPosition(pdfDoc, "" + data.getDiagnostico(), 300, 570, 4);
        insertTextInPosition(pdfDoc, "" + data.getMotivoConsulta(), 360, 550, 4);
        insertTextInPosition(pdfDoc, "" + data.getAlergiaIntoleranciaAlimentos(), 270, 530, 4);

        // Procesa las dietas seleccionadas
        for (EntidadDietas dieta : dietas) {
            switch (dieta.getComida()) {
                case "Desayuno":
                    insertTextInPosition(pdfDoc, dieta.getHorario(), 90, 620, 5);
                    insertTextInPosition(pdfDoc, "Preparacion:\n " + dieta.getIngredientes(), 200, 580, 5);
                    break;

                case "Comida":
                    insertTextInPosition(pdfDoc, "" + dieta.getHorario(), 90, 515, 5);
                    insertTextInPosition(pdfDoc, "Preparacion:\n " + dieta.getIngredientes(), 200, 470, 5);
                    break;
                case "Cena":
                    insertTextInPosition(pdfDoc, "" + dieta.getHorario(), 90, 410, 5);
                    insertTextInPosition(pdfDoc, "Preparacion:\n " + dieta.getIngredientes(), 200, 370, 5);
                    break;
                case "Colacion 1":
                    insertTextInPosition(pdfDoc, "" + dieta.getHorario(), 90, 300, 5);
                    insertTextInPosition(pdfDoc, "Preparacion:\n " + dieta.getIngredientes(), 200, 260, 5);
                    break;
                case "Colacion 2":
                    insertTextInPosition(pdfDoc, "" + dieta.getHorario(), 90, 190, 5);
                    insertTextInPosition(pdfDoc, "Preparacion:\n " + dieta.getIngredientes(), 200, 150, 5);
                    break;
            }
        }

        // Coordenadas iniciales para la tabla de seguimiento
        final int startX = 205; // Posición X inicial de la primera columna (mes 1)
        final int startY = 405; // Posición Y del título (mes)
        final int deltaX = 62;  // Espacio entre columnas
        final int rowSpacing = 32; // Espacio entre filas (Peso, IMC, etc.)

// Bandera para identificar si es el primer registro
        boolean isFirstEntry = true;

// Procesa los datos de interpretación
        int columnIndex = 0; // Índice de columna actual (0 a 6)
        for (EntidadDatosInterpretacion interpretacion : datosInterpretacion) {
            if (isFirstEntry) {
                // Datos del paciente
                insertTextInPosition(pdfDoc, interpretacion.getPeso() + " kg", 340, 610, 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getImc(), 340, 590, 4);
                // Inserta datos fijos en la columna de inicio (mes 0)
                insertTextInPosition(pdfDoc, interpretacion.getPeso() + " kg", 150, startY - rowSpacing, 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getImc(), 150, startY - (2 * rowSpacing), 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getCintura()+ "cm", 150, startY - (3 * rowSpacing), 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getMasaMuscular() + "kg", 150, startY - (4 * rowSpacing), 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getPorcentajeGrasaCorporal(), 150, startY - (5 * rowSpacing), 4);

                // Cambiar la bandera después del primer registro
                isFirstEntry = false;
            } else {
                // Calcula la posición X para las columnas posteriores
                int currentX = startX + (columnIndex * deltaX);

                // Inserta los datos en la columna correspondiente
                insertTextInPosition(pdfDoc, (columnIndex + 1) + "° mes", currentX, startY, 4);
                insertTextInPosition(pdfDoc, interpretacion.getPeso() + " kg", currentX, startY - rowSpacing, 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getImc(), currentX, startY - (2 * rowSpacing), 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getCintura()+ "cm", currentX, startY - (3 * rowSpacing), 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getMasaMuscular() + "kg", currentX, startY - (4 * rowSpacing), 4);
                insertTextInPosition(pdfDoc, "" + interpretacion.getPorcentajeGrasaCorporal(), currentX, startY - (5 * rowSpacing), 4);

                // Avanza a la siguiente columna
                columnIndex++;

                // Si llega a la séptima columna, reinicia el índice
                if (columnIndex == 6) {
                    columnIndex = 0;
                }
            }
        }

        // Cierra el documento
        pdfDoc.close();
    }
    // Método auxiliar para insertar texto en posiciones específicas

    private static void insertTextInPosition(PdfDocument pdfDoc, String text, float x, float y, int pageNum) {
        PdfPage page = pdfDoc.getPage(pageNum);
        PdfCanvas pdfCanvas = new PdfCanvas(page);
        Canvas canvas = new Canvas(pdfCanvas, page.getPageSize());
        canvas.showTextAligned(text, x, y, TextAlignment.LEFT);
    }
}
