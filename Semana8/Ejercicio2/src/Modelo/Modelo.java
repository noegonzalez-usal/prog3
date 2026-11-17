package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Modelo{

    private Path ruta=Paths.get("data","Facturas.tsv");
    private ArrayList<Factura> facturas=new ArrayList<>();

    public void importarFacturas(){
        String delimitador="\t";
        try{
            List<String> lineas = Files.readAllLines(ruta);
            for(String linea:lineas){
                String[] datos=linea.split(delimitador);
                facturas.add(new Factura(
                    datos[0],
                    datos[1],
                    datos[2],
                    datos[3],
                    datos[4],
                    datos[5],
                    datos[6],
                    datos[7]
                ));
            } 
        }catch(IOException e){
            System.err.printf("Error al importar los datos");
        }
    }

    public ArrayList<Factura> getFacturasMin(double min){
        ArrayList<Factura> lista = new ArrayList<>();
        for(Factura factura:facturas){
            if(factura.getValorMinimo()>min){
                lista.add(factura);
            }
        }
        return lista;
    }

    public ArrayList<Factura> getFacturas(){
        ArrayList<Factura> lista = new ArrayList<>();
        for(Factura factura:facturas){
            lista.add(factura);
        }
        return lista;
    }

    public int[] getLongitudes(){
        int[] longitudes=new int[]{0,0,0,0};
        for(Factura factura:facturas){
            int[] longitud=factura.getLongitudes();
            for(int i=0;i<4;i++){
                longitudes[i]=Math.max(longitudes[i],longitud[i]);
            }
        }
        return longitudes;
    }

    public void exportarCsv() throws IOException{
        Path rutahtml = Paths.get("output","facturas.csv");
        String delimitador=",";
        List<String> contenido=new ArrayList<>();
        for(Factura factura:facturas){
            String linea=factura.getConcepto()+delimitador+
                String.format("%.2f",factura.getDescuento())+delimitador+
                factura.getFecha()+delimitador+
                String.format("%.2f",factura.getImporte())+delimitador+
                factura.getNif()+delimitador+
                factura.getNombre()+delimitador+
                factura.getDireccion()+delimitador+
                String.format("%.2f",factura.getIva());
            contenido.add(linea);
        }
        Files.createDirectories(rutahtml.getParent());
        Files.write(rutahtml, contenido, StandardCharsets.UTF_8);    
        }

    public void exportarHtml() throws IOException{
        Path rutahtml=Paths.get("output","Facturas.html");
        List<String> contenido=new ArrayList<>();
        contenido.addAll(List.of(
            "<!DOCTYPE html>",
            "<html lang=\"es\">",
            "<head>",
            "\t<meta charset=\"UTF-8\">",
            "\t<title>Listado de facturas</title>",
            "</head>",
            "<body>",
            "\t<h1>Listado de facturas</h1>",
            "\t<table border=\"1\">",
            "\t\t<thead>",
            "\t\t\t<tr>",
            "\t\t\t\t<th>Concepto</th>",
            "\t\t\t\t<th>Descuento</th>",
            "\t\t\t\t<th>Fecha</th>",
            "\t\t\t\t<th>Importe</th>",
            "\t\t\t\t<th>NIF</th>",
            "\t\t\t\t<th>Nombre</th>",
            "\t\t\t\t<th>Dirección</th>",
            "\t\t\t\t<th>IVA</th>",
            "\t\t\t</tr>",
            "\t\t</thead>",
            "\t\t<tbody>"
        ));
        for (Factura factura : facturas) {
            String linea = "\t\t\t<tr>\n"+
                "\t\t\t\t<td>"+factura.getConcepto()+"</td>\n"+
                "\t\t\t\t<td>"+String.format("%.2f", factura.getDescuento())+"</td>\n"+
                "\t\t\t\t<td>"+factura.getFecha()+"</td>\n"+
                "\t\t\t\t<td>"+String.format("%.2f", factura.getImporte())+"</td>\n"+
                "\t\t\t\t<td>"+factura.getNif()+"</td>\n"+
                "\t\t\t\t<td>"+factura.getNombre()+"</td>\n"+
                "\t\t\t\t<td>"+factura.getDireccion()+"</td>\n"+
                "\t\t\t\t<td>"+String.format("%.2f", factura.getIva())+"</td>\n"+
                "\t\t\t</tr>";
            contenido.add(linea);
        }
        contenido.addAll(List.of(
            "\t\t</tbody>",
            "\t</table>",
            "</body>",
            "</html>"
        ));
        Files.createDirectories(rutahtml.getParent());
        Files.write(rutahtml, contenido, StandardCharsets.UTF_8);
    }
}