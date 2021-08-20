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
import com.powsybl.shortcircuits.interceptors.ShortCircuitsAnalysisInterceptor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertTrue;

/**
 * @author Bertrand Rix <bertrand.rix at artelys.com>
 */
public class ShortCircuitsAnalysisTest {

    @Test
    public void shortCircuitAnalysisWithDummyProvider() {

        ShortCircuitsAnalysisProvider provider = new ShortCircuitsAnalysisProvider() {
            @Override
            public String getName() {
                return "DummyProvicer";
            }

            @Override
            public String getVersion() {
                return "0.0";
            }

            @Override
            public void addInterceptor(final ShortCircuitsAnalysisInterceptor interceptor) {

            }

            @Override
            public boolean removeInterceptor(final ShortCircuitsAnalysisInterceptor interceptor) {
                return false;
            }

            @Override
            public CompletableFuture<ShortCircuitsAnalysisResult> run(Network network, ShortCircuitsParameters parameters,
                                                                      ComputationManager computationManager) {

                return CompletableFuture.supplyAsync(() -> new ShortCircuitsAnalysisResult(Collections.emptyList(), Collections.emptyList()));
            }

            @Override
            public ShortCircuitsAnalysisResult run(Network network) {
                return new ShortCircuitsAnalysisResult(Collections.emptyList(), Collections.emptyList());
            }
        };

        ShortCircuitsAnalysisResult res = provider.run(null, null, null).join();

        assertTrue(res.getFaultResults().size() == 0);
        assertTrue(res.getLimitViolations().size() == 0);

        ShortCircuitsAnalysisResult res2 = provider.run(null);

        assertTrue(res2.getFaultResults().size() == 0);
        assertTrue(res2.getLimitViolations().size() == 0);
    }

    @Test
    public void shortCircuitAnalysisWithDefaultProvider() {
        Assert.assertThrows(PowsyblException.class, () -> ShortCircuitsAnalysis.runAsync(null, null, null));
    }
}
