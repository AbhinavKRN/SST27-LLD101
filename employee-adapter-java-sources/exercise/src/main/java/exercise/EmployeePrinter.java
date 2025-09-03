package exercise;

import java.util.Collection;

public final class EmployeePrinter {
  private EmployeePrinter() {}
  public static void print(Collection<Employee> employees) {
    for (Employee e : employees) {
      System.out.println("ID=" + emptyToDash(e.getId())
        + ", First=" + emptyToDash(e.getFirstName())
        + ", Last=" + emptyToDash(e.getLastName())
        + ", Email=" + emptyToDash(e.getEmail()));
    }
  }

  private static String emptyToDash(String s) {
    return (s == null || s.isEmpty()) ? "-" : s;
  }
}
