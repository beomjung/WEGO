package kopo.poly.controller.rest;

import kopo.poly.dto.UserDto;
import kopo.poly.service.IUserCheckService;
import kopo.poly.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static kopo.poly.constant.UserConstants.USER_ID_HEADER;
import static kopo.poly.constant.UserConstants.USER_NICK_NAME_HEADER;

/**
 * Ajax 로 요청 시 사용
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserCheckController {
    private final IUserCheckService userCheckService;

    /**
     * 사용자 아이디 중복 확인
     * @param userId
     * @return 1 or 0 , {1 : 사용자 아이디 중복}, {0 : 사용 가능한 사용자 아이디}
     * @throws Exception
     */
    @GetMapping("/users/check/id")
    public ResponseEntity<Integer> checkDuplicatedUserId(
            @RequestHeader(USER_ID_HEADER) final String userId) throws Exception {
        log.debug("checkUserId");

        return ResponseEntity.ok().body(userCheckService.isDuplicatedUserId(userId) ? 1 : 0);

    }

    /**
     * 사용자 닉네임 중복 확인
     * @param userNickName
     * @return 1 or 0 , {1 : 사용자 닉네임 중복}, {0 : 사용 가능한 사용자 아이디}
     * @throws Exception
     */
    @GetMapping("/users/check/nickname")
    public ResponseEntity<Integer> checkDuplicatedUserNickName(
            @RequestHeader(USER_NICK_NAME_HEADER) final String userNickName) throws Exception {
        log.debug("checkUserNickName");


        return ResponseEntity.ok().body(userCheckService.isDuplicatedUserNickName(userNickName) ? 1 : 0);
    }
}
