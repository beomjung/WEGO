package kopo.poly.controller.rest;


import kopo.poly.dto.UserDto;
import kopo.poly.dto.UserEventDTO;
import kopo.poly.service.IUserEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static kopo.poly.constant.UserConstants.USER_SESSION_KEY;

@RequiredArgsConstructor
@Slf4j
@RestController
public class UserEventController {


    private final IUserEventService userEventService;

    /**
     * 사용자 일정 조회
     * @param
     * @return JSON ARRAY (Event List)
     * @throws Exception
     */
    @GetMapping(value = "/event")
    public ResponseEntity<List<UserEventDTO>> getEventList(HttpSession session) throws Exception {
        final UserDto user = (UserDto) session.getAttribute(USER_SESSION_KEY);

        return ResponseEntity.ok().body(userEventService.getUserEvent(user));
    }

    @PostMapping(value = "/event")
    public ResponseEntity<UserEventDTO> saveEvent() throws Exception {

    }

    @PatchMapping

    @DeleteMapping(value = "/event/{id}")
    public ResponseEntity<Integer> deleteEvent(@PathVariable("id") int id) {

    }
}
