/**
 * 
 */
package com.breskeby.gradle.notification

import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Build
import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.StartParameter
import org.gradle.BuildResult
import org.gradle.BuildListener

/**
 * @author Rene
 *
 */
class NotifyBuildListener implements BuildListener{

	void buildStarted(StartParameter startParameter){
		
	}

    /**
     * <p>Called when the build settings have been loaded and evaluated. The settings object is fully configured and is
     * ready to use to load the build projects.</p>
     *
     * @param settings The settings. Never null.
     */
    void settingsEvaluated(Settings settings){
    	 
     }

    /**
     * <p>Called when the projects for the build have been created from the settings. None of the projects have been
     * evaluated.</p>
     *
     * @param build The build which has been loaded. Never null.
     */
    void projectsLoaded(Build build){
    	 
     }

    /**
     * <p>Called when all projects for the build have been evaluated. The project objects are fully configured and are
     * ready to use to populate the task graph.</p>
     *
     * @param build The build which has been evaluated. Never null.
     */
    void projectsEvaluated(Build build){
    	 
     }

    /**
     * <p>Called when the task graph for the build has been populated. The task graph is fully configured and is ready
     * to use to execute the tasks which make up the build.</p>
     *
     * @param graph The task graph. Never null.
     */
    void taskGraphPopulated(TaskExecutionGraph graph){
   
     }

    /**
     * <p>Called when the build is completed. All selected tasks have been executed.</p>
     *
     * @param result The result of the build. Never null.
     */
    void buildFinished(BuildResult result){
    	 
     }
	
}
