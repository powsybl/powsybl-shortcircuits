package com.powsybl.shortcircuits.interceptors;

import com.powsybl.iidm.network.Network;
import com.powsybl.security.LimitViolation;
import com.powsybl.shortcircuits.FaultResult;
import com.powsybl.shortcircuits.ShortCircuitsAnalysisResult;

/**
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
public interface ShortCircuitsAnalysisInterceptor {

    void onFaultResult(Network network, FaultResult faultResult);

    void onLimitViolation(Network network, LimitViolation limitViolation);

    void onShortCircuitResult(Network network, ShortCircuitsAnalysisResult shortCircuitsAnalysisResult);
}
