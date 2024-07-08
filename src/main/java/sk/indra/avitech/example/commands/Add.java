package sk.indra.avitech.example.commands;

import sk.indra.avitech.example.db.Database;
import sk.indra.avitech.example.model.User;

import java.sql.SQLException;

public class Add implements Command {
    private final User user;

    public Add(User user) {
        this.user = user;
    }

    @Override
    public void execute(Database db) throws SQLException {
        System.out.println("Adding user: " + user.getUserName());
        db.addUser(user);
    }
}