package sk.indra.avitech.example.commands;

import sk.indra.avitech.example.db.Database;

import java.sql.SQLException;

public interface Command {
    void execute(Database db) throws SQLException;
}
