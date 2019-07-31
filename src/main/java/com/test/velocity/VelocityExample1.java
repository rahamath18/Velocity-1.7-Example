package com.test.velocity;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityExample1 {

	public static void main(String[] args) {
		
		Properties p = new Properties();
	    p.setProperty("resource.loader", "classpath");
	    p.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	    Velocity.init( p );

		VelocityContext context = new VelocityContext();

		context.put("name", new String("Rahamath S"));
		context.put("email", new String("rahamath18@yahoo.com"));

		Template template = null;

		try {
			template = Velocity.getTemplate("/templates/example1.vm");
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			System.out.println(writer.toString());
		} catch (ResourceNotFoundException rnfe) {
			// couldn't find the template
		} catch (ParseErrorException pee) {
			// syntax error: problem parsing the template
		} catch (MethodInvocationException mie) {
			// something invoked in the template
			// threw an exception
		} catch (Exception e) {

		}

		StringWriter sw = new StringWriter();

		template.merge(context, sw);

	}

}
