package com.example.myfirstapp;

import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;
import org.junit.Assert;

public class SecondActivityTest extends ActivityInstrumentationTestCase2<SecondActivity> {
    public SecondActivityTest(){
        super(SecondActivity.class);
    }

    //Đối tượng thực hiện kiểm thử tự động
    private Solo solo;
    public void setUp() throws Exception {

        solo = new Solo(getInstrumentation(),getActivity());
    }
    public void testLoadActivity() throws Exception{
        // Test case đúng
        solo.assertCurrentActivity("wrong activity",SecondActivity.class);

        //Test case sai
        //solo.assertCurrentActivity("wrong activity",MainActivity.class);

    }

    public void testTextOfHompage() {
        // Testcase đúng
        Assert.assertTrue(solo.searchText("Square Caculator"));

       //Testcase sai
       //Assert.assertTrue(solo.searchText("This is first fragment"));

    }
    public void testCaculator(){
        solo.enterText(0,String.valueOf(2));
        solo.clickOnButton("Caculate");
        String result = solo.getEditText(1).getText().toString();
        //Test case đúng khi expected = 4
        if(Integer.parseInt(result) == /* expected= */ 4){
            Assert.assertEquals(1,1);
        }
        else {
            Assert.assertEquals(1,0);
        }

    }
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}