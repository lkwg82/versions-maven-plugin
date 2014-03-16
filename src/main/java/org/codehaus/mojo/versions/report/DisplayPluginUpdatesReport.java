package org.codehaus.mojo.versions.report;

import java.util.ArrayList;
import java.util.List;

public class DisplayPluginUpdatesReport {
    private final List<ArtifactUpdate> pluginUpdates = new ArrayList<ArtifactUpdate>();
    private final List<Dependency> missingVersionPlugins =new ArrayList<Dependency>();
    private boolean warnNoMinimumVersion = false;
    private IncompatibleParentAndProjectMavenVersion incompatibleParentAndProjectMavenVersion;

    public void addPluginUpdate(ArtifactUpdate update) {
        pluginUpdates.add(update);
    }

    public void addMissingVersionPlugin(Dependency plugin) {
        missingVersionPlugins.add(plugin);
    }

    public void warnNoMinimumVersion() {
        warnNoMinimumVersion=true;
    }

    public void warn(IncompatibleParentAndProjectMavenVersion incompatibleParentAndProjectMavenVersion) {
        this.incompatibleParentAndProjectMavenVersion = incompatibleParentAndProjectMavenVersion;
    }

    public IncompatibleParentAndProjectMavenVersion getIncompatibleParentAndProjectMavenVersion() {
        return incompatibleParentAndProjectMavenVersion;
    }

    public List<Dependency> getMissingVersionPlugins() {
        return missingVersionPlugins;
    }

    public List<ArtifactUpdate> getPluginUpdates() {
        return pluginUpdates;
    }

    public boolean isWarnNoMinimumVersion() {
        return warnNoMinimumVersion;
    }
}
