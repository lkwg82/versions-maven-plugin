package org.codehaus.mojo.versions.api;

import org.apache.maven.model.InputSource;

import java.util.HashMap;
import java.util.Map;

public class ArtifactUpdate {
    public static class InputLocation {
        private int line;
        private int column;
        private InputSource inputSource;

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public InputSource getInputSource() {
            return inputSource;
        }

        public void setInputSource(InputSource inputSource) {
            this.inputSource = inputSource;
        }

        public int getLine() {
            return line;
        }

        public void setLine(int line) {
            this.line = line;
        }
    }

    public static class Dependency {
        private String groupId;
        private String artifactId;
        private String version;
        private String type;
        private String scope;
        private String projectId;
        private Map<String, InputLocation> inputLocationMap = new HashMap<String, InputLocation>();

        public String getArtifactId() {
            return artifactId;
        }

        public void setArtifactId(String artifactId) {
            this.artifactId = artifactId;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        public void addInputLocation(String key, org.apache.maven.model.InputLocation location) {
            final InputLocation inputLocation = new InputLocation();

            inputLocation.setLine(location.getLineNumber());
            inputLocation.setColumn(location.getColumnNumber());
            inputLocation.setInputSource(location.getSource());

            inputLocationMap.put(key, inputLocation);
        }

        public Map<String, InputLocation> getInputLocationMap() {
            return inputLocationMap;
        }

        public void setInputLocationMap(Map<String, InputLocation> inputLocationMap) {
            this.inputLocationMap = inputLocationMap;
        }
    }

    private Dependency dependency;
    private String versionUpdate;

    public Dependency getDependency() {
        return dependency;
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public String getVersionUpdate() {
        return versionUpdate;
    }

    public void setVersionUpdate(String versionUpdate) {
        this.versionUpdate = versionUpdate;
    }
}
