package kopo.poly.service;

public interface IUserCheckService {

    boolean isDuplicatedUserId(final String userId) throws Exception;

    boolean isDuplicatedUserNickName(final String userNickName) throws Exception;
}
