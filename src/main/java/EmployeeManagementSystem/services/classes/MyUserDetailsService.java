package EmployeeManagementSystem.services.classes;

import EmployeeManagementSystem.dao.EmployeeRepo;
import EmployeeManagementSystem.entity.Employee;
import EmployeeManagementSystem.entity.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee emp = employeeRepo.findByEmail(username);
        if(emp == null)
        {
            System.out.println("User not Found and going to throw the exception");
            throw new UsernameNotFoundException("User not found");
        }
        return new EmployeeDetail(emp);

    }
}
