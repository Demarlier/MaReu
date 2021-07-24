package johnny.demarlier.mareu.Controller;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import johnny.demarlier.mareu.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ListMeetingActivityTest {

    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityTestRule = new ActivityTestRule<>(ListMeetingActivity.class);

    @Test
    public void listMeetingActivityTest() {
        ViewInteraction viewPager = onView(
                allOf(withId(R.id.viewPager_listMeeting),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        viewPager.check(matches(isDisplayed()));
    }
}
