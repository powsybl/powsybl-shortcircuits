/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions.cgmesimporter;

/**
 * @author Luma Zamarreño <zamarrenolm at aia.es>
 * @author José Antonio Marqués <marquesja at aia.es>
 */
public abstract class AbstractScImporter {

    static double impedanceToEngineeringUnit(double impedance, double vNominal, double sb) {
        if (Double.isNaN(impedance)) {
            return impedance;
        }
        return impedance * (vNominal * vNominal) / sb;
    }

    static double impedanceToPerUnit(double impedance, double vNominal, double sb) {
        if (Double.isNaN(impedance)) {
            return impedance;
        }
        return impedance * sb / (vNominal * vNominal);
    }
}
