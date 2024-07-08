package sk.indra.avitech.example.process;

import sk.indra.avitech.example.commands.Command;

import java.util.concurrent.BlockingQueue;

public class Producer {
    private final BlockingQueue<Command> queue;

    public Producer(BlockingQueue<Command> queue) {
        this.queue = queue;
    }

    public void produce(Command command) throws InterruptedException {
        queue.put(command);
    }
}
