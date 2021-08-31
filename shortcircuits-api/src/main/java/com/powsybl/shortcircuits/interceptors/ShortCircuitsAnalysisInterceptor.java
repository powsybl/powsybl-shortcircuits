/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
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
