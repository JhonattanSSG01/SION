package controladores;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.Evento;
import Facade.EventoFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

@ManagedBean(name = "archivosExcel")
public class archivosController {

    private Part file;
    private String nombre;
    private String pathReal;   
    
    private Evento evento;
    
    @EJB
    EventoFacade eventoFacade;
    
    @PostConstruct
    public void init(){
        evento = new Evento();
    }
    
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
    
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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
            
            eventoFacade.create(this.evento);
            evento = new Evento();
                   
            path = path.replace("\\", "\\\\");
            eventoFacade.CargaDatos(path, "evento");
            archivo.delete();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Cargado";
    }

    

}

   
