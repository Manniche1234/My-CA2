package facades;

import dtos.PlayerDTO;
import dtos.UserDTO;
import entities.Player;
import entities.Role;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import security.errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public UserDTO createUser (UserDTO userDTO){
        EntityManager em = emf.createEntityManager();
        User user = new User(userDTO);
        Role userRole = new Role("user");
        user.addRole(userRole);

        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return new UserDTO(user);
    }


    public UserDTO deleteUser (String userName){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            User user = em.find(User.class,userName);
            em.remove(user);
            em.getTransaction().commit();
            return new UserDTO(user);
        }finally {
            em.close();
        }
    }


    public UserDTO addPlayerToUser(String username, PlayerDTO playerdto){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            User user = em.find(User.class,username);
            user.addPlayer(new Player(playerdto.getfirst_name(),playerdto.getLast_name()));
            em.merge(user);
            em.getTransaction().commit();
            return new UserDTO(user);
        }finally {
            em.close();
        }
    }

        public UserDTO seeAllPlayerWithUserId(String username){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.userName=:username", User.class);
            query.setParameter("username",username);
            User user = query.getSingleResult();
            return new UserDTO(user);
        }finally {
            em.close();
        }
    }


}
