/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.shortcircuits.ShortCircuitsParameters;

/**
 * @author Boubakeur Brahimi
 */
public class ShortCircuitsParametersSerializer extends StdSerializer<ShortCircuitsParameters> {

    public ShortCircuitsParametersSerializer() {
        super(ShortCircuitsParameters.class);
    }

    @Override
    public void serialize(ShortCircuitsParameters parameters, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        JsonUtil.writeExtensions(parameters, jsonGenerator, serializerProvider, JsonShortCircuitsParameters.getExtensionSerializers());
        jsonGenerator.writeEndObject();
    }

}
