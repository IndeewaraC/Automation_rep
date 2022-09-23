package com.automationproject;

import org.openqa.selenium.By;

import com.automation.isq.runtime.SeleniumTestBase;
import com.automation.isq.utils.PropertyHandler;
import com.automation.isq.utils.ThreadLocalClass;

import java.util.ArrayList;

/**
 *  Class LIB_Common contains reusable business components 
 *  Each method in this class correspond to a reusable business component.
 */
public class LIB_Common {

    /**
     *  Business component bc_LaunchApplication.
     * 
     */
    public final static void bc_LaunchApplication(final SeleniumTestBase caller, final String prm_ApplicationURL, final String prm_Username, final String prm_Password) throws Exception {

        //Login to application
    	caller.open(prm_ApplicationURL, "5000");
    	caller.type("PG_Login.tf_SearchBox","","Book");
    	caller.click("PG_Login.btn_Search","");
    	caller.screenshot("This is to verify");
    	caller.checkElementPresent("PG_Login.ele_lblAllListings", "",false,"");

    }
}
