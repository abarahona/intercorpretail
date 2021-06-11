package com.intercorpretail.microservice.clienteservice.model;

public class KpiClientes {
    private Double promedioEdad;
    private Double desviacionEstandar;

    public KpiClientes() {
        super();
    }

    public KpiClientes(Double promedioEdad, Double desviacionEstandar) {
        super();
        this.promedioEdad = promedioEdad;
        this.desviacionEstandar = desviacionEstandar;
    }

    public Double getPromedioEdad() {
        return promedioEdad;
    }

    public void setPromedioEdad(Double promedioEdad) {
        this.promedioEdad = promedioEdad;
    }

    public Double getDesviacionEstandar() {
        return desviacionEstandar;
    }

    public void setDesviacionEstandar(Double desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
    }

    @Override
    public String toString() {
        return "KpiClientes [promedioEdad = " + promedioEdad + ", desviacionEstandar = " + desviacionEstandar + "]";
    }
}
