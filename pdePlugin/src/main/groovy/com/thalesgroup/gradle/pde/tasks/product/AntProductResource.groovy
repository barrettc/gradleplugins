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


package com.thalesgroup.gradle.pde.tasks.product;


import com.thalesgroup.gradle.pde.tasks.AntUtil
import com.thalesgroup.gradle.pde.tasks.ReplaceElt

class AntProductResource {

    void execute(String base, 
		 String buildDirectory, 
		 String builderDir, 
		 String productName,
		 String buildId,
		 String eclipseLocation,
		 String version,
		 AntBuilder ant) {
	
	File fBuilderDir = new File(builderDir);
	fBuilderDir.mkdirs();

	buildDirectory=buildDirectory.replace('\\','/')
	builderDir=builderDir.replace('\\','/')
        eclipseLocation=eclipseLocation.replace('\\','/')



	//build.properties
	java.io.InputStream buildPropertiesIs = this.getClass().getResourceAsStream ("/product/build.properties");
	AntUtil.processResource(buildPropertiesIs, fBuilderDir, "build.properties", [new ReplaceElt("gradleProductName",productName), 

											 new ReplaceElt("gradleEclipseBase", base),
											 new ReplaceElt("gradleBuildDirectory", buildDirectory),
											 new ReplaceElt("gradleBuildId", buildId)
											]);
	buildPropertiesIs.close();	


	//Links directory
	def tempLinkDir=new File(buildDirectory+"/links")	
        def destLinkDir=new File(eclipseLocation,"links");									 	
	tempLinkDir.listFiles().each{ File file->
          FileInputStream fIs = new FileInputStream(file)
	  AntUtil.processResource(fIs, destLinkDir, file.getName(), [new ReplaceElt("\\#\\{version\\}",version)]);
	  fIs.close();
        }

	
    }

}