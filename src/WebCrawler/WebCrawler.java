package WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private Queue<String> queue;
    private List<String> discoveredWebsitesList;

    public WebCrawler() {
        this.queue = new LinkedList<String>();
        this.discoveredWebsitesList = new ArrayList<>();
    }

    private String readURL(String v) {
        String rawHTML = "";

        try {
            URL url = new URI(v).toURL();
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine = "";
            while ((inputLine = in.readLine()) != null) {
                rawHTML += inputLine;
            }

            in.close();


        } catch (Exception e) {
            System.out.println("Erro ao acessar URL " + v);
        }

        return rawHTML;
    }

    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsitesList.add(root);

        while (!queue.isEmpty()) {
            String v = this.queue.remove();
            String rawHTML = readURL(v);

            Pattern pattern = Pattern.compile("https://(\\w+\\.)*(\\w+)");
            Matcher matcher = pattern.matcher(rawHTML);

            while (matcher.find()) {
                String actualURL = matcher.group();
                if (!discoveredWebsitesList.contains(actualURL)) {
                    discoveredWebsitesList.add(actualURL);
                    System.out.println("Website encontrado com a URL: " + actualURL);
                    queue.add(actualURL);
                }
            }

        }
    }
}