package com.example.demo.services;

import com.example.demo.vo.ChangeBalanceView;
import org.springframework.stereotype.Service;

/**
 * 改变余额
 *
 * @author Liu YaXue
 * @since 1.0.0
 */
@Service
public interface ChangeBalanceService {

  /**
   * 取钱逻辑
   *
   * @param changeBalanceView {@link ChangeBalanceView} 实例
   * @return 卡里余额
   */
  Double depositMoney(ChangeBalanceView changeBalanceView);

  /**
   * 取钱逻辑
   *
   * @param changeBalanceView {@link ChangeBalanceView} 实例
   * @return 卡里余额
   */
  Double withdrawMoney(ChangeBalanceView changeBalanceView);
}


