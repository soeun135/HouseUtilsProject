package com.phangji.houseutils.controller;

import com.phangji.houseutils.constants.ActionType;
import com.phangji.houseutils.policy.BrokerPolicyFactory;
import com.phangji.houseutils.policy.BrokeragePolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 중개수수료가 얼마인지 조회하는 컨트롤러
 */
@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        BrokeragePolicy policy = BrokerPolicyFactory.of(actionType);

        return policy.calculate(price);
    }
}
