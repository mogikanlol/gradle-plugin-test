import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class InsureVersionPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.afterEvaluate(p -> {
            if (p.hasProperty("teamcity")) {
                String version = (String) p.getVersion();
                String newVersion = version + "." + p.property("build.number");

                p.setVersion(newVersion);
            } else {
                String version = (String) p.getVersion();
                p.setVersion(version + "-SNAPSHOT");
            }
        });
    }

}
