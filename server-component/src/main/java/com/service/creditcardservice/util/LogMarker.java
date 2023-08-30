package com.service.creditcardservice.util;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public final class LogMarker {

    /**
     * default constructor with protected scope as it's a utility class
     */
    protected LogMarker() {
        super();
    }

    public static final Marker ENTRY = MarkerFactory.getMarker("Entering:");
    public static final Marker EXIT = MarkerFactory.getMarker("Exiting:");
}
