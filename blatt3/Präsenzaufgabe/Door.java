package Präsenzaufgabe;

 enum Status {
    OPEN,
    CLOSED,
    LOCKED
}
public class Door {
    private String name;
    private Status status;

    public Door(String name) {
        this.name = name;
        this.status = Status.CLOSED;
    }

    public void open() {
        if (status == Status.CLOSED) {
            status = Status.OPEN;
            System.out.println(name + " is now open.");
        } else if (status == Status.OPEN) {
            System.out.println(name + " is already open.");
        } else { // Status.LOCKED
            System.out.println(name + " is locked and cannot be opened.");
        }
    }

    public void close() {
        if (status == Status.OPEN) {
            status = Status.CLOSED;
            System.out.println(name + " is now closed.");
        } else if (status == Status.CLOSED) {
            System.out.println(name + " is already closed.");
        } else { // Status.LOCKED
            System.out.println(name + " is locked and cannot be closed.");
        }
    }

    public void lock() {
        if (status == Status.CLOSED) {
            status = Status.LOCKED;
            System.out.println(name + " is now locked.");
        } else {
            System.out.println(name + " cannot be locked because it is not closed.");
        }
    }

    public void unlock() {
        if (status == Status.LOCKED) {
            status = Status.CLOSED;
            System.out.println(name + " is now unlocked.");
        } else {
            System.out.println(name + " cannot be unlocked because it is not locked.");
        }
    }
}

