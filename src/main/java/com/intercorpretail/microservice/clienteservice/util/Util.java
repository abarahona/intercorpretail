package com.intercorpretail.microservice.clienteservice.util;

import com.intercorpretail.microservice.clienteservice.model.Cliente;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Util {
    public static double[] obtenerListaEdad(List<Cliente> listaClientes) {

        double[] listaEdades = new double[listaClientes.size()];
        int i = 0;
        for (Cliente cliente : listaClientes) {
            double val = Double.valueOf(cliente.getEdad());
            listaEdades[i++] = val;
        }

        System.out.println(listaEdades.length);

        return listaEdades;
    }

    public static double calcularPromedio(double numArray[]) {
        double suma = 0.0;
        double promedio = 0.0;

        for (double num : numArray) {
            suma += num;
        }
        promedio = suma / numArray.length;

        return promedio;
    }

    public static double calcularDesviacionEstandar(double numArray[]) {
        double desviacionEstandar = 0.0;
        double promedio = Util.calcularPromedio(numArray);

        for (double num : numArray) {
            desviacionEstandar += Math.pow(num - promedio, 2);
        }
        return Math.sqrt(desviacionEstandar/numArray.length);
    }

    public static Date calcularFechaDeceso(Cliente cliente) {
        Double aniosRestante = (Constantes.ESPERANZA_VIDA_PERU - cliente.getEdad());
        System.out.println("anios restantes" + aniosRestante);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, aniosRestante.intValue());
        return calendar.getTime();
    }
}
