package exercise;

import java.util.Objects;

public final class LdapEmployeeAdapter implements Employee {
  private final EmployeeLDAP ldap;

  public LdapEmployeeAdapter(EmployeeLDAP ldap) {
    this.ldap = Objects.requireNonNull(ldap);
  }

  public String getId() { return nullToEmpty(ldap.get("uid")); }
  public String getFirstName() { return nullToEmpty(ldap.get("givenName")); }
  public String getLastName() { return nullToEmpty(ldap.get("sn")); }
  public String getEmail() { return nullToEmpty(ldap.get("mail")); }

  private static String nullToEmpty(String s) { return s == null ? "" : s; }
}


