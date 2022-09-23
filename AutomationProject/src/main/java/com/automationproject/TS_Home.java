package com.automationproject;

import java.util.HashMap;
import java.util.List;
import com.automation.isq.aspects.RecoveryMethods;
import com.automation.isq.runtime.SeleniumTestBase;
import com.automation.isq.runtime.AutomationTestListener;
import com.automation.isq.utils.PropertyHandler;
import com.automation.isq.utils.ThreadLocalClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import java.util.ArrayList;

/**
 *  Class TS_Home implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (AutomationTestListener.class)
public class TS_Home extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_01.
     * @return data table
     */
    @DataProvider(name = "tc_01")
    public Object[][] dataTable_tc_01() {     	
    	return this.getDataTable("dt_01");
    }

    /**
     * Data driven test case tc_01.
     *
     * @throws Exception the exception
     */
    @RecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_01")
    public final void tc_01(final String dt_01_testCaseID, final String dt_01_applicationURL, final String dt_01_userName, final String dt_01_password) throws Exception {
    	

    		setCurrentStatus("PASSED");
            try {
    	//
    	LIB_Common.bc_LaunchApplication(this, dt_01_applicationURL,dt_01_userName,dt_01_password);
    	
    			
    			
                } finally   {
                /*
                			PropertyHandler propHandler = new PropertyHandler("testLinkRuntime.properties");
        					String tetLink_TC_PRIFIX = propHandler.getRuntimeProperty("tetLink_TC_PRIFIX");
    			            setCurrentTC(tetLink_TC_PRIFIX+"-"+"tc_01");
    			    		System.out.println("TC:"+getCurrentTC());
    			    		System.out.println("STATUS:"+getCurrentStatus());
    			    		if(getCurrentTC().startsWith(tetLink_TC_PRIFIX)){
    			    			reportTestLinkResult(getCurrentTC(), getCurrentStatus());
    			    		}
*/
    					}
            
            } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}