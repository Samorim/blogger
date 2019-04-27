
package features.exceptions;

public class DaoExceptions {
    public class DaoException extends Exception {

    public DaoException(final String msg) {
        super(msg);
    }
    
    public DaoException(final Exception e) {
        super("Não foi possível acessar a Base de Dados", e);
    }

    public DaoException(final String msg, final Exception e) {
        super(msg, e);
    }

}
}
