package kopo.poly.service;

import kopo.poly.dto.UserDto;
import kopo.poly.dto.UserEventDTO;

import java.util.List;

public interface IUserEventService {

    UserEventDTO saveUserEvent(final UserEventDTO request) throws Exception;

    List<UserEventDTO> getUserEvent(final UserDto request) throws Exception;

    UserEventDTO changeUserEvent(final UserEventDTO request) throws Exception;

    Boolean deleteUserEvent(final UserEventDTO request) throws Exception;
}
