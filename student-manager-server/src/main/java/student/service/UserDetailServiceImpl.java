package student.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import student.dao.UserDao;

import javax.annotation.Resource;

/**
 * @author hui
 * @date 2022-01-08 10:23:36
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getByUsername(username);
    }
}
