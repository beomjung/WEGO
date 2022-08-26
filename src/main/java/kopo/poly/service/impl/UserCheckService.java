package kopo.poly.service.impl;

import kopo.poly.jpa.UserRepository;
import kopo.poly.jpa.entity.UserEntity;
import kopo.poly.service.IUserCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserCheckService implements IUserCheckService {
    private final UserRepository userRepository;

    // 중복된 사용자 아이디가 있다면 true, or false
    public boolean isDuplicatedUserId(final String userId) {
        return userRepository.findByUserId(userId).isPresent() ? true : false;
    }


    // 중복된 닉네임이 있다면 true, or false
    @Override
    public boolean isDuplicatedUserNickName(final String userNickName) throws Exception {
        return userRepository.findByUserNickname(userNickName).isPresent() ? true : false;
    }
}
