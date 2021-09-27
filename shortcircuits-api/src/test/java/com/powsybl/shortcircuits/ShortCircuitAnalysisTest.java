/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits;

import com.powsybl.commons.PowsyblException;
import com.powsybl.computation.ComputationManager;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.interceptors.ShortCircuitAnalysisInterceptor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;

/**
 * @author Bertrand Rix <bertrand.rix at artelys.com>
 */
public class ShortCircuitAnalysisTest {

    @Test
    public void shortCircuitAnalysisWithDummyProvider() {

        ShortCircuitAnalysisProvider provider = new ShortCircuitAnalysisProvider() {
            @Override
            public String getName() {
                return "DummyProvider";
            }

            @Override
            public String getVersion() {
                return "0.0";
            }

            @Override
            public void addInterceptor(final ShortCircuitAnalysisInterceptor interceptor) {

            }

            @Override
            public boolean removeInterceptor(final ShortCircuitAnalysisInterceptor interceptor) {
                return false;
            }

            @Override
            public CompletableFuture<ShortCircuitAnalysisResult> run(Network network, ShortCircuitParameters parameters,
                                                                     ComputationManager computationManager) {

                return CompletableFuture.supplyAsync(() -> new ShortCircuitAnalysisResult(Collections.emptyList(), Collections.emptyList()));
            }
        };

        ShortCircuitAnalysisResult res = provider.run(null, null, null).join();

        assertEquals(0, res.getFaultResults().size());
        assertEquals(0, res.getLimitViolations().size());
    }

    @Test
    public void shortCircuitAnalysisWithDefaultProvider() {
        Assert.assertThrows(PowsyblException.class, () -> ShortCircuitAnalysis.runAsync(null, null, null));
    }
}
