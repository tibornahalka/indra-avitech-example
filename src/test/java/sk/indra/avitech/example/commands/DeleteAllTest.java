package sk.indra.avitech.example.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.indra.avitech.example.db.Database;
import sk.indra.avitech.example.model.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DeleteAllTest {

    private Database db;

    @BeforeEach
    public void setUp() throws SQLException {
        db = new Database();
    }

    @Test
    public void testDeleteAllUsers() throws SQLException {
        db.addUser(new User(1, "a1", "Robert"));
        db.addUser(new User(2, "a2", "Martin"));

        DeleteAll deleteAllCommand = new DeleteAll();
        deleteAllCommand.execute(db);

        assertEquals(0, db.getAllUsers().size());
    }
}