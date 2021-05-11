package com.github.abhishek.user.Service;
import com.github.abhishek.user.Entity.User;
import com.github.abhishek.user.Repository.UserRepository;
import com.github.abhishek.user.valueObject.Department;
import com.github.abhishek.user.valueObject.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    //create the object of User Repository
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplate getDepartmentWithUser(Long userId) {
        log.info("Inside getDepartmentWithUser method of UserService");
        //Return the ReponseTemplate
        //Create Object for that
        ResponseTemplate responseTemplate = new ResponseTemplate();
        //Get the user Object
        User user = userRepository.findByUserId(userId);
        //Now we need to get the department for the user
        //So we need to call the department service to get the department
        //So we need a rest Template to call the department Service, a rest call
        //We made use of HostName in the uri so as to make it HA
        Department department = restTemplate
                .getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId()
                ,Department.class);
        //Now need to set the department and the respv user in the view so
        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }
}
