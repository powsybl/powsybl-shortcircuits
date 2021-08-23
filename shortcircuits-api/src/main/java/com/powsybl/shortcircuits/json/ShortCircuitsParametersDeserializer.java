/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.json;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.powsybl.commons.extensions.Extension;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.shortcircuits.ShortCircuitsParameters;

/**
 * @author Boubakeur Brahimi
 */
public class ShortCircuitsParametersDeserializer extends StdDeserializer<ShortCircuitsParameters> {

    public ShortCircuitsParametersDeserializer() {
        super(ShortCircuitsParameters.class);
    }

    @Override
    public ShortCircuitsParameters deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        return deserialize(jsonParser, deserializationContext, new ShortCircuitsParameters());
    }

    public ShortCircuitsParameters deserialize(JsonParser parser, DeserializationContext deserializationContext, ShortCircuitsParameters parameters) throws IOException {

        List<Extension<ShortCircuitsParameters>> extensions = Collections.emptyList();
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            switch (parser.getCurrentName()) {

                case "version":
                    parser.nextToken();
                    break;

                case "extensions":
                    parser.nextToken();
                    extensions = JsonUtil.readExtensions(parser, deserializationContext, JsonShortCircuitsParameters.getExtensionSerializers());
                    break;

                default:
                    throw new AssertionError("Unexpected field: " + parser.getCurrentName());
            }
        }

        JsonShortCircuitsParameters.getExtensionSerializers().addExtensions(parameters, extensions);

        return parameters;
    }

}
