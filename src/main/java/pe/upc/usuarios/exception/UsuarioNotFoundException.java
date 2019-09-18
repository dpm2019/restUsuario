package pe.upc.usuarios.exception;

public class UsuarioNotFoundException extends Exception{

    private Long usuarioId;

    public UsuarioNotFoundException(long usuarioId){
        super(String.format("Usuario no se ha encontrado con id: '%s'", usuarioId));
    }

}
