package com.powsybl.shortcircuits.interceptors;

import com.powsybl.iidm.network.Network;
import com.powsybl.security.LimitViolation;
import com.powsybl.shortcircuits.FaultResult;
import com.powsybl.shortcircuits.ShortCircuitAnalysisResult;

/**
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
public interface ShortCircuitAnalysisInterceptor {

    void onFaultResult(Network network, FaultResult faultResult);

    void onLimitViolation(Network network, LimitViolation limitViolation);

    void onShortCircuitResult(Network network, ShortCircuitAnalysisResult shortCircuitAnalysisResult);
}
