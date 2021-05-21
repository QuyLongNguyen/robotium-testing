package com.example.myfirstapp;
import  com.example.myfirstapp.MainActivity;

import junit.framework.TestCase;
import androidx.test.rule.ActivityTestRule;
import com.robotium.solo.Solo;
import org.junit.Assert;
import android.test.ActivityInstrumentationTestCase2;
import androidx.test.platform.app.InstrumentationRegistry;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{

    //Đối tượng thực hiện kiểm thử tự động
    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    // Phương thức setUP được gọi trước khi chương trình bắt đầu kiểm thử
    public void setUp() throws Exception {

        solo = new Solo(getInstrumentation(),getActivity());
    }
    public void testLoadActivitySuccessfully() throws Exception{
        //Test case đúng
        // Kiểm tra activity hiện tại
        solo.assertCurrentActivity("wrong activity",MainActivity.class);

        //Test case sai
        //solo.assertCurrentActivity("wrong activity",SecondActivity.class);
    }

    public void testTextOfHompageCorrectly() {
        //Test case đúng
        //Tìm kiếm textview
        Assert.assertTrue(solo.searchText("Homepage"));

        //Test case sai
        //Assert.assertTrue(solo.searchText("This is first fragment"));
    }


    public void testLoginSuccessfully(){
        //Tự động nhập username và password
        solo.enterText(0,"long");
        solo.enterText(1,"123456");
        // Tự động click button
        solo.clickOnButton("Next");

        // Tạo ra một solo mới sau action click button
        Solo new_solo = new Solo(getInstrumentation(),getActivity());

        // Kiểm tra activity hiện tại của solo1
        new_solo.assertCurrentActivity("Wrong activity","SecondActivity");
    }


    // Phương thức tearDown được gọi khi chương trình thực hiện xong quá trình kiểm thử
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}