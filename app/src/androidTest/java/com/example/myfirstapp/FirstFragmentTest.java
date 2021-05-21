package com.example.myfirstapp;

import com.robotium.solo.Solo;

import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import org.junit.Assert;
import com.example.myfirstapp.FirstFragment;
import androidx.test.rule.ActivityTestRule;
import androidx.test.platform.app.InstrumentationRegistry;
import com.example.myfirstapp.FirstFragment;

public class FirstFragmentTest extends  TestCase {
    private Solo solo;

    public void setUp() throws Exception {
        super.setUp();

    }
    public void testButton() throws Exception{
        Assert.assertTrue( solo.searchText("Hello World!"));
    }
    public void tearDown() throws Exception {
    solo.finishOpenedActivities();
    }
}