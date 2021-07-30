package com.powsybl.shortcircuits;

import com.powsybl.commons.Versionable;
import com.powsybl.commons.config.PlatformConfigNamedProvider;
import com.powsybl.computation.ComputationManager;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.interceptors.ShortCircuitsAnalysisInterceptor;

import java.util.concurrent.CompletableFuture;

public interface ShortCircuitsAnalysisProvider extends Versionable, PlatformConfigNamedProvider {

    void addInterceptor(ShortCircuitsAnalysisInterceptor interceptor);

    boolean removeInterceptor(ShortCircuitsAnalysisInterceptor interceptor);

    default CompletableFuture<ShortCircuitsAnalysisResult> run(Network network, ShortCircuitsParameters parameters,
                                                               ComputationManager computationManager) {
        return ShortCircuitsAnalysis.runAsync(network, parameters, computationManager);
    }
}
