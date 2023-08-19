package zhanuzak.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "field can not be empty")
    private String name;
    @NotNull(message = "field can not be empty")
    private  String address;
    @OneToMany
    private List<Doctor>doctors;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private List<Patient>patients;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Department>departments;
    @OneToMany
    private List<Appointment>appointments;

    public void addDepartment(Department department) {
        if (departments==null){
            departments=new ArrayList<>();
        }else{
            departments.add(department);
        }
    }
}
