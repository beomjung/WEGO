package kopo.poly.service.impl;

import kopo.poly.dto.UserDto;
import kopo.poly.dto.UserEventDTO;
import kopo.poly.exception.UserException;
import kopo.poly.exception.result.UserExceptionResult;
import kopo.poly.jpa.UserEventRepository;
import kopo.poly.jpa.entity.UserEventEntity;
import kopo.poly.mapper.UserEventMapper;
import kopo.poly.service.IUserEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static kopo.poly.constant.UrlConstants.INDEX_URL;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserEventService implements IUserEventService {

    private final UserEventRepository userEventRepository;

    @Override
    public UserEventDTO saveUserEvent(UserEventDTO request) throws Exception {
        return null;
    }

    @Override
    public List<UserEventDTO> getUserEvent(UserDto request) throws Exception {

        List<UserEventEntity> eventList = userEventRepository.findByUserId(request.getUserId())
                .orElse(new ArrayList<>());

        List<UserEventDTO> result = new ArrayList<>();

        for(UserEventEntity event : eventList) {
            result.add(UserEventMapper.INSTANCE.userEventEntityToUserEventDTO(event));
        }

        return result;
    }

    @Override
    public UserEventDTO changeUserEvent(UserEventDTO request) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteUserEvent(UserEventDTO request) throws Exception {
        return null;
    }
}
