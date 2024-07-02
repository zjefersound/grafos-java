package WebCrawler;

public class Main {
  public static void main(String[] args) {
    WebCrawler crawler = new WebCrawler();
    String rootURL = "https://www.unoesc.edu.br";
    crawler.discoverWeb(rootURL);
  }
}
