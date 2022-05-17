package fr.utc.sr03.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("channels")
public class ChannelController {
    @GetMapping
    public String getChannels(Model model) {
        return "channel_list";
    }
}
