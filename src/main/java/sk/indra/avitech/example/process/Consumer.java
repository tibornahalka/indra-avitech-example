package sk.indra.avitech.example.process;

import sk.indra.avitech.example.commands.Command;
import sk.indra.avitech.example.db.Database;

import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Command> queue;
    private final Database db;

    public Consumer(BlockingQueue<Command> queue, Database db) {
        this.queue = queue;
        this.db = db;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Command command = queue.take();
                command.execute(db);
            }
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}