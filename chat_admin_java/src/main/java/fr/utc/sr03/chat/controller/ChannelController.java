package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.ChannelRepository;
import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.model.Channel;
import fr.utc.sr03.chat.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * URL du endpoint : http://localhost:8080/channels
 * ex channels : http://localhost:8080/channels?userId=1
 */
@Controller
@RequestMapping("channels")
public class ChannelController {
    @Autowired
    private ChannelRepository channelRepository;

    @GetMapping
    @ResponseBody
    public List<Channel> getChannelsByUser(@RequestParam long userId) {
        return channelRepository.findByOwner(userId);
    }
}
