package TiposEdificios;

public abstract class Edificio {
    private float anchura;
    private float altura;
    private float profundidad;
    private String material;
    private String tipoEdificioFuncionalidad;
    private float precioMercado;
    private String color;

    public float getAnchura() {
        return anchura;
    }

    public void setAnchura(float anchura) {
        this.anchura = anchura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(float profundidad) {
        this.profundidad = profundidad;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipoEdificioFuncionalidad() {
        return tipoEdificioFuncionalidad;
    }

    public void setTipoEdificioFuncionalidad(String tipoEdificioFuncionalidad) {
        this.tipoEdificioFuncionalidad = tipoEdificioFuncionalidad;
    }

    public float getPrecioMercado() {
        return precioMercado;
    }

    public void setPrecioMercado(float precioMercado) {
        this.precioMercado = precioMercado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float calcularCostePintura(String color, float precioMetro) {
        float coste = precioMetro * anchura * altura * profundidad;
        return coste > 0 ? coste : -1;
    }

    public float calcularCostePintura(String color, float precioMetro, String lado) {
        float coste = 0;
        switch (lado) {
            case "ladoanchura":
                coste = precioMetro * anchura * altura;
                break;
            case "ladoprofundidad":
                coste = precioMetro * altura * profundidad;
                break;
            default:
                return -1;
        }
        return coste > 0 ? coste : -1;
    }

    public abstract String definirFuncionalidad();

    public void imprimirDetalles() {
        System.out.println("Anchura: " + anchura + ", Altura: " + altura + ", Profundidad: " + profundidad +
                ", Material: " + material + ", Funcionalidad: " + tipoEdificioFuncionalidad +
                ", Precio de mercado: " + precioMercado + ", Color: " + color);
    }
}
