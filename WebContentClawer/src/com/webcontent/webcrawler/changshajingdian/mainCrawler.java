package com.webcontent.webcrawler.changshajingdian;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;


public class mainCrawler {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "F:\\zhoubin-project\\pagedate2";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxDepthOfCrawling(1);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
 
        controller.addSeed("http://changsha.cncn.com/jingdian/index1.htm");
        controller.addSeed("http://changsha.cncn.com/jingdian/index2.htm");
        controller.addSeed("http://changsha.cncn.com/jingdian/index3.htm");
        controller.addSeed("http://changsha.cncn.com/jingdian/index4.htm");
        controller.addSeed("http://changsha.cncn.com/jingdian/index5.htm");
       // controller.addSeed("http://changsha.cncn.com/jingdian/yueliangdao/");
        

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(MyCrawler.class, numberOfCrawlers);    
}


}