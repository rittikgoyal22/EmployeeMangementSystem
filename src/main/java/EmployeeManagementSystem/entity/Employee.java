package EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(schema = "employee")
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name="password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
