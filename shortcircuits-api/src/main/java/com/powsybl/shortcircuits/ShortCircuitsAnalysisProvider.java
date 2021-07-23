package com.powsybl.shortcircuits;

import com.powsybl.commons.Versionable;
import com.powsybl.commons.config.PlatformConfigNamedProvider;
import com.powsybl.computation.ComputationManager;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.interceptors.ShortCircuitAnalysisInterceptor;

import java.util.concurrent.CompletableFuture;

public interface ShortCircuitsAnalysisProvider extends Versionable, PlatformConfigNamedProvider {

    void addInterceptor(ShortCircuitAnalysisInterceptor interceptor);

    boolean removeInterceptor(ShortCircuitAnalysisInterceptor interceptor);

    default CompletableFuture<ShortCircuitAnalysisResult> run(Network network, ShortCircuitParameters parameters,
                                                              ComputationManager computationManager) {
        return ShortCircuitAnalysis.runAsync(network, parameters, computationManager);
    }
}
