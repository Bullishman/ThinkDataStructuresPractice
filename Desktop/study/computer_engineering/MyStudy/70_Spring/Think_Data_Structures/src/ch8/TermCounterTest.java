package ch8;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import ch7.WikiFetcher;

/**
 * @author downey
 *
 */
public class TermCounterTest {

	private TermCounter counter;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		
		WikiFetcher wf = new WikiFetcher();
		Elements paragraphs = wf.readWikipedia(url);
		
		counter = new TermCounter(url.toString());
		counter.processElements(paragraphs);
	}

	@Test
	public void testSize() {
		assertThat(counter.size(), is(4798));
	}
}