package com.jalarbee.lindo.service.impl;

import com.jalarbee.lindo.dao.MembershipReviewDao;
import com.jalarbee.lindo.dao.UserDao;
import com.jalarbee.lindo.dao.UserReviewDao;
import com.jalarbee.lindo.domain.User;
import com.jalarbee.lindo.domain.UserReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abdoulaye Diallo
 */

@Service
public class UserService implements com.jalarbee.lindo.service.UserService {

    @Autowired private UserDao userDao;
    @Autowired private MembershipReviewDao membershipReviewDao;
    @Autowired private UserReviewDao userReviewDao;

    @Override
    public UserReview review(String username, String organization, String content, int rating) {
        return null;
    }

    @Override
    public List<UserReview> getUserReviews(String username, String organization) {
        return null;
    }

    @Override
    public boolean changeUserPassword(String username, String password) {
        return true;
    }

    @Override
    public User getUser(String username) {
        return null;
    }
}
