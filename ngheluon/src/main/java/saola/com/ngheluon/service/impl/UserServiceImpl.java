package saola.com.ngheluon.service.impl;

import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.User;
import saola.com.ngheluon.service.UserService;

import java.util.UUID;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UUID> implements UserService {
}
