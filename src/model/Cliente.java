

public class Cliente {
    private String documento;
    private String nombre;

    public Cliente(String documento,String nombre){
        this.documento=documento;
        this.nombre=nombre;
    }

    // Getters y setters
    public String getDocumento(){return documento;}
    public void setDocumento(String documento){this.documento=documento;}
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    @Override
    public String toString(){return nombre+" ("+documento+")";}
}
