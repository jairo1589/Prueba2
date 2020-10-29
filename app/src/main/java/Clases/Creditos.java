package Clases;

public class Creditos {

    private int Credito_hipotecario;
    private int Credito_automotriz;
    private int Cuotas_hiopotecario;
    private int Cuotas_automotriz;

    public Creditos()
    {
        Credito_hipotecario = 1000000;
        Credito_automotriz = 500000;
        Cuotas_hiopotecario = 12;
        Cuotas_automotriz = 8;

    }
    public int getCredito_hipotecario()
    {
        return Credito_hipotecario;
    }
    public int getCredito_automotriz()
    {
        return Credito_automotriz;
    }
    public int getCuotas_hiopotecario()
    {
        return Cuotas_hiopotecario;
    }
    public int getCuotas_automotriz()
    {
        return Cuotas_automotriz;
    }
}
