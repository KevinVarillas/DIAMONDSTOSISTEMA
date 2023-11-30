package CONTROLADOR;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;

import VISTA.RegistrarVenta;

public class VentaPDF {

    private String nombreClienteSeleccionado;
    private String nombreArchivoPDFVenta = "";
    Connection cn;

    //metodo para obtener datos del cliente
    public void DatosCliente() {
        if (RegistrarVenta.tbldatospagar.getRowCount() > 0) {
            nombreClienteSeleccionado = RegistrarVenta.tbldatospagar.getValueAt(0, 0).toString();
        }
    }

    //metodo para generar la factura de venta
    public void generarFacturaPDF() {
        try {

            nombreArchivoPDFVenta = "Venta_" + nombreClienteSeleccionado + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image imgEncabezado = Image.getInstance("src/imagenes/Encabe.png");
            imgEncabezado.scaleAbsolute(396f, 60f);

            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.RED);

            PdfPTable Encabezado = new PdfPTable(1);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar el borde de la tabla
            Encabezado.addCell(imgEncabezado);

            doc.add(Encabezado);

            //CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);//nueva linea
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            //DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(1);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);//quitar bordes
            //tamaño de las celdas
            float[] ColumnaCliente = new float[]{25f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Nombre: ", negrita));
            //quitar bordes 
            cliente1.setBorder(0);

            //agg celda a la tabla
            tablaCliente.addCell(cliente1);

            tablaCliente.addCell(nombreClienteSeleccionado);

            //agregar al documento
            doc.add(tablaCliente);

            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //AGREGAR LOS PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //tamaño de celdas
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Producto: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));
            //quitar bordes
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            //agregar color al encabezadi del producto
            producto1.setBackgroundColor(BaseColor.PINK);
            producto2.setBackgroundColor(BaseColor.PINK);
            producto3.setBackgroundColor(BaseColor.PINK);
            producto4.setBackgroundColor(BaseColor.PINK);
            //agg celda a la tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);

            for (int i = 0; i < RegistrarVenta.tbldatospagar.getRowCount(); i++) {
                String producto = RegistrarVenta.tbldatospagar.getValueAt(i, 1).toString();
                String cantidad = RegistrarVenta.tbldatospagar.getValueAt(i, 2).toString();
                String precio = RegistrarVenta.tbldatospagar.getValueAt(i, 3).toString();
                String total = RegistrarVenta.tbldatospagar.getValueAt(i, 4).toString();

                tablaProducto.addCell(producto);
                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }

            //agregar al documento
            doc.add(tablaProducto);

            //Total pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);

            info.add("Total a pagar: " + RegistrarVenta.txttotal.getText());

            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por su compra!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            //cerrar el documento y el archivo
            doc.close();
            archivo.close();

            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException e) {
            System.out.println("Error al crear el documento PDF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al trabajar con el archivo: " + e.getMessage());
        }

    }
}
