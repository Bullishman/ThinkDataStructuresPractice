package org.first.mvc;

import java.sql.Connection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	public Crawler() {
		try {
			GetHomePage();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	public void GetHomePage() throws Exception {
		String url = "http://en.wikipedia.org/wiki/Java_(programming_language)";
		org.jsoup.Connection conn = Jsoup.connect(url);
		Document doc = conn.get();
		// select the content text and pull out the paragraphs.
		Element content = doc.getElementById("mw-content-text");
		Elements paragraphs = content.select("p");

	}
}
