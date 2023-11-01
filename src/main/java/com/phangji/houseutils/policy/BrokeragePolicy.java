package com.phangji.houseutils.policy;


public interface BrokeragePolicy {

    BrokerageRule createdBrokerageRule(Long price);
    default Long calculate(Long price) {
        //가격을 받아서 중개수수료 계산
        BrokerageRule rule = createdBrokerageRule(price);
        return rule.calcMaxBrokerage(price);
    }
}
