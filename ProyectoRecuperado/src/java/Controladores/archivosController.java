/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Facade.EventoFacade;
import Facade.ProductoMenajeFacade;
import Facade.ProveedorFacade;
import Facade.RolFacade;
import Facade.StockFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

@ManagedBean(name = "archivosExcel")
public class archivosController {
    
    @EJB
    ProductoMenajeFacade productoMenajeFacade;
    @EJB
    ProveedorFacade proveedorFacade;
    @EJB
    RolFacade rolFacade;
    @EJB
    EventoFacade eventoFacade;
    @EJB
    StockFacade stockFacade;
    @Inject
    Controladores.mensajeController mensajesController;
    
    private Part file;
    private String nombre;
    private String pathReal;
    
    private Part file1;
    private String nombre1;
    private String pathReal1;
    
    private Part file2;
    private String nombre2;
    private String pathReal2;
    
    private Part file3;
    private String nombre3;
    private String pathReal3;
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathReal() {
        return pathReal;
    }

    public void setPathReal(String pathReal) {
        this.pathReal = pathReal;
    }
    
    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getPathReal1() {
        return pathReal1;
    }

    public void setPathReal1(String pathReal1) {
        this.pathReal1 = pathReal1;
    }
    
    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getPathReal2() {
        return pathReal2;
    }

    public void setPathReal2(String pathReal2) {
        this.pathReal2 = pathReal2;
    }
    
    public Part getFile3() {
        return file3;
    }

    public void setFile3(Part file3) {
        this.file3 = file;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getPathReal3() {
        return pathReal3;
    }

    public void setPathReal3(String pathReal3) {
        this.pathReal3 = pathReal3;
    }

    public String upload() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        try {
            this.nombre = file.getSubmittedFileName();
            pathReal = "/ProyectoRecuperado/Archivos/" + nombre;
            path = path + this.nombre;
            InputStream in = file.getInputStream();

            byte[] data = new byte[in.available()];
            in.read(data);
            File archivo = new File(path);
            FileOutputStream out = new FileOutputStream(archivo);
            out.write(data);
            in.close();
            out.close();       
            path = path.replace("\\", "\\\\");
            productoMenajeFacade.CargaDatos(path, "producto_menaje");
            mensajesController.setMensaje("Mensaje('Exitoso','Has subido archivos nuevos','success')");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        try {
            this.nombre1 = file1.getSubmittedFileName();
            pathReal1 = "/ProyectoRecuperado/Archivos/" + nombre1;
            String path1 = path + this.nombre1;
            InputStream in1 = file1.getInputStream();

            byte[] data = new byte[in1.available()];
            in1.read(data);
            File archivo1 = new File(path1);
            FileOutputStream out1 = new FileOutputStream(archivo1);
            out1.write(data);
            in1.close();
            out1.close();       
            path = path1.replace("\\", "\\\\");
            proveedorFacade.CargaDatos(path, "proveedor");
            mensajesController.setMensaje("Mensaje('Exitoso','Has subido archivos nuevos','success')");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            this.nombre2 = file2.getSubmittedFileName();
            pathReal2 = "/ProyectoRecuperado/Archivos/" + nombre2;
            String path2 = path + this.nombre2;
            InputStream in2 = file2.getInputStream();

            byte[] data = new byte[in2.available()];
            in2.read(data);
            File archivo2 = new File(path2);
            FileOutputStream out2 = new FileOutputStream(archivo2);
            out2.write(data);
            in2.close();
            out2.close();       
            path = path2.replace("\\", "\\\\");
            eventoFacade.CargaDatos(path, "evento");
            mensajesController.setMensaje("Mensaje('Exitoso','Has subido archivos nuevos','success')");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            this.nombre3 = file3.getSubmittedFileName();
            pathReal3 = "/ProyectoRecuperado/Archivos/" + nombre3;
            String path3 = path + this.nombre3;
            InputStream in3 = file3.getInputStream();

            byte[] data = new byte[in3.available()];
            in3.read(data);
            File archivo3 = new File(path3);
            FileOutputStream out3 = new FileOutputStream(archivo3);
            out3.write(data);
            in3.close();
            out3.close();       
            path = path3.replace("\\", "\\\\");
            stockFacade.CargaDatos(path, "stock");
            mensajesController.setMensaje("Mensaje('Exitoso','Has subido archivos nuevos','success')");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "archivosV";
    }

    

}

   
