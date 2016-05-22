package net.lermex.inaction.helper.Impl;

import net.lermex.inaction.helper.UserService;
import net.lermex.inaction.model.entity.User;
import net.lermex.inaction.model.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addUser(User user) {
        userRepository.saveAndFlush( new User(user.getEmail(), DigestUtils.sha256Hex(user.getPassword())) );
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

}
