package umg.ejercicio.DataBase.Service;
import umg.ejercicio.DataBase.Dao.UsuarioDao;
import umg.ejercicio.DataBase.Model.User;
import umg.ejercicio.DataBase.db.DatabaseConnection;
import umg.ejercicio.DataBase.db.TransactionManager;
import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private UsuarioDao userDao = new UsuarioDao();


    public boolean eliminarUser(String idtext) throws SQLException {
        return userDao.deleteUserById(idtext);
    }

    public boolean checkEmailDuplicated(String email) {
        return userDao.isEmailDuplicated(email);
    }

    public void createUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            TransactionManager tm = new TransactionManager(connection);
            tm.beginTransaction();
            try {
                userDao.insertUser(user);
                tm.commit();
            } catch (SQLException e) {
                tm.rollback();
                throw e;
            }
        }
    }
    public boolean actualizarUser(User user) throws SQLException {
        return userDao.updateUser(user);
    }
    public User getUserByCarne(String Carne) throws SQLException {
        return userDao.getUserByCarne(Carne);
    }
}
