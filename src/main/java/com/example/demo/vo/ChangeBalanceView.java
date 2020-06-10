package com.example.demo.vo
    ;

/**
 * 存取钱request封装
 *
 * @author Liu YaXue
 * @since 1.0.0
 */
public class ChangeBalanceView {

  /**
   * 银行卡密码
   */
  private String bankCardPassword;

  /**
   * 卡号
   */
  private String bankcardId;

  /**
   * 需要
   */
  private Double money;

  public ChangeBalanceView() {
  }

  public void setBankcardId(String bankcardId) {
    this.bankcardId = bankcardId;
  }

  public void setMoney(Double money) {
    this.money = money;
  }

  public void setBankCardPassword(String bankCardPassword) {
    this.bankCardPassword = bankCardPassword;
  }

  public String getBankcardId() {
    return bankcardId;
  }

  public Double getMoney() {
    return money;
  }

  public String getBankCardPassword() {
    return bankCardPassword;
  }
}
