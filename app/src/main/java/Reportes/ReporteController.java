package Reportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ReporteController {
    /*private ReporteView vista;
    private ReporteService reporteService;

    public ReporteController(ReporteView vista, ReporteService reporteService) {
        this.vista = vista;
        this.reporteService = reporteService;
        
        this.vista.addGenerarReporteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });
    }

    private void generarReporte() {
        String idPaciente = vista.getIdPaciente();
        try {
            // Obtener los datos necesarios
            ReporteData data = ReporteService.obtenerDatosReporte(Integer.parseInt(idPaciente));

            // Generar el PDF
            PDFGenerator.generarReporte(data);

            JOptionPane.showMessageDialog(vista, "Reporte generado exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al generar reporte: " + e.getMessage());
        }
    }*/
}
