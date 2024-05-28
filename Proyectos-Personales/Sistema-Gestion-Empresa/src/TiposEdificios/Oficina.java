package TiposEdificios;

public class Oficina extends Edificio {

    @Override
    public String definirFuncionalidad() {
        setTipoEdificioFuncionalidad("Se etiqueta el producto");
        return getTipoEdificioFuncionalidad();
    }
}
