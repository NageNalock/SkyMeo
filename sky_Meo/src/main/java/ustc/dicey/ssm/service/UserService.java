package ustc.dicey.ssm.service;

import ustc.dicey.ssm.pojo.User;

import java.util.List;

public interface UserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
}
