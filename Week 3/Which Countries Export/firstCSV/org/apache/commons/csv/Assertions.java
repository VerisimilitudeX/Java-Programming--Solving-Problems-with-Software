package org.apache.commons.csv;

final class Assertions {
    private Assertions() {
    }
    
    public static void notNull(final Object parameter, final String parameterName) {
        if (parameter == null) {
            throw new IllegalArgumentException("Parameter '" + parameterName + "' must not be null!");
        }
    }
}
