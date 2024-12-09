package org.HomeMegaMenuLinkCheckerMethods;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.reports.ExtentReportUtils;

public  class StaticLinkChecker {
    public static int StaticLink(String url) {
        int resps = LinkChecker.getResponseCode(url);
        try {

            if (resps != 200) {
                System.out.println("link is broken" + " " + url + resps);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resps;
    }

}
