package com.example.greencommute.respository;

import com.example.greencommute.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select U from User U where U.userName=:userName")
    User getUserByUserName(@Param("userName") String userName);

    @Modifying
    @Query("delete from User U where U.userName=:userName")
    void deleteUserByUserName(@Param("userName") String userName);

}
