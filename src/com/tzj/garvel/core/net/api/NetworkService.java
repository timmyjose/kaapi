package com.tzj.garvel.core.net.api;

public interface NetworkService {
    void downloadTextFIle(final String url);

    void downloadBinaryFile(final String url);
}