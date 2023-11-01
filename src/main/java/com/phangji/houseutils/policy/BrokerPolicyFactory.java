package com.phangji.houseutils.policy;

import com.phangji.houseutils.constants.ActionType;

public class BrokerPolicyFactory {
    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default :
                throw new IllegalArgumentException("해당 actionType에 대한 정책이 존재하지 않음.");
        }
    }
}
