package com.powsybl.shortcircuits;

import java.util.Objects;

import com.powsybl.commons.config.ComponentDefaultConfig;
import com.powsybl.commons.config.PlatformConfig;
import com.powsybl.computation.ComputationManager;
import com.powsybl.iidm.network.Network;

/**
 * Provides utility methods to launch a short-circuit analysis.
 *
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
public class ShortCircuitAnalyzer {

    private final ComputationManager computationManager;

    private final ShortCircuitAnalysisFactory factory;

    public ShortCircuitAnalyzer(ComputationManager computationManager) {
        this(computationManager, PlatformConfig.defaultConfig());
    }

    public ShortCircuitAnalyzer(ComputationManager computationManager, PlatformConfig platformConfig) {
        Objects.requireNonNull(platformConfig);
        this.computationManager = Objects.requireNonNull(computationManager);
        this.factory = ComponentDefaultConfig.load(platformConfig).newFactoryImpl(ShortCircuitAnalysisFactory.class);
    }

    public ShortCircuitAnalysisResult analyze(Network network, ShortCircuitParameters parameters) {
        Objects.requireNonNull(network);
        Objects.requireNonNull(parameters);

        ShortCircuitAnalysis shortCircuitAnalysis = factory.create(network, computationManager);

        return shortCircuitAnalysis.runAsync(parameters).join();
    }
}
