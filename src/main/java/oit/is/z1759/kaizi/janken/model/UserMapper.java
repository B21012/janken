package oit.is.z1759.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT * from users;")
  ArrayList<User> selectAllUsers();

  @Select("SELECT * from users where id = #{id};")
  User selectAllById(int id);

}
