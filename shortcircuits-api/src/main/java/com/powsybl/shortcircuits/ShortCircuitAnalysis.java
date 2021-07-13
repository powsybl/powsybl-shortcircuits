package com.powsybl.shortcircuits;

import com.powsybl.shortcircuits.interceptors.ShortCircuitAnalysisInterceptor;

import java.util.concurrent.CompletableFuture;

/**
 * API for short-circuit current computations.
 */
public interface ShortCircuitAnalysis {

    void addInterceptor(ShortCircuitAnalysisInterceptor interceptor);

    boolean removeInterceptor(ShortCircuitAnalysisInterceptor interceptor);

    /**
     * Runs asynchronously a short-circuit current computation.
     */
    CompletableFuture<ShortCircuitAnalysisResult> runAsync(ShortCircuitParameters shortCircuitParameters);

}
