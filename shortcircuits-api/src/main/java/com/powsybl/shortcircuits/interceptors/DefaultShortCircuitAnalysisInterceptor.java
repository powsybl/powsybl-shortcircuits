package com.powsybl.shortcircuits.interceptors;

import com.powsybl.iidm.network.Network;
import com.powsybl.security.LimitViolation;
import com.powsybl.shortcircuits.FaultResult;
import com.powsybl.shortcircuits.ShortCircuitAnalysisResult;

/**
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
public class DefaultShortCircuitAnalysisInterceptor implements ShortCircuitAnalysisInterceptor {

    @Override
    public void onFaultResult(Network network, FaultResult faultResult) {
        // Nothing to do
    }

    @Override
    public void onLimitViolation(Network network, LimitViolation limitViolation) {
        // Nothing to do
    }

    @Override
    public void onShortCircuitResult(Network network, ShortCircuitAnalysisResult shortCircuitAnalysisResult) {
        // Nothing to do
    }
}

