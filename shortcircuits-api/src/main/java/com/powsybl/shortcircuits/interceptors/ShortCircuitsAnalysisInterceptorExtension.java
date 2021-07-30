package com.powsybl.shortcircuits.interceptors;

/**
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
public interface ShortCircuitsAnalysisInterceptorExtension {

    String getName();

    ShortCircuitsAnalysisInterceptor createInterceptor();
}
