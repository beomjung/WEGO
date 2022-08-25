package kopo.poly.service.impl;

import kopo.poly.dto.UserDto;
import kopo.poly.exception.UserException;
import kopo.poly.exception.result.UserExceptionResult;
import kopo.poly.jpa.UserRepository;
import kopo.poly.jpa.entity.UserEntity;
import kopo.poly.mapper.UserMapper;
import kopo.poly.service.IUserService;
import kopo.poly.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static kopo.poly.constant.UrlConstants.INDEX_URL;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserCheckService userCheckService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDto saveUserInfo(final UserDto request) throws Exception {
        log.debug("save User Start");

        // 사용자 로그인 검증 로직
        if (userCheckService.isDuplicatedUserId(String.valueOf(request.getUserId()))) {
            throw new UserException(UserExceptionResult.DUPLICATED_USER_ID_REGISTER, INDEX_URL); // 중복된 사용자 아이디
        }

        if (userCheckService.isDuplicatedUserNickName(String.valueOf(request.getUserNickname()))) {
            throw new UserException(UserExceptionResult.DUPLICATED_USER_NICKNAME_REGISTER, INDEX_URL);
        }

        log.debug("사용자 로그인 유효성 검사 End");
        // TODO: 2022/08/24 File 정보 받아오기

        final UserEntity result = userRepository.save(this.getUserEntityWithEncryptPasswordAndEmail(request));

        log.debug("save User End");

        return UserMapper.INSTANCE.userEntityToUserDto(result);
    }

    private UserEntity getUserEntityWithEncryptPasswordAndEmail(final UserDto userDto) throws Exception {
        final String encUserPassword = EncryptUtil.encHashSHA256(userDto.getUserPassword());
        final String encUserEmail = EncryptUtil.encAES128CBC(userDto.getUserEmail());

        return UserEntity.builder()
                .userId(userDto.getUserId())
                .userPassword(encUserPassword)
                .userEmail(encUserEmail)
                .userName(userDto.getUserName())
                .userNickname(userDto.getUserNickname())
                .userAge(userDto.getUserAge())
                .userAddress(userDto.getUserAddress())
                .userGender(userDto.getUserGender())
                .userIntroduction(userDto.getUserIntroduction())
                .memberSince(userDto.getMemberSince())
                .roomKey(userDto.getRoomKey()).build();
    }

    @Override
    public UserDto userLogin(final UserDto request) throws Exception {
        log.debug("userLogin");
        // 사용자 아이디를 사용하여 사용자 조회 없을 경우 Exception
        UserEntity user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new UserException(UserExceptionResult.USER_NOT_FOUND, INDEX_URL));

        log.debug("사용자 아이디 : " + user.getUserId());

        // 비밀번호 일치하지 않는다면, Exception
        if (!EncryptUtil.encHashSHA256(request.getUserPassword()).equals(user.getUserPassword())) {
            throw new UserException(UserExceptionResult.USER_PASSWORD_NOT_MATCHES, INDEX_URL);
        }


        return UserMapper.INSTANCE.userEntityToUserDto(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDto updateUserInfo(UserDto request) throws Exception {
        log.debug("사용자 정보 Update");

        // TODO: 2022/08/24 사용자 정보 변경 시 비밀번호 일치 여부 확인

        UserEntity user = userRepository.findByUserId(String.valueOf(request.getUserId()))
                .orElseThrow(() -> new UserException(UserExceptionResult.USER_NOT_FOUND, INDEX_URL));

        return UserMapper.INSTANCE.userEntityToUserDto(
                userRepository.save(UserEntity.builder()
                        .userSeq(user.getUserSeq())
                        .userId(user.getUserId())
//                        .userEmail(user.getUserEmail())
//                        .userName(user.getUserName())
                        // 변경되는 정보
                        .userGender(request.getUserGender())
                        .userAge(request.getUserAge())
                        .userAddress(request.getUserAddress()).build()));
    }
}
