package sk.indra.avitech.example;

import sk.indra.avitech.example.commands.Add;
import sk.indra.avitech.example.commands.Command;
import sk.indra.avitech.example.commands.DeleteAll;
import sk.indra.avitech.example.commands.PrintAll;
import sk.indra.avitech.example.db.Database;
import sk.indra.avitech.example.model.User;
import sk.indra.avitech.example.process.Consumer;
import sk.indra.avitech.example.process.Producer;

import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        BlockingQueue<Command> queue = new ArrayBlockingQueue<>(10);
        Database db = new Database();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue, db);

        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        producer.produce(new Add(new User(1, "a1", "Robert")));
        producer.produce(new Add(new User(2, "a2", "Martin")));
        producer.produce(new PrintAll());
        producer.produce(new DeleteAll());
        producer.produce(new PrintAll());

        // sleep to consume all commands
        Thread.sleep(2000);

        consumerThread.interrupt();
    }
}