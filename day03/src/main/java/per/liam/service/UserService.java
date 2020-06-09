package per.liam.service;

import per.liam.dao.UserDao;
import per.liam.domain.User;

/**
 * @author liam
 * @date 2020/6/2 10:12
 */
public class UserService {
    public boolean checkUser(User user) {
        UserDao userDao = new UserDao();
        return userDao.checkUser(user);
    }

    public boolean addUser(User user) {
        UserDao userDao = new UserDao();
        return userDao.addUser(user);
    }
}
