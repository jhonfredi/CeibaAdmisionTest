package co.com.ceiba.mobile.pruebadeingreso.view;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import co.com.ceiba.mobile.pruebadeingreso.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoadPostByUserTest {

    private String userNameSearch;
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);


    @Before
    public void initValues(){
        userNameSearch ="patrici";
    }

    @Test
    public void searchUserName(){
        //type test
        onView(withId(R.id.editTextSearch))
                .perform(ViewActions.typeText(userNameSearch), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_view_post)).perform(ViewActions.click());


    }


}
