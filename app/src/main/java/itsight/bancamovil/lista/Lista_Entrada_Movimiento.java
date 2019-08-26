package itsight.bancamovil.lista;

public class Lista_Entrada_Movimiento {

    private String _Fecha;
    private String _Descripcion;
    private double _Monto;

    public Lista_Entrada_Movimiento(String Fecha, String Descripcion, double Monto) {
        _Fecha = Fecha;
        _Descripcion = Descripcion;
        _Monto = Monto;
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

    public double getMonto() {
        return _Monto;
    }

    public void setMonto(double Monto) {
        this._Monto = Monto;
    }
}
