package com.automation.isq.runtime.pages;

/**
 *  Class PG_Login implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum PG_Login {
	tf_SearchBox("//input[@id='gh-ac']"), btn_Search("//input[@id='gh-btn']") , ele_lblAllListings("//h2[text()='All Listings']")
;

    private String searchPath;
  
    /**
    *  Page PG_Login.
    */
    private PG_Login(final String psearchPath) {
        this.searchPath = psearchPath;
    }
    
    /**
     *  Get search path.
     * @param searchPath search path.
     */
    public final String getSearchPath() {
        return searchPath;
    }
}