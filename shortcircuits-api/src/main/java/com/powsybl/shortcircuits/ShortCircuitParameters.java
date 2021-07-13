package com.powsybl.shortcircuits;

import java.util.Objects;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.powsybl.commons.config.PlatformConfig;
import com.powsybl.commons.extensions.AbstractExtendable;
import com.powsybl.commons.extensions.Extension;
import com.powsybl.commons.extensions.ExtensionConfigLoader;
import com.powsybl.commons.extensions.ExtensionProviders;

/**
 * Generic parameters for short circuit-computations.
 * May contain extensions for implementation-specific parameters.
 */
public class ShortCircuitParameters extends AbstractExtendable<ShortCircuitParameters> {

    public interface ConfigLoader<E extends Extension<ShortCircuitParameters>>
            extends ExtensionConfigLoader<ShortCircuitParameters, E> {
    }

    private static final Supplier<ExtensionProviders<ConfigLoader>> SUPPLIER = Suppliers
            .memoize(() -> ExtensionProviders.createProvider(ConfigLoader.class, "short-circuit-parameters"));

    public static ShortCircuitParameters load() {
        return load(PlatformConfig.defaultConfig());
    }

    public static ShortCircuitParameters load(PlatformConfig platformConfig) {
        Objects.requireNonNull(platformConfig);

        ShortCircuitParameters parameters = new ShortCircuitParameters();
        parameters.readExtensions(platformConfig);

        return parameters;
    }

    private void readExtensions(PlatformConfig platformConfig) {
        for (ConfigLoader provider : SUPPLIER.get().getProviders()) {
            addExtension(provider.getExtensionClass(), provider.load(platformConfig));
        }
    }

}
