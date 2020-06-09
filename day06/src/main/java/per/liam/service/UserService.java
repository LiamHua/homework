package per.liam.service;

import per.liam.dao.UserDao;
import per.liam.domain.User;

import java.util.List;

/**
 * @author liam
 * @date 2020/6/8 23:31
 */
public class UserService {
    public List<User> searchUserService(String username) {
        UserDao userDao = new UserDao();
        return userDao.searchUser(username);
    }
}
