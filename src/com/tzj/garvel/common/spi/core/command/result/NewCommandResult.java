package com.tzj.garvel.common.spi.core.command.result;

import com.tzj.garvel.common.spi.core.command.CommandResult;

import java.nio.file.Path;

public class NewCommandResult extends CommandResult {
    private Path projectPath;
    private Path srcPath;
    private Path testsPath;
    private Path logsPath;
    private Path configPath;

    public NewCommandResult(final Path projectPath, final Path srcPath, final Path testsPath, final Path logsPath, final Path configPath) {
        this.projectPath = projectPath;
        this.srcPath = srcPath;
        this.testsPath = testsPath;
        this.logsPath = logsPath;
        this.configPath = configPath;
    }

    public Path getLogsPath() {
        return logsPath;
    }

    public Path getProjectPath() {
        return projectPath;
    }

    public Path getSrcPath() {
        return srcPath;
    }

    public Path getTestsPath() {
        return testsPath;
    }

    public Path getConfigPath() {
        return configPath;
    }
}
