package com.crag.rtmtoekn.controller;

import com.crag.rtmtoekn.rtm.RtmTokenBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class Controller {

    @GetMapping("/appId/{appId}/appCertificate/{appCertificate}/userId/{userId}")
    public ResponseEntity<String> getToken(
            @PathVariable String appId,
            @PathVariable String appCertificate,
            @PathVariable String userId
    ) throws Exception {
               RtmTokenBuilder token = new RtmTokenBuilder();
        int expireTimestamp = 0;
        String result = token.buildToken(appId, appCertificate, userId, RtmTokenBuilder.Role.Rtm_User, expireTimestamp);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
