package oit.is.z1759.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  // @Select("SELECT id,userName from users where id = #{id}")
  // User selectById(int id);

  @Select("SELECT * from matches;")
  ArrayList<Match> selectAllMatches();

}
