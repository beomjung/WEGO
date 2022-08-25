package kopo.poly.service;

import kopo.poly.dto.UserDto;

public interface IUserService {

    UserDto saveUserInfo(final UserDto request) throws Exception;

    UserDto userLogin(final UserDto request) throws Exception;

    UserDto updateUserInfo(final UserDto request) throws Exception;

}
