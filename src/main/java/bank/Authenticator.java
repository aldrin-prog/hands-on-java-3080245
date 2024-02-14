package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {
  public static Customer login(String username, String password) throws LoginException {
    Customer customer = DataSource.getCustomer(username);
    if (customer == null) {
      throw new LoginException("Username not found");
    }
    if (password.equals(customer.getPassword())) {
      customer.setAuthenticated(true);
      return customer;
    }
    throw new LoginException("Wrong password");
  }

  public static void logout(Customer customer) {
    customer.setAuthenticated(false);
  }
}
