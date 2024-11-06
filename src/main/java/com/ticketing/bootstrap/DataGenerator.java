package com.ticketing.bootstrap;

import com.github.javafaker.Faker;
import com.ticketing.dto.ProjectDTO;
import com.ticketing.dto.RoleDTO;
import com.ticketing.dto.TaskDTO;
import com.ticketing.dto.UserDTO;
import com.ticketing.enums.Gender;
import com.ticketing.enums.Status;
import com.ticketing.service.ProjectService;
import com.ticketing.service.RoleService;
import com.ticketing.service.TaskService;
import com.ticketing.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.util.*;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole= new RoleDTO(1L,"Admin");
        RoleDTO managerRole= new RoleDTO(2L,"Manager");
        RoleDTO employeeRole= new RoleDTO(3L,"Employee");
        roleService.save(adminRole);roleService.save(managerRole);roleService.save(employeeRole);



        UserDTO user1=new UserDTO("John","Kessy","john@gmail.com","07435983719","Abc1","Abc1", Gender.MALE, managerRole);
        UserDTO user2=new UserDTO("Mike","Smith","mike@gmail.com","07435983239","Abc2","Abc1", Gender.MALE, adminRole);
        UserDTO user3=new UserDTO("Delisa","Norre","delisa@gmail.com","07432345719","Abc3","Abc1", Gender.FEMALE, managerRole);
        UserDTO user4=new UserDTO("Craig","Jark","craig@gmail.com","07485983719","Abc4","Abc1", Gender.MALE, employeeRole);
        UserDTO user5=new UserDTO("Shaun","Hayns","shaun@gmail.com","07435983245","Abc5","Abc1", Gender.MALE, managerRole);
        UserDTO user6=new UserDTO("Elizabeth","Loren","elizabeth@gmail.com","0743527364","Abc6","Abc1", Gender.FEMALE, employeeRole);
        UserDTO user7=new UserDTO("Maria","Ada","maria@gmail.com","07435934567","Abc7","Abc1", Gender.FEMALE, employeeRole);
        UserDTO user8=new UserDTO("Bill","Matt","bill@gmail.com","07435483736","Abc8","Abc1", Gender.MALE, employeeRole);
        UserDTO user9= new UserDTO("Kerem","Sahin","kerem@gmail.com","07385677875","Abc9","Abc1",Gender.MALE,managerRole);
        UserDTO user10= new UserDTO("Ufuk","Arpaci","ufuk@gmail.com","07385999999","Abc10","Abc1",Gender.MALE,employeeRole);
        userService.save(user1); userService.save(user2); userService.save(user3); userService.save(user4);userService.save(user5);
        userService.save(user6);userService.save(user7); userService.save(user8);userService.save(user9); userService.save(user10);

        //createRandomUsers(10);


        ProjectDTO project1=new ProjectDTO("Spring MVC","PR001",user1, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Controllers", Status.OPEN);
        ProjectDTO project2=new ProjectDTO("Spring ORM","PR002",user2, LocalDate.now(),LocalDate.now().plusDays(10),"Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3=new ProjectDTO("Spring Container","PR003",user1, LocalDate.now(),LocalDate.now().plusDays(32),"Creating Container", Status.IN_PROGRESS);
        projectService.save(project1);projectService.save(project2);projectService.save(project3);


        TaskDTO task1=new TaskDTO(1L,project1,user8,"Controller","Request Mapping",LocalDate.now().minusDays(4),Status.IN_PROGRESS);
        TaskDTO task2=new TaskDTO(2L,project3,user3,"Configuration","Database Connection",LocalDate.now().minusDays(12),Status.COMPLETE);
        TaskDTO task3=new TaskDTO(3L,project3,user6,"Mapping","One-To-Many",LocalDate.now().minusDays(8),Status.COMPLETE);
        TaskDTO task4=new TaskDTO(4L,project2,user7,"Dependency Injection","Autowired",LocalDate.now().minusDays(20),Status.IN_PROGRESS);
        taskService.save(task1);taskService.save(task2);taskService.save(task3);taskService.save(task4);

    }

    private void createRandomUsers(int userCount){
        Faker faker= new Faker();
        Random random= new Random();
        String firstName="";String lastName="";String userName="";String phone="";String passWord="";

        Gender gender=null; List<Gender> genders=Arrays.asList(Gender.values());

        RoleDTO role=null;
        List<RoleDTO> roles= new ArrayList<>();
        RoleDTO adminRole= new RoleDTO(1L,"Admin");
        RoleDTO managerRole= new RoleDTO(2L,"Manager");
        RoleDTO employeeRole= new RoleDTO(3L,"Employee");
        roles.add(adminRole); roles.add(managerRole); roles.add(employeeRole);

        for (int i = 0; i <userCount ; i++) {
            firstName=faker.name().firstName();lastName=faker.name().lastName();userName=faker.internet().emailAddress();
            phone=faker.phoneNumber().cellPhone();passWord=faker.internet().password();
            gender=genders.get(random.nextInt(genders.size()));
            role=roles.get(random.nextInt(roles.size()));

            UserDTO user= new UserDTO(firstName,lastName,userName,phone,passWord,passWord,gender,role);
            userService.save(user);

        }

    }
}
