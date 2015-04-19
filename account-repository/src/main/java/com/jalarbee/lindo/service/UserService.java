package com.jalarbee.lindo.service;

import com.jalarbee.lindo.domain.User;
import com.jalarbee.lindo.domain.UserReview;

import java.util.List;

/**
 * @author Abdoulaye Diallo
 */
public interface UserService {


    UserReview review(String username, String organization, String content, int rating);
    List<UserReview> getUserReviews(String username, String organization);
    boolean changeUserPassword(String username, String password);
    User getUser(String username);
}
