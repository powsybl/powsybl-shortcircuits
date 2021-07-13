package com.powsybl.shortcircuits;

import com.powsybl.computation.ComputationManager;
import com.powsybl.iidm.network.Network;

/**
 * Factory interface for short-circuit current computations.
 * In charge of creating {@link ShortCircuitAnalysis} objects.
 */
public interface ShortCircuitAnalysisFactory {

    /**
     * Creates a new instance of {@link ShortCircuitAnalysis}.
     */
    ShortCircuitAnalysis create(Network network, ComputationManager computationManager);

}
