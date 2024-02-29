package com.cis.batch33.library.model;
import com.cis.batch33.library.entity.LibraryMember;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
public class MemberDTO {
    private long memberId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Long phoneNumber;
    private String memberShipLevel;
}
