package TiposEdificios;

public class Fabrica extends Edificio {

    @Override
    public String definirFuncionalidad() {
        setTipoEdificioFuncionalidad("Se crea el producto");
        return getTipoEdificioFuncionalidad();
    }
}
