package ch6;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
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
		Element firstPara = paragraphs.get(1);
//		System.out.println(firstPara);

		Iterable<Node> iter = new WikiNodeIterable(firstPara);

		for (Node node : iter) {
			if (node instanceof TextNode) {
				System.out.print(node);
			}
		}
	}

	private static void recursiveDFS(Node node) {
		if (node instanceof TextNode) {
			System.out.print(node);
		}
		for (Node child : node.childNodes()) {
			recursiveDFS(child);
		}
	}

	/*// パラメータを私たちが探索するツリーのrootです。 また,私たちはstackを生成し,rootを入れます。
	private static void iterativeDFS(Node root) {
		
		Deque<Node> stack = new ArrayDeque<Node>();
		stack.push(root);
		
		// loopは stackが 空いた状態になるまで繰り返されます。 
		while (!stack.isEmpty()) {
			
			// 各繰り返し状態毎にNodeをスタックにポップします。
			Node node = stack.pop();
			
			// もし TextNode を探すならnodeをプリントします。
			if (node instanceof TextNode) {
				System.out.print(node);
			}
			
			// その後は,子供のノードをstackにpushします。
			List<Node> nodes = new ArrayList<Node>(node.childNodes());
			
			// 子供ノードを右の方向に進めるため,私たちは逆方向にスターバックにパスします。
			Collections.reverse(nodes);
			
			for (Node child : nodes) {
				stack.push(child);
			}
		}
	}*/
}
