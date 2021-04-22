package net.unit8.drill.solid.domain;

public record EmailAddress(String user, String domain) {
    public String toString() {
        return user + "@" + domain;
    }
}
