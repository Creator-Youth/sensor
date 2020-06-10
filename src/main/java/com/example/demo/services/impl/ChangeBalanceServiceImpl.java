package com.example.demo.services.impl;

import com.example.demo.dao.BankCardBalanceJpa;
import com.example.demo.dao.BankCardJpa;
import com.example.demo.expection.BizException;
import com.example.demo.po.BankCard;
import com.example.demo.po.BankCardBalance;
import com.example.demo.services.ChangeBalanceService;
import com.example.demo.utils.ObjectUtils;
import com.example.demo.vo.ChangeBalanceView;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.stereotype.Service;

/**
 * 更改余额
 *
 * @author Liu YaXue
 * @since 1.0.0
 */
@Service
public class ChangeBalanceServiceImpl implements ChangeBalanceService {

  /**
   * 存钱类型
   */
  private static final String TYPE_OF_DEPOSIT = "deposit";

  /**
   * 取钱类型
   */
  private static final String TYPE_OF_WITHDRAW = "withdraw";

  /**
   * 加锁
   */
  private final Lock LOCK = new ReentrantLock();

  private final BankCardBalanceJpa bankCardBalanceJpa;

  private final BankCardJpa bankCardJpa;

  public ChangeBalanceServiceImpl(
      BankCardBalanceJpa bankCardBalanceJpa, BankCardJpa bankCardJpa) {
    this.bankCardBalanceJpa = bankCardBalanceJpa;
    this.bankCardJpa = bankCardJpa;
  }

  /**
   * 取钱逻辑
   *
   * @param changeBalanceView {@link ChangeBalanceView} 实例
   * @return 卡里余额
   */
  @Override
  public Double depositMoney(ChangeBalanceView changeBalanceView) {
    return changeBalance(changeBalanceView, TYPE_OF_DEPOSIT);
  }

  /**
   * 取钱逻辑
   *
   * @param changeBalanceView {@link ChangeBalanceView} 实例
   * @return 卡里余额
   */
  @Override
  public Double withdrawMoney(ChangeBalanceView changeBalanceView) {
    return changeBalance(changeBalanceView, TYPE_OF_WITHDRAW);
  }

  private Double changeBalance(ChangeBalanceView changeBalanceView, String type) {
    //TODO 正则表达式校验
    ObjectUtils.requireNonEmpty(changeBalanceView.getBankcardId(), "银行卡号不能为空");
    //判断金额
    ObjectUtils.requireNonNull(changeBalanceView.getMoney(), "交易金额不能为空");

    if (changeBalanceView.getMoney() < 0.0) {
      throw new BizException("400", "交易金额不能小于0");
    }

    //尝试加锁
    LOCK.tryLock();

    //获取卡实例
    BankCard card = this.bankCardJpa
        .findByBankCardNumber(changeBalanceView.getBankcardId());

    if (Objects.isNull(card)) {
      throw new BizException("卡片不存在");
    }
    if (card.getCardFlag()) {
      throw new BizException("卡片已注销");
    }

    //校验密码
    if (!card.getBankCardPassword().equals(changeBalanceView.getBankCardPassword())) {
      //密码校验失败
      throw new BizException("500", "密码错误");
    }

    try {
      //获取余额实例
      BankCardBalance cardBalance = this.bankCardBalanceJpa
          .findByBankCardId(changeBalanceView.getBankcardId());

      //获取卡里余额
      Double balance = cardBalance.getMoney();

      //改变的余额
      Double balanceChanged = null;
      if (TYPE_OF_DEPOSIT.equals(type)) {
        //存钱
        balanceChanged = balance + changeBalanceView.getMoney();
      }
      if (TYPE_OF_WITHDRAW.equals(type)) {
        //取钱
        if (balance < changeBalanceView.getMoney()) {
          throw new BizException("500", "余额不足");
        }
        balanceChanged = balance - changeBalanceView.getMoney();
      }

      cardBalance.setMoney(balanceChanged);

      //回写数据库
      this.bankCardBalanceJpa.saveAndFlush(cardBalance);

      return balanceChanged;
    } finally {
      LOCK.unlock();
    }
  }

}
