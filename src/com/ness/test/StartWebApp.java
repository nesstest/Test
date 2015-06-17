package com.ness.test;

import java.io.File;

import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

public class StartWebApp {
	
	public static void main(String[] args) throws Exception
	{
		String port = System.getenv("PORT");
		GlassFishProperties gfProps = new GlassFishProperties();
		gfProps.setPort("http-listener", Integer.parseInt(port));
		GlassFish glassfish = GlassFishRuntime.bootstrap().newGlassFish(gfProps);
		glassfish.start();          
		Deployer deployer = glassfish.getDeployer();            
		File file = new File("YourSimpleMavenWebapplication.war");      
		deployer.deploy(file);
	}
}
