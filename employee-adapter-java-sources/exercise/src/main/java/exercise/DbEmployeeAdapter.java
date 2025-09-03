package exercise;

import java.util.Objects;

public final class DbEmployeeAdapter implements Employee {
  private final EmployeeDB db;

  public DbEmployeeAdapter(EmployeeDB db) {
    this.db = Objects.requireNonNull(db);
  }

  public String getId() { return String.valueOf(db.getId()); }
  public String getFirstName() { return db.getFirstName(); }
  public String getLastName() { return db.getSurname(); }
  public String getEmail() { return db.getEmailAddress(); }
}


