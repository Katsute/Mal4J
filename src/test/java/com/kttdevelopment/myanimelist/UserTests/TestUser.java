package com.kttdevelopment.myanimelist.UserTests;

import com.kttdevelopment.myanimelist.MyAnimeList;
import com.kttdevelopment.myanimelist.TestProvider;
import com.kttdevelopment.myanimelist.user.User;
import com.kttdevelopment.myanimelist.user.UserAnimeStatistics;
import org.junit.jupiter.api.*;

public class TestUser {

    private static MyAnimeList mal;
    private static User user;

    @SuppressWarnings("ConstantConditions")
    @BeforeAll
    public static void beforeAll(){
        mal = TestProvider.getMyAnimeList();
        user = mal.getMyself();
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test @DisplayName("Not currently allowed by API") @Disabled
    public void testUser(){
        Assertions.assertEquals(8316239, mal.getUser("KatsuteDev").getID());
    }

    @Test
    public void testMyself(){
        Assertions.assertNotEquals(-1, user.getID());
        Assertions.assertNotNull(user.getName());
        Assertions.assertNotNull(user.getPictureURL());
        Assertions.assertNotNull(user.getGender());
        Assertions.assertNotNull(user.getLocation());
        Assertions.assertNotEquals(-1, user.getJoinedAt());
        Assertions.assertNotNull(user.getTimeZone());
        Assertions.assertFalse(user.isSupporter()); // weak test, default is false
    }

    @Test
    public void testStatistics(){
        final UserAnimeStatistics statistics = user.getAnimeStatistics();
        Assertions.assertNotEquals(-1, statistics.getItemsWatching());
        Assertions.assertNotEquals(-1, statistics.getItemsCompleted());
        Assertions.assertNotEquals(-1, statistics.getDaysOnHold());
        Assertions.assertNotEquals(-1, statistics.getItemsPlanToWatch());
        Assertions.assertNotEquals(-1, statistics.getItemsDropped());
        Assertions.assertNotEquals(-1, statistics.getItemsOnHold());
        Assertions.assertNotEquals(-1, statistics.getItems());
        Assertions.assertNotEquals(-1, statistics.getDaysWatched());
        Assertions.assertNotEquals(-1, statistics.getDaysWatching());
        Assertions.assertNotEquals(-1, statistics.getDaysCompleted());
        Assertions.assertNotEquals(-1, statistics.getDaysOnHold());
        Assertions.assertNotEquals(-1, statistics.getDaysDropped());
        Assertions.assertNotEquals(-1, statistics.getDays());
        Assertions.assertNotEquals(-1, statistics.getEpisodes());
        Assertions.assertNotEquals(-1, statistics.getTimesRewatched());
        Assertions.assertNotEquals(-1, statistics.getMeanScore());
    }

    @Test // test does actually pass
    public void testBirthday(){
        Assumptions.assumeFalse(user.getBirthday() == -1, "User might not specify a birthday");
    }

}