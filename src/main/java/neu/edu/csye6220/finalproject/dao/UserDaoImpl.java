package neu.edu.csye6220.finalproject.dao;

import neu.edu.csye6220.finalproject.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(User user) {
        getSession().save(user);
    }

    @Override
    public void delete(Long id) {
        User user = get(id);
        getSession().delete(user);
    }

    @Override
    public User get(Long id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    public void update(User user) {
        getSession().merge(user);
    }

    @Override
    public User getByUsername(String username)
    {
        String hql = "FROM User U WHERE U.name = :name";
        return getSession()
                .createQuery(hql, User.class)
                .setParameter("name", username)
                .uniqueResult();
    }

    @Override
    public List<User> getUserListByIds(List<Long> userIds)
    {
        String hql = "FROM User WHERE id in (:userIdList)";
        return getSession()
                .createQuery(hql, User.class)
                .setParameterList("userIdList", userIds)
                .getResultList();
    }

    @Override
    public List<User> searchUsersByKeyword(String keyword)
    {
        String hql = "FROM User WHERE name like :keyword";
        return getSession()
                .createQuery(hql, User.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }
}
