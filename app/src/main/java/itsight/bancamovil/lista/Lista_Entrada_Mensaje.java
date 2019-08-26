package itsight.bancamovil.lista;

public class Lista_Entrada_Mensaje {

    private String _Fecha;
    private String _Descripcion;


    public Lista_Entrada_Mensaje(String Fecha, String Descripcion) {
        _Fecha = Fecha;
        _Descripcion = Descripcion;

    }

    public String getFecha() {
        return _Fecha;
    }

    public void setFecha(String Fecha) {
        this._Fecha = Fecha;
    }

    public String getDescripcion() {
        return _Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this._Descripcion = Descripcion;
    }

}
