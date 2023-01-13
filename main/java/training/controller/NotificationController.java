package training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

  @RequestMapping(value = "/searchNotification", method = RequestMethod.GET)
  @ResponseBody
  public Object test(@RequestParam("memberId") String memberId) {
    return "df";
  }
}
