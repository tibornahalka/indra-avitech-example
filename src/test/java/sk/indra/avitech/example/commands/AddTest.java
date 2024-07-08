package sk.indra.avitech.example.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.indra.avitech.example.db.Database;
import sk.indra.avitech.example.model.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

    private Database db;

    @BeforeEach
    public void setUp() throws SQLException {
        db = new Database();
    }

    @Test
    void execute() throws SQLException {
        User user = new User(1, "a1", "Robert");
        Add add = new Add(user);
        add.execute(db);
        assertEquals(1, db.getAllUsers().size());
        assertEquals("Robert", db.getAllUsers().get(0).getUserName());
    }
}