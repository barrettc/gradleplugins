/*******************************************************************************
* Copyright (c) 2009 Thales Corporate Services SAS                             *
* Author : Gregory Boissinot                                                   *
*                                                                              *
* Permission is hereby granted, free of charge, to any person obtaining a copy *
* of this software and associated documentation files (the "Software"), to deal*
* in the Software without restriction, including without limitation the rights *
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell    *
* copies of the Software, and to permit persons to whom the Software is        *
* furnished to do so, subject to the following conditions:                     *
*                                                                              *
* The above copyright notice and this permission notice shall be included in   *
* all copies or substantial portions of the Software.                          *
*                                                                              *
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR   *
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,     *
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  *
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER       *
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,*
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN    *
* THE SOFTWARE.                                                                *
*******************************************************************************/


package com.thalesgroup.gradle.pde.tasks.feature;

class AntFeaturePde {

    void execute(String eclipseLocation, String baseLocation, String equinoxLauncherPluginVersion, 
		 String buildDirectory, String builderDir, 
		 String timestamp, String pdeBuildPluginVersion, AntBuilder ant) {

	buildDirectory=buildDirectory.replace('\\','/')
	builderDir=builderDir.replace('\\','/')

	ant.echo(message:'Building..')
        ant.java( 
           classname:"org.eclipse.equinox.launcher.Main",
           fork:"true",
           failonerror:"true"){
	  arg(value:"-application")
	  arg(value:"org.eclipse.ant.core.antRunner")
	  arg(value:"-buildfile")
	  arg(value:"${eclipseLocation}/plugins/org.eclipse.pde.build_${pdeBuildPluginVersion}/scripts/build.xml")
	  arg(value:"-Dtimestamp=${timestamp}")
	  arg(value:"-Dbuilder=${builderDir}")
	  arg(value:"-DviewPath=${buildDirectory}")
	  classpath{
		pathelement(location:"${baseLocation}/plugins/org.eclipse.equinox.launcher_${equinoxLauncherPluginVersion}.jar")
	  }
       } 
    }
}