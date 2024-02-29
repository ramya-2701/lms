package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.AddressDTO;
import com.cis.batch33.library.model.CheckoutDTO;
import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.repository.LIbraryMemberRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MemberService{


    @Autowired
    private LIbraryMemberRepository memberRepository;

    public LibraryMember createMember(LibraryMember member){
    //  map DTO to Entity

        // call the database
        Integer memberId = new Random().nextInt();
        member.setMemberId(memberId);

       return memberRepository.save(member);
    }

    public Member getMember(Integer memberId) {

       Optional<LibraryMember> memberOptional =
               memberRepository.findById(memberId);
       LibraryMember libraryMember =
               memberOptional.orElse(new LibraryMember());

       Member member = new Member();
       member.setMemberId(libraryMember.getMemberId());
       member.setMemberShipLevel(libraryMember.getMemberShipLevel());
       member.setEmailAddress(libraryMember.getEmailAddress());
       member.setFirstName(libraryMember.getFirstName());
       member.setLastName(libraryMember.getLastName());
       member.setPhoneNumber(libraryMember.getPhoneNumber());

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(libraryMember.getAddress().getAddressId());
        addressDTO.setLine1(libraryMember.getAddress().getLine1());
        addressDTO.setLine2(libraryMember.getAddress().getLine2());
        addressDTO.setCity(libraryMember.getAddress().getCity());
        addressDTO.setState(libraryMember.getAddress().getState());
        addressDTO.setZip(libraryMember.getAddress().getZip());

        List<CheckoutDTO> checkoutDTOS =
        libraryMember.getCheckouts().stream().map(c -> {
            CheckoutDTO cdo = new CheckoutDTO();
            cdo.setId(c.getId());
            cdo.setIsbn(c.getIsbn());
            cdo.setCheckoutDate(c.getCheckoutDate());
            cdo.setDueDate(c.getDueDate());
            cdo.setReturned(c.isReturned());
            return  cdo;
        }).collect(Collectors.toList());

        member.setAddress(addressDTO);
        member.setCheckouts(checkoutDTOS);

        return member;
    }
    public LibraryMember updateMember(LibraryMember member) {
        //Integer memberId = member.getMemberId();
        //memberMap.put(memberId, LibraryMember);
        return memberRepository.save(member);
    }

}

// relational databases ( SQL )
    // tables and rows, foreign key, structured
    // mysql, oracle, postgres, db2, H2 Microsoft Sql Server
    // SQL - structured query language
    // programming -
    // create and manage tables - DDL - data definition language
    // create and manage data within tables - DML - Data manipulation
    // access control - DCL - data control language
    // install mysql
// TOAD, mysql workbench - IDE

// non- relational databases ( No-SQL)
    // unstructured
    // document based - mongodb,
    // key value database - redis, dynamodb,  cassandra
    // graph database -


// schema
    // tables
        // rows and columns
    // functions -
    // stored procedures -

// user name and password


// JAVA to Database connectivity

        //  JDBC package , java.sql.*

        // Connection - url, username and password, mysql - driver
        // PreparedStatement
        // ResultSet
        // CallabaleStatement

// ORM - object relational mapping
// JPA Repositories

// GET POST PUT DELETE - member and book

//GET
// Member DTO with address and checkouts
// Book DTO with all ISBNS and all Checkouts

// POST and PUT

// Member DTO along with Address,
// Book DTO along with isbns,
