package com.api.system.registration.Service;

import com.api.system.registration.Entity.Login;
import com.api.system.registration.Repository.LoginRepository;
import com.api.system.registration.Service.Interface.LoginService;
import com.api.system.registration.Service.LoginDTO.LoginDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
@Service
public class LoginServiceImpl implements LoginService {
    private final EntityManager entityManager;
    private final LoginRepository loginRepository;

    public LoginServiceImpl(EntityManager entityManager, LoginRepository loginRepository) {
        this.entityManager = entityManager;
        this.loginRepository = loginRepository;
    }


    @Override
    public LoginDTO findByUserNameAndPassword(String userName, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //Donus icin
        CriteriaQuery<String> loginCriteriaQuery = criteriaBuilder.createQuery(String.class);
        //sql-from
     /*   Root<Login> root = loginCriteriaQuery.from(Login.class);
//        Selection<?> selection=root.get()
        loginCriteriaQuery.select(root.get("login"));
        //where RoomBookng.sumSprice = 10
        Predicate nameSurname = criteriaBuilder.equal(root.get("userName"),userName);
        Predicate password1 = criteriaBuilder.equal(root.get("password"),password);
        loginCriteriaQuery.where(criteriaBuilder.and(nameSurname),criteriaBuilder.and(password1));*/

        return (LoginDTO) entityManager.createQuery(loginCriteriaQuery).getResultList();
    }

}
