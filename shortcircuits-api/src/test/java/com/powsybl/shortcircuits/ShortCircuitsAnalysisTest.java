package com.powsybl.shortcircuits;

import com.powsybl.commons.PowsyblException;
import com.powsybl.computation.ComputationManager;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.interceptors.ShortCircuitAnalysisInterceptor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertTrue;

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

        assertTrue(res.getFaultResults().size() == 0);
        assertTrue(res.getLimitViolations().size() == 0);
    }

    @Test
    public void shortCircuitAnalysisWithDefaultProvider() {
        Assert.assertThrows(PowsyblException.class, () -> ShortCircuitAnalysis.runAsync(null, null, null));
    }
}
