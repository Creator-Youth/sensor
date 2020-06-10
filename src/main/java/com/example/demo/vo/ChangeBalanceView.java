package com.example.demo.vo
    ;

/**
 * @author Liu YaXue
 * @since 1.0.0
 */
public class ChangeBalanceView {

  /**
   * 卡号
   */
  private String bankCard_id;

  /**
   * 需要
   */
  private Double money;

  public ChangeBalanceView() {
  }

  public ChangeBalanceView setBankCard_id(String bankCard_id) {
    this.bankCard_id = bankCard_id;
    return this;
  }

  public ChangeBalanceView setMoney(Double money) {
    this.money = money;
    return this;
  }

  public String getBankCard_id() {
    return bankCard_id;
  }

  public Double getMoney() {
    return money;
  }
}
