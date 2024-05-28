package TiposEdificios;

public class Almacen extends Edificio {

    @Override
    public String definirFuncionalidad() {
        setTipoEdificioFuncionalidad("Se guarda el producto para posteriormente venderlo");
        return getTipoEdificioFuncionalidad();
    }
}
