package exercise;

import java.util.Collection;

public final class EmployeePrinter {
  private EmployeePrinter() {}
  public static void print(Collection<Employee> employees) {
    for (Employee e : employees) {
      System.out.println(
        String.format("ID=%s, First=%s, Last=%s, Email=%s",
          emptyToDash(e.getId()), emptyToDash(e.getFirstName()), emptyToDash(e.getLastName()), emptyToDash(e.getEmail()))
      );
    }
  }

  private static String emptyToDash(String s) {
    return (s == null || s.isEmpty()) ? "-" : s;
  }
}
