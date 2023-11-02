package com.phangji.houseutils.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

/**
 * 가격이 특정 범위일 때 상한요율과 한도액 가지는 클래스
 */

@AllArgsConstructor
@Getter
public class BrokerageRule {
    private Long lessThan;
    private Double brokeragePercent;
    private Long limitAmount;

    public BrokerageRule(Long lessThan, Double brokeragePercent) {
        this(lessThan, brokeragePercent, Long.MAX_VALUE);
    }

    public Long calcMaxBrokerage(Long price) {
        return Math.min(multiplePercent(price), limitAmount);
    }

    private Long multiplePercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}
