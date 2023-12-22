package rh;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Map;

final class VM {

    private static final Class<?> MISC_VM_CLASS;

    private static final VarHandle ALLOW_ATTACH_SELF;

    static {
        try {
            MISC_VM_CLASS = Class.forName("jdk.internal.misc.VM");
            final var lookup = MethodHandles.lookup();
            ALLOW_ATTACH_SELF = lookup.findStaticVarHandle(MISC_VM_CLASS, "savedProps", Map.class);
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public static void setSavedProperty(final String key, final String value) {
        final Map<String, String> props = (Map<String, String>) ALLOW_ATTACH_SELF.get();
        props.put(key, value);
    }

}
