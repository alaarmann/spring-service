package ala.task;

public class Task {

    private final long id;
    private final String reference;

    public Task(long id, String reference) {
        this.id = id;
        this.reference = reference;
    }

    public long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }
}