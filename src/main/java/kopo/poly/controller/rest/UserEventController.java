package kopo.poly.controller.rest;


import kopo.poly.dto.UserDto;
import kopo.poly.dto.UserEventDTO;
import kopo.poly.jpa.UserRepository;
import kopo.poly.jpa.entity.UserEntity;
import kopo.poly.mapper.UserEventMapper;
import kopo.poly.mapper.UserMapper;
import kopo.poly.service.IUserEventService;
import kopo.poly.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Boolean> saveEvent(final HttpServletRequest request, HttpSession session) throws Exception {
        final UserDto user = (UserDto) session.getAttribute(USER_SESSION_KEY);

        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(user);


        return ResponseEntity.ok().body(userEventService.saveUserEvent(UserEventDTO.builder()
                .user(userEntity)
                .eventName(request.getParameter("eventName"))
                .eventStartDate(request.getParameter("eventStartDate"))
                .eventEndDate(request.getParameter("eventEndDate")).build()));
    }

    @PatchMapping(value = "/event")
    public ResponseEntity<UserEventDTO> updateEvent(final HttpServletRequest request, HttpSession session) throws Exception {
        final UserDto user = (UserDto) session.getAttribute(USER_SESSION_KEY);

        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(user);

        return ResponseEntity.ok().body(userEventService.updateUserEvent(UserEventDTO.builder()
                .user(userEntity)
                .eventSeq(Integer.valueOf(request.getParameter("eventSeq")))
                .eventName(request.getParameter("eventName"))
                .eventStartDate("eventStartDate")
                .eventEndDate("eventEndDate")
                .build()));
    }

    /**
     * 일정 삭제
     * Param : 일정 Seq
     * Return : Boolean
     */
    @DeleteMapping(value = "/event")
    public ResponseEntity<Boolean> deleteEvent(final HttpServletRequest request, HttpSession session) throws Exception {

        final UserDto user = (UserDto) session.getAttribute(USER_SESSION_KEY);

        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(user);

        return ResponseEntity.ok().body(userEventService.deleteUserEvent(UserEventDTO.builder()
                .user(userEntity)
                .eventSeq(Integer.valueOf(request.getParameter("eventSeq")))
                .build()));
    }
}
