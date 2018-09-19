package com.socialfeed.controller;

import com.socialfeed.model.UserAccount;
import com.socialfeed.repository.AccountRepository;
import com.socialfeed.repository.FeedPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FeedPostRepository feedRepository;

    @PostMapping("/register")
    @ResponseBody
    public UserAccount registerUser(@RequestBody UserAccount userAccount) {
        return accountRepository.save(userAccount);
    }

    @GetMapping("/users")
    @ResponseBody
    public List<UserAccount> getAllUsers() {
        return accountRepository.findAll();
    }

    @GetMapping(value = "/status")
    public String status() {
        return "Social feed is live!";
    }

}
