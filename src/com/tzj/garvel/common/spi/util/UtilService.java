package com.tzj.garvel.common.spi.util;

import com.tzj.garvel.common.spi.core.VCSType;

public interface UtilService {
    String findLevenshteinMatch(final String spelling);

    VCSType getVCSTypeFromString(String spelling);

    void displayFormattedToConsole(boolean newline, String format, Object... values);
}

