package com.powsybl.shortcircuits;

import com.powsybl.commons.PowsyblException;
import com.powsybl.commons.Versionable;
import com.powsybl.commons.config.PlatformConfig;
import com.powsybl.commons.config.PlatformConfigNamedProvider;
import com.powsybl.computation.ComputationManager;
import com.powsybl.iidm.network.Network;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * API for short-circuit current computations.
 */
public final class ShortCircuitAnalysis {

    private ShortCircuitAnalysis() {
        throw new AssertionError("Utility class should not been instantiated");
    }

    public static final class Runner implements Versionable {
        private final ShortCircuitsAnalysisProvider provider;

        private Runner(ShortCircuitsAnalysisProvider provider) {
            this.provider = Objects.requireNonNull(provider);
        }

        public CompletableFuture<ShortCircuitAnalysisResult> runAsync(Network network,
                                                                      ShortCircuitParameters parameters,
                                                                      ComputationManager computationManager) {
            Objects.requireNonNull(network, "Network should not be null");
            Objects.requireNonNull(computationManager, "ComputationManager should not be null");
            Objects.requireNonNull(parameters, "Security analysis parameters should not be null");
            return provider.run(network, parameters, computationManager);
        }

        @Override
        public String getName() {
            return provider.getName();
        }

        @Override
        public String getVersion() {
            return provider.getVersion();
        }
    }

    public static Runner find(String name) {
        return new Runner(PlatformConfigNamedProvider.Finder
                .find(name, "shortcircuits-analysis", ShortCircuitsAnalysisProvider.class,
                        PlatformConfig.defaultConfig()));
    }

    /**
     * Get a runner for default security analysis implementation.
     *
     * @return a runner for default security analysis implementation
     * @throws PowsyblException in case we cannot find a default implementation
     */
    public static Runner find() {
        return find(null);
    }

    public static CompletableFuture<ShortCircuitAnalysisResult> runAsync(Network network, ShortCircuitParameters parameters,
                                                                         ComputationManager computationManager) {
        return find().runAsync(network, parameters, computationManager);
    }

}
