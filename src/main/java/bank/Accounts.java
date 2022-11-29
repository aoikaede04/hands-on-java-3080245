package bank;

import bank.exceptions.AmountException;

public class Accounts {

  public static final char[] getId = null;
  private int id;
  private String type;
  private double balance;

  public Accounts(int id, String type, double balance) {
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountException {
    if (amount < 1) {
      throw new AmountException("The minimum deposit is 100");
    } else {
      double newBal = balance + amount;
      setBalance(newBal);
      DataSource.updatAccbal(id, newBal);
    }

  }

  public void withdraw(double amount) throws AmountException {
    if (amount < 0) {
      throw new AmountException("The minimum withdraw is 100");
    } else if (amount > getBalance()) {
      throw new AmountException("Insufficent Funds!");
    } else {
      double newBal = balance - amount;
      setBalance(newBal);
      DataSource.updatAccbal(id, newBal);
    }
  }
}
