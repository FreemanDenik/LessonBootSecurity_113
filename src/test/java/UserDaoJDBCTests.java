import com.denik.vy.dao.UserDao;
import com.denik.vy.dao.UserDaoJDBC;
import com.denik.vy.models.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserDaoJDBCTests {
    UserDao jdbc = new UserDaoJDBC();
    @Test
    public void JDBCTest(){
        try {
            jdbc.dropTable();
            jdbc.createTable();
            jdbc.addUser(new User("Join1", "JoinLast1", (byte)10));
            jdbc.addUser(new User("Join2", "JoinLast2", (byte)20));
            jdbc.addUser(new User("Join3", "JoinLast3", (byte)30));
            List<User> users = jdbc.getAllUsers().stream().toList();
            assertTrue(users.get(0).getName().equals("Join1"));
            jdbc.removeUser(1);
            users = jdbc.getAllUsers().stream().toList();
            assertFalse(users.get(0).getName().equals("Join1"));
            assertTrue(users.size() == 2);
            jdbc.cleanTable();
            users = jdbc.getAllUsers().stream().toList();
            assertTrue(users.size() == 0);
            jdbc.dropTable();
        }catch (SQLException e){
            Assert.fail("Ошибка: " + e.getMessage());
        }
    }
}
