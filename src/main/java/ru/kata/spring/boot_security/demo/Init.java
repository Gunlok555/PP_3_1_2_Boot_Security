package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class Init {


    private UserService userService;
    private RoleService roleService;


    @Autowired
    public Init(UserService userService, RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createTable() {
        if (roleService.getList().isEmpty()) {
            Role admin = new Role(1, "ROLE_ADMIN");
            Role user = new Role(2, "ROLE_USER");
            roleService.addRole(admin);
            roleService.addRole(user);

            List<Role> setRole1 = new ArrayList<>();
            setRole1.add(admin);
            List<Role> setRole2 = new ArrayList<>();
            setRole2.add(user);
            List<Role> setRole3 = new ArrayList<>();
            setRole3.add(admin);
            setRole3.add(user);

            User adminUser1 = new User("adminUser", "MegaAdminAndUser", 111, "adminUser@gmail.com",
                    "$2a$12$/V8QItpaDlzt62enZ6jy2ufUPmPfwcmxrBT2M0f903zBDKL3imX6i", setRole3);

            User user1 = new User("user", "MainUser", 55, "user@gmail.com",
                    "$2a$12$QEP7TBCJvY2BIA1ez4uSE.TOfSayI40I8.fv/gRZHczVN2H/uqOMq", setRole2);

            User admin1 = new User("admin", "MainAdmin", 99, "admin1@gmail.com",
                    "$2a$12$cMXTYl25dfJ616oWo5CjhOsZIXYdQSDyIorgNrYN4cCn4PLrVKwjC", setRole1);

            userService.addUser(admin1);
            userService.addUser(user1);
            userService.addUser(adminUser1);

            System.out.println(
                    "login: admin      password: admin \n" +
                            "login: user       password: user \n" +
                            "login: adminUser  password: adminUser");
        }
    }

}
