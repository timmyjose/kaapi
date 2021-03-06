package com.tzj.garvel.core.dep.api.repo;

import com.tzj.garvel.core.CoreModuleLoader;
import com.tzj.garvel.core.dep.api.exception.RepositoryLoaderException;
import com.tzj.garvel.core.net.api.NetworkConnector;
import com.tzj.garvel.core.net.api.NetworkConstants;
import com.tzj.garvel.core.net.api.exception.NetworkServiceException;

import java.io.File;

/**
 * The common functionality associated with a repository goes
 * here.
 */
public abstract class RepositoryLoader {
    protected RepositoryLoader nextLoader;
    protected RepositoryKind kind;

    public RepositoryLoader() {
    }

    public RepositoryKind getKind() {
        return kind;
    }

    protected RepositoryLoader getNextLoader() {
        return nextLoader;
    }

    public boolean checkRepoStatus() {
        try {
            return CoreModuleLoader.INSTANCE.getNetworkFramework().checkUrlAvailable(kind.getUrl());
        } catch (NetworkServiceException e) {
            return false;
        }
    }

    /**
     * Construct the base URL for the jar.
     *
     * @param groupId
     * @param artifactId
     * @return
     * @throws RepositoryLoaderException
     */
    public String constructBaseUrl(final String groupId, final String artifactId) throws RepositoryLoaderException {
        if (checkRepoStatus()) {
            // replace the periods with forwards slashes to construct the correct URL
            String modGroupId = groupId.replace(".", "/");
            return kind.getUrl() + NetworkConstants.FORWARD_SLASH + modGroupId + NetworkConstants.FORWARD_SLASH + artifactId;
        }

        if (nextLoader == null) {
            throw new RepositoryLoaderException(String.format("unable to construct base url for artifact \"%s%s%s\"\n",
                    groupId, File.separator, artifactId));
        }

        return nextLoader.constructBaseUrl(groupId, artifactId);
    }

    /**
     * Construct the Maven Medatadata XML file URL.
     *
     * @param groupId
     * @param artifactId
     * @return
     * @throws RepositoryLoaderException
     */
    public String constructMetadataUrl(final String groupId, final String artifactId) throws RepositoryLoaderException {
        if (checkRepoStatus()) {
            // replace the periods with forwards slashes to construct the correct URL
            String modGroupId = groupId.replace(".", "/");
            return kind.getUrl() + NetworkConstants.FORWARD_SLASH + modGroupId + NetworkConstants.FORWARD_SLASH +
                    artifactId + NetworkConstants.FORWARD_SLASH + RepositoryConstants.METADATA;
        }

        if (nextLoader == null) {
            throw new RepositoryLoaderException(String.format("unable to construct metadata url for artifact \"%s%s%s\"\n",
                    groupId, File.separator, artifactId));
        }


        return nextLoader.constructMetadataUrl(groupId, artifactId);
    }

    /**
     * Construct the POM XML file URL.
     *
     * @param groupId
     * @param artifactId
     * @param version
     * @return
     * @throws RepositoryLoaderException
     */
    public String constructPOMUrl(final String groupId, final String artifactId, final String version) throws RepositoryLoaderException {
        if (checkRepoStatus()) {
            final String modGroupId = groupId.replace(".", "/");

            return String.format(kind.getUrl() + NetworkConstants.FORWARD_SLASH + modGroupId + NetworkConstants.FORWARD_SLASH +
                    artifactId + NetworkConstants.FORWARD_SLASH +
                    version + NetworkConstants.FORWARD_SLASH +
                    artifactId + NetworkConstants.DASH + version +
                    RepositoryConstants.POM);
        }

        if (nextLoader == null) {
            throw new RepositoryLoaderException(String.format("unable to construct base url for artifact \"%s%s%s:%s\"\n",
                    groupId, File.separator, artifactId, version));
        }

        return nextLoader.constructPOMUrl(groupId, artifactId, version);
    }

    /**
     * Construct the JAR file Url for the jar.
     *
     * @param groupId
     * @param artifactId
     * @param version
     * @return
     * @throws RepositoryLoaderException
     */
    public String constructJARFileUrl(final String groupId, final String artifactId, final String version) throws RepositoryLoaderException {
        if (checkRepoStatus()) {
            final String modGroupId = groupId.replace(".", "/");

            return String.format(kind.getUrl() + NetworkConstants.FORWARD_SLASH + modGroupId + NetworkConstants.FORWARD_SLASH +
                    artifactId + NetworkConstants.FORWARD_SLASH +
                    version + NetworkConstants.FORWARD_SLASH +
                    artifactId + NetworkConstants.DASH + version +
                    RepositoryConstants.JAR);
        }

        return nextLoader.constructJARFileUrl(groupId, artifactId, version);
    }
}
