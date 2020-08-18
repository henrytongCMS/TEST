package com.testing;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Search {

	public static void googleSearch(String content) {

		try {
			URI uri = new URI("www.google.com/search?q=" + content);
			Desktop.getDesktop().browse(uri);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Search.googleSearch("weather+today");

	}

}
