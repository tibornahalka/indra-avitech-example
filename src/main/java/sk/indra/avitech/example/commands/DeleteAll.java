package sk.indra.avitech.example.commands;

import sk.indra.avitech.example.db.Database;

import java.sql.SQLException;

public class DeleteAll implements Command {
    @Override
    public void execute(Database db) throws SQLException {
        System.out.println("Delete all users.");
        db.deleteAllUsers();
    }
}
