package com.nt.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="BOOT_EMP")
@Data
@AllArgsConstructor
@SQLDelete(sql="Update BOOT_EMP set STATUS='deleted' where empno=?")
@SQLRestriction(value="STATUS <> 'deleted'")
public class Employee implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @SequenceGenerator(name="gen1", sequenceName="emp_id_seq", initialValue=1, allocationSize=1)
    @GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
    private Integer empno;
    @Column(length=20)
    private String ename;
    @Column(length=20)
    private String job;
    private Float sal;
    private Integer deptno;
    private String status="active";
    
    // Default constructor (required by Hibernate if using @Data without @NoArgsConstructor)
    public Employee() {}
}