package com.phangji.houseutils.policy;

import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * 가격이 특정 범위일 때 상한요율과 한도액 가지는 클래스
 */

@AllArgsConstructor
public class BrokerageRule {
    private Double brokeragePercent;

    @Nullable
    private Long limitAmount;

    public Long calcMaxBrokerage(Long price) {
        Long calPrice = multiplePercent(price);
        if (limitAmount == null) {
            return calPrice;
        }
        return Math.min(calPrice, limitAmount);
    }

    private Long multiplePercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}
