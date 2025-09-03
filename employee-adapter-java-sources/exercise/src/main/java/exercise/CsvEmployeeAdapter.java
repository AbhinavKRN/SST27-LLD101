package exercise;

import java.util.Objects;

public final class CsvEmployeeAdapter implements Employee {
  private final EmployeeCSV csv;

  public CsvEmployeeAdapter(EmployeeCSV csv) {
    this.csv = Objects.requireNonNull(csv);
  }

  private String[] tokens() {
    return csv.tokens();
  }

  public String getId() {
    String[] t = tokens();
    return t.length > 0 ? t[0] : "";
  }

  public String getFirstName() {
    String[] t = tokens();
    return t.length > 1 ? t[1] : "";
  }

  public String getLastName() {
    String[] t = tokens();
    return t.length > 2 ? t[2] : "";
  }

  public String getEmail() {
    String[] t = tokens();
    return t.length > 3 ? t[3] : "";
  }
}


