package sk.indra.avitech.example.commands;

import sk.indra.avitech.example.db.Database;
import sk.indra.avitech.example.model.User;

import java.sql.SQLException;
import java.util.List;

public class PrintAll implements Command {
    @Override
    public void execute(Database db) throws SQLException {
        System.out.println("PRINT ALL USERS: ");
        List<User> allUsers = db.getAllUsers();
        allUsers.stream().forEach(System.out::println);
    }
}

