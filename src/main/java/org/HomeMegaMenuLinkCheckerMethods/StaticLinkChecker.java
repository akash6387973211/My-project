package org.HomeMegaMenuLinkCheckerMethods;

public  class StaticLinkChecker {
    public static void StaticLink(String url) {
        try {
            int resps = LinkChecker.getResponseCode(url);
            if (resps > 400) {
                System.out.println("link is broken" + " " + url + resps);

            }

        } catch (Exception ess) {
            ess.printStackTrace();
        }
    }
}
