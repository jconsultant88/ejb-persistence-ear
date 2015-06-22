package org.practise.ejb.service.impl;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.practise.ejb.service.LibraryPersistentBeanRemote;

public class LibraryPersistentBeanTest {

	private static Context ctx;
	private static EJBContainer ejbContainer;

	@BeforeClass
	public static void setUp() throws IOException {

		// FileUtils.copyFile(new
		// File("target/test-classes/META-INF/persistence.xml"), new
		// File("target/classes/META-INF/persistence.xml"));

		File[] modules = { new File("target/test-classes"),
				new File("target/classes")

		};
		Map<String, Object> props = new HashMap<String, Object>();
		// props.put(EJBContainer.MODULES, modules);

		// Calling EJBContainer.createEJBContainer() using
		// glassfish-embedded-all.jar works only if
		// org.glassfish.ejb.embedded.glassfish.installation.root is set to a
		// valid GlassFish install
		props.put("org.glassfish.ejb.embedded.glassfish.installation.root",
				"src/test/resources/gfv3");

		ejbContainer = EJBContainer.createEJBContainer(props);
		ctx = ejbContainer.getContext();
	}

	@AfterClass
	public static void tearDown() {
		ejbContainer.close();
		System.out.println("Closing the container");
	}

	@Test
	public void testApp() throws NamingException {

		LibraryPersistentBeanRemote persistentBean = (LibraryPersistentBeanRemote) ctx
				.lookup("java:global/classes/LibraryPersistentBean");

		persistentBean.addBook("EJB-JPA-Junits");

	}
}
