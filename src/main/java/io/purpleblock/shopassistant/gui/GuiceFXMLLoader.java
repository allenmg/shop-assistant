package io.purpleblock.shopassistant.gui;

import java.io.IOException;
import java.net.URL;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

public class GuiceFXMLLoader {
	
	private final URL location;
	
	private FXMLLoader loader;
	
	public GuiceFXMLLoader(URL location) {
		this.location = location;
	}
	
	public static final Injector injector = Guice.createInjector(new ApplicationModule());
	public static <T> T load(URL location) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> clazz) {
				return injector.getInstance(clazz);
			}
		});
		return loader.load(location.openStream());
	}
	
	public <T> T load() throws IOException {
		loader = new FXMLLoader();
		loader.setLocation(location);
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> clazz) {
				return injector.getInstance(clazz);
			}
		});
		return loader.load(location.openStream());
	}
	
	public FXMLLoader getFXMLLoader() {
		return loader;
	}
}
